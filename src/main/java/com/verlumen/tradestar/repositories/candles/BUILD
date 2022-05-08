java_library(
    name = "candle_repository",
    srcs = ["CandleRepository.java"],
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:com_google_guava_guava",
        "@tradestar_protos//:candles_java_proto",
        "@tradestar_protos//:instruments_java_proto",
    ],
)

java_library(
    name = "candle_repository_module",
    srcs = ["CandleRepositoryModule.java"],
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/verlumen/tradestar/repositories/candles/alphavantage:alpha_vantage_candle_repository_module",
        "@maven//:com_github_crazzyghost_alphavantage_java",
        "@maven//:com_google_inject_guice",
    ],
)
