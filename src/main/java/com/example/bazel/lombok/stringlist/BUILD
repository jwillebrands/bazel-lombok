java_library(
    name = "stringlist",
    deps = ["//thirdparty/projectlombok:lombok_edge"],
    srcs = ["StringList.java"],
    visibility = ["//visibility:public"]
)

java_binary(
    name = "application",
    srcs = ["Application.java"],
    deps = ["stringlist"],
    main_class = "com.example.bazel.lombok.stringlist.Application"
)

java_binary(
    name = "lombok-bin",
    runtime_deps = ["@lombok_edge//jar"],
    main_class = "lombok.launch.Main"
)

genrule(
    name = "srcs-delomboked",
    srcs = ["StringList.java"],
    outs = ["delomboked-src/StringList.java"],
    tools = [":lombok-bin"],
    cmd = "$(location :lombok-bin) delombok -d $(@D) $<"
)

java_library(
    name = "stringlist-delomboked",
    srcs = [":srcs-delomboked"],
    deps = ["//thirdparty/projectlombok:lombok_edge"],
    visibility = ["//visibility:public"]
)

java_binary(
    name = "application-delomboked",
    srcs = ["Application.java"],
    deps = ["stringlist-delomboked"],
    main_class = "com.example.bazel.lombok.stringlist.Application"
)