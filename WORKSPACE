workspace(name = "com_example_bazel_lombok")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive", "http_jar")

http_jar(
    name = "lombok_edge",
    urls = ["https://projectlombok.org/lombok-edge.jar"],
    sha256 = "11937f0abfae3053f31724eac79bace546e290361e0aeefffb96a177c336cc6b"
)

maven_jar(
    name = "junit",
    artifact = "junit:junit:4.12",
    sha1 = "2973d150c0dc1fefe998f834810d68f278ea58ec",
)

maven_jar(
    name = "hamcrest_core",
    artifact = "org.hamcrest:hamcrest-core:1.3",
    sha1 = "42a25dc3219429f0e5d060061f71acb49bf010a0",
)

maven_jar(
    name = "hamcrest_library",
    artifact = "org.hamcrest:hamcrest-library:1.3",
    sha1 = "4785a3c21320980282f9f33d0d1264a69040538f",
)
