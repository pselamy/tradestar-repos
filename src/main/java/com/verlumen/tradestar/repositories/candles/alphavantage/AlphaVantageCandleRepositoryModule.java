package com.verlumen.tradestar.repositories.candles.alphavantage;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.Config;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;
import com.verlumen.tradestar.repositories.candles.CandleRepository;

public class AlphaVantageCandleRepositoryModule extends AbstractModule {
    private static final String DEFAULT_ALPHA_VANTAGE_API_KEY = "demo";

    @Override
    protected void configure() {
        bind(CandleRepository.class).to(AlphaVantageCandleRepository.class);

        Multibinder<CandleFetcher> candleFetcherBinder =
                Multibinder.newSetBinder(binder(), CandleFetcher.class);
        candleFetcherBinder.addBinding().to(StockCandleFetcher.class);
    }

    @Provides
    Config provideAlphaVantageConfig() {
        return Config.builder()
                .key(alphaVantageKey())
                .timeOut(10)
                .build();
    }

    @Provides
    @Singleton
    AlphaVantage provideAlphaVantage(Config config) {
        AlphaVantage alphaVantage = AlphaVantage.api();
        alphaVantage.init(config);
        return alphaVantage;
    }

    private String alphaVantageKey() {
        return System.getenv().getOrDefault("ALPHA_VANTAGE_API_KEY",
                DEFAULT_ALPHA_VANTAGE_API_KEY);
    }
}
