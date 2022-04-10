package com.verlumen.tradestar.repositories.candles;

import com.google.inject.AbstractModule;

public class CandleRepositoryModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CandleRepository.class).to(AlphaVantageCandleRepository.class);
    }
}
