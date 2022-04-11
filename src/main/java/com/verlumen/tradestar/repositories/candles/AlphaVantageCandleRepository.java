package com.verlumen.tradestar.repositories.candles;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.Fetcher;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Range;
import com.google.inject.Inject;
import com.verlumen.tradestar.protos.candles.Candle;
import com.verlumen.tradestar.protos.candles.Granularity;
import com.verlumen.tradestar.protos.instruments.Instrument;

import java.time.Instant;
import java.util.function.Function;

class AlphaVantageCandleRepository implements CandleRepository {
    private static final ImmutableMap<Instrument.Type,
            Function<AlphaVantage, Fetcher>> FETCHERS =
            ImmutableMap
                    .<Instrument.Type, Function<AlphaVantage, Fetcher>>builder()
                    .put(Instrument.Type.STOCK, AlphaVantage::timeSeries)
                    .put(Instrument.Type.CRYPTO, AlphaVantage::crypto)
                    .put(Instrument.Type.EXCHANGE_RATE, AlphaVantage::exchangeRate)
                    .put(Instrument.Type.FOREX, AlphaVantage::forex)
                    .put(Instrument.Type.FUNDAMENTALS, AlphaVantage::fundamentalData)
                    .put(Instrument.Type.INDICATOR, AlphaVantage::indicator)
                    .put(Instrument.Type.SECTOR, AlphaVantage::sector)
                    .build();

    private final AlphaVantage api;

    @Inject
    AlphaVantageCandleRepository(AlphaVantage api) {
        this.api = api;
    }

    @Override
    public ImmutableSet<Candle> getCandles(
            Instrument instrument, Granularity granularity,
            Range<Instant> timeRange) {
        throw new UnsupportedOperationException();
    }
}
