package com.verlumen.tradestar.repositories.candles;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Range;
import com.verlumen.tradestar.protos.candles.Candle;
import com.verlumen.tradestar.protos.candles.Granularity;
import com.verlumen.tradestar.protos.instruments.Instrument;

import java.time.Instant;

class AlphaVantageCandleRepository implements CandleRepository {
    @Override
    public ImmutableSet<Candle> getCandles(Instrument instrument, Granularity granularity, Range<Instant> timeRange) {
        throw new UnsupportedOperationException();
    }
}
