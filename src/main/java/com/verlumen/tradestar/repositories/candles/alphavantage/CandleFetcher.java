package com.verlumen.tradestar.repositories.candles.alphavantage;

import com.google.common.collect.ImmutableSet;
import com.verlumen.tradestar.protos.candles.Candle;
import com.verlumen.tradestar.protos.candles.Granularity;
import com.verlumen.tradestar.protos.instruments.Instrument;

interface CandleFetcher {
    ImmutableSet<Candle> fetch(Instrument instrument,
                               Granularity granularity);

    Instrument.Type instrumentType();
}
