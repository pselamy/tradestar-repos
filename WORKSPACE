workspace(name = "tradestar_repos")

load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")

git_repository(
    name = "com_google_protobuf",
    commit = "498de9f761bef56a032815ee44b6e6dbe0892cc4",
    remote = "https://github.com/protocolbuffers/protobuf",
    shallow_since = "1580681072 -0800",
)

load("@com_google_protobuf//:protobuf_deps.bzl", "protobuf_deps")

protobuf_deps()

git_repository(
    name = "tradestar_protos",
    commit = "e3235eb1f0ebffe33b559c82d41890a6b44a88bf",
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
        "com.google.guava:guava:31.0.1-jre",
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
)
