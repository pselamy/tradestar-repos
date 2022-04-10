package com.verlumen.tradestar.repositories.candles;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.Config;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Range;
import com.google.inject.Inject;
import com.verlumen.tradestar.protos.candles.Candle;
import com.verlumen.tradestar.protos.candles.Granularity;
import com.verlumen.tradestar.protos.instruments.Instrument;

import java.time.Instant;

class AlphaVantageCandleRepository implements CandleRepository {

    @Inject
    AlphaVantageCandleRepository(Config config) {
        AlphaVantage.api().init(config);
    }

    @Override
    public ImmutableSet<Candle> getCandles(Instrument instrument, Granularity granularity, Range<Instant> timeRange) {
        throw new UnsupportedOperationException();
    }

    private static class StockApi {}

    private static class ForexApi {}

    private static class ExchangeRateApi {}

    private static class CryptoApi {}

    private static class IndicatorApi {}

    private static class SectorApi {}

    private static class FundamentalsApi {}
}
