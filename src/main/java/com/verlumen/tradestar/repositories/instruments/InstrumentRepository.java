package com.verlumen.tradestar.repositories.instruments;


import com.verlumen.tradestar.protos.instruments.Instrument;

public interface InstrumentRepository {
    Instrument getInstrument(String symbol);
}