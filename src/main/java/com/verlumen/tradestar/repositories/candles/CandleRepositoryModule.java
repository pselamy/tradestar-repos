package com.verlumen.tradestar.repositories.candles;

import com.google.inject.AbstractModule;
import com.verlumen.tradestar.repositories.candles.alphavantage.AlphaVantageCandleRepositoryModule;

public class CandleRepositoryModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new AlphaVantageCandleRepositoryModule());
    }
}
