package com.verlumen.tradestar.candles.repositories;


import com.verlumen.tradestar.protos.instruments.Instrument;

import java.time.Instant;

public interface InstrumentRepository {
    Instrument getInstrument(String symbol);
}