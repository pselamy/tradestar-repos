java_library(
    name = "alpha_vantage_candle_repository",
    srcs = ["AlphaVantageCandleRepository.java"],
    deps = [
        "//src/main/java/com/verlumen/tradestar/repositories/candles:candle_repository",
        "@maven//:com_github_crazzyghost_alphavantage_java",
        "@maven//:com_google_guava_guava",
        "@maven//:com_google_inject_guice",
        "@tradestar_protos//:candles_java_proto",
        "@tradestar_protos//:instruments_java_proto",
    ],
)

java_library(
    name = "alpha_vantage_candle_repository_module",
    srcs = ["AlphaVantageCandleRepositoryModule.java"],
    visibility = ["//src/main/java/com/verlumen/tradestar/repositories/candles:__subpackages__"],
    deps = [
        ":alpha_vantage_candle_repository",
        "//src/main/java/com/verlumen/tradestar/repositories/candles:candle_repository",
        "@maven//:com_github_crazzyghost_alphavantage_java",
        "@maven//:com_google_inject_guice",
    ],
)

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
    name = "time_formatter",
    srcs = ["TimeFormatter.java"],
    deps = [],
)
