java_library(
    name = "hamcrest-library",
    exports = [
        "@hamcrest_library//jar",
        ":hamcrest-core"
    ],
    runtime_deps = [":hamcrest-core"],
    visibility = ["//visibility:public"]
)

java_library(
    name = "hamcrest-core",
    exports = ["@hamcrest_core//jar"],
    visibility = ["//visibility:public"]
)