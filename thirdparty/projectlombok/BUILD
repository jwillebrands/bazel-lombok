java_plugin(
    name = "lombok_edge_plugin",
    deps = ["@lombok_edge//jar"],
    generates_api = True,
    processor_class = "lombok.launch.AnnotationProcessorHider$AnnotationProcessor",
    visibility = ["//visibility:public"]
)

java_library(
    name = "lombok_edge",
    exports = ["@lombok_edge//jar"],
    exported_plugins = [":lombok_edge_plugin"],
    visibility = ["//visibility:public"]
)