java_library(
    name = "candle_fetcher",
    srcs = ["CandleFetcher.java"],
    deps = [
        "@maven//:com_google_guava_guava",
        "@maven//:com_google_inject_guice",
        "@tradestar_protos//:candles_java_proto",
        "@tradestar_protos//:instruments_java_proto",
    ],
)

java_library(
    name = "stock_candle_fetcher",
    srcs = ["StockCandleFetcher.java"],
    deps = [
        ":candle_fetcher",
        ":time_formatter",
        "@maven//:com_github_crazzyghost_alphavantage_java",
        "@maven//:com_google_guava_guava",
        "@maven//:com_google_inject_guice",
        "@tradestar_protos//:candles_java_proto",
        "@tradestar_protos//:instruments_java_proto",
    ],
)

java_library(
    name = "time_formatter",
    srcs = ["TimeFormatter.java"],
    deps = [],
)
