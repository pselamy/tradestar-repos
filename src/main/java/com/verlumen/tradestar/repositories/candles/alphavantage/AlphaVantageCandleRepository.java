package com.verlumen.tradestar.repositories.candles.alphavantage;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Range;
import com.google.inject.Inject;
import com.verlumen.tradestar.protos.candles.Candle;
import com.verlumen.tradestar.protos.candles.Granularity;
import com.verlumen.tradestar.protos.instruments.Instrument;
import com.verlumen.tradestar.repositories.candles.CandleRepository;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;

import static com.google.common.collect.ImmutableMap.toImmutableMap;
import static java.util.function.Function.identity;

class AlphaVantageCandleRepository implements CandleRepository {
    private final ImmutableMap<Instrument.Type, CandleFetcher> candleFetchers;

    @Inject
    AlphaVantageCandleRepository(Set<CandleFetcher> candleFetchers) {
        this.candleFetchers = candleFetchers.stream()
                .collect(toImmutableMap(CandleFetcher::instrumentType, identity()));
    }

    @Override
    public ImmutableSet<Candle> getCandles(
            Instrument instrument, Granularity granularity,
            Range<Instant> timeRange) {
        return candleFetcher(instrument.getType())
                .map(fetcher -> fetcher.fetch(instrument, granularity))
                .orElseThrow(UnsupportedOperationException::new);
    }

    private Optional<CandleFetcher> candleFetcher(Instrument.Type instrumentType) {
        return Optional.ofNullable(candleFetchers.get(instrumentType));
    }
}
