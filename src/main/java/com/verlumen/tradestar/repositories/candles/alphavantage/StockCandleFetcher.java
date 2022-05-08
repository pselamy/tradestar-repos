package com.verlumen.tradestar.repositories.candles.alphavantage;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.parameters.Interval;
import com.crazzyghost.alphavantage.timeseries.TimeSeries;
import com.crazzyghost.alphavantage.timeseries.response.StockUnit;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;
import com.verlumen.tradestar.protos.candles.Candle;
import com.verlumen.tradestar.protos.candles.Granularity;
import com.verlumen.tradestar.protos.instruments.Instrument;

import java.time.Instant;
import java.util.Optional;
import java.util.TimeZone;

import static com.google.common.collect.ImmutableSet.toImmutableSet;
import static java.util.TimeZone.getTimeZone;

class StockCandleFetcher implements CandleFetcher {
    private static final ImmutableMap<Granularity, ProxyFactory> FACTORIES =
            ImmutableMap.<Granularity, ProxyFactory>builder()
                    .put(Granularity.ONE_MINUTE, intraDay(Interval.ONE_MIN))
                    .put(Granularity.FIVE_MINUTES, intraDay(Interval.FIVE_MIN))
                    .put(Granularity.FIFTEEN_MINUTES,
                            intraDay(Interval.FIFTEEN_MIN))
                    .put(Granularity.ONE_HOUR, intraDay(Interval.SIXTY_MIN))
                    .put(Granularity.ONE_DAY, TimeSeries::daily)
                    .build();

    private final TimeFormatter timeFormatter;
    private final TimeSeries timeSeries;

    @Inject
    StockCandleFetcher(TimeFormatter timeFormatter, AlphaVantage alphaVantage) {
        this.timeFormatter = timeFormatter;
        this.timeSeries = alphaVantage.timeSeries();
    }

    private static ProxyFactory intraDay(Interval interval) {
        return (timeSeries) -> timeSeries.intraday().interval(interval);
    }

    @Override
    public ImmutableSet<Candle> fetch(
            Instrument instrument, Granularity granularity) {
        TimeSeriesResponse timeSeriesResponse = proxyFactory(granularity)
                .map(factory -> factory.create(timeSeries))
                .map(requestProxy -> requestProxy
                        .forSymbol(instrument.getSymbol())
                        .fetchSync())
                .orElseThrow(UnsupportedOperationException::new);
        TimeZone timeZone =
                getTimeZone(timeSeriesResponse.getMetaData().getTimeZone());

        return timeSeriesResponse
                .getStockUnits()
                .stream()
                .map(stockUnit -> createCandle(stockUnit, timeZone))
                .collect(toImmutableSet());
    }

    private Candle createCandle(StockUnit stockUnit, TimeZone timeZone) {
        Candle.Builder builder = Candle.newBuilder();
        Instant start = timeFormatter.format(stockUnit.getDate(), timeZone);
        builder.getStartBuilder().setSeconds(start.getEpochSecond());
        return builder
                .setOpen(stockUnit.getOpen())
                .setHigh(stockUnit.getHigh())
                .setLow(stockUnit.getLow())
                .setClose(stockUnit.getClose())
                .setVolume(stockUnit.getVolume())
                .build();
    }

    private Optional<ProxyFactory> proxyFactory(Granularity granularity) {
        return Optional.ofNullable(FACTORIES.get(granularity));
    }

    @Override
    public Instrument.Type instrumentType() {
        return Instrument.Type.STOCK;
    }

    interface ProxyFactory {
        TimeSeries.RequestProxy<?, TimeSeriesResponse> create(TimeSeries timeSeries);
    }
}
