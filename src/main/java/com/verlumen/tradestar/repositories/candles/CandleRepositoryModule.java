package com.verlumen.tradestar.repositories.candles;

import com.crazzyghost.alphavantage.Config;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class CandleRepositoryModule extends AbstractModule {
    private static final String DEFAULT_ALPHA_VANTAGE_API_KEY = "demo";

    @Override
    protected void configure() {
        bind(CandleRepository.class).to(AlphaVantageCandleRepository.class)
                .in(Singleton.class);
    }

    @Provides
    Config provideAlphaVantageConfig() {
        return Config.builder()
                .key(alphaVantageKey())
                .timeOut(10)
                .build();
    }

    private String alphaVantageKey() {
        return System.getenv().getOrDefault("ALPHA_VANTAGE_API_KEY",
                DEFAULT_ALPHA_VANTAGE_API_KEY);
    }
}
