java_test(
    name = "stringlist",
    srcs = ["StringListTest.java"],
    deps = [
        "//src/main/java/com/example/bazel/lombok/stringlist",
        "//thirdparty/junit4",
        "//thirdparty/hamcrest:hamcrest-library"
    ],
    test_class = "com.example.bazel.lombok.stringlist.StringListTest"
)

java_test(
    name = "delomboked",
    srcs = ["StringListTest.java"],
    deps = [
        "//src/main/java/com/example/bazel/lombok/stringlist:stringlist-delomboked",
        "//thirdparty/junit4",
        "//thirdparty/hamcrest:hamcrest-library"
    ],
    test_class = "com.example.bazel.lombok.stringlist.StringListTest"
)