workspace(name = "tradestar_repos")

load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")

git_repository(
    name = "rules_proto",
    commit = "3212323502e21b819ac4fbdd455cb227ad0f6394",
    remote = "https://github.com/bazelbuild/rules_proto",
    shallow_since = "1649153521 +0200",
)

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()

rules_proto_toolchains()

git_repository(
    name = "tradestar_protos",
    commit = "24210b5698858a91e6e583a82e804fa11b11bcb9",
    remote = "https://github.com/pselamy/tradestar-protos",
    shallow_since = "1645497038 -0600",
)

git_repository(
    name = "contrib_rules_jvm",
    commit = "f7c08ec6d73ef691b03f843e0c2c3dbe766df584",
    remote = "https://github.com/bazel-contrib/rules_jvm",
    shallow_since = "1642674503 +0000",
)

load("@contrib_rules_jvm//:repositories.bzl", "contrib_rules_jvm_deps")

contrib_rules_jvm_deps()

load("@contrib_rules_jvm//:setup.bzl", "contrib_rules_jvm_setup")

contrib_rules_jvm_setup()

git_repository(
    name = "rules_jvm_external",
    remote = "https://github.com/bazelbuild/rules_jvm_external",
    tag = "4.2",
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "com.github.crazzyghost:alphavantage-java:1.6.2",
        "com.google.guava:guava:31.0.1-jre",
        "com.google.inject:guice:5.1.0",
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
        "https://jitpack.io",
    ],
)
