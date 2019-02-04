### Description of the problem:

We ran into an issue with lombok during our migration from maven to bazel. I'm not quite sure whether it is an issue with lombok
or with bazel, however, it compiles without issues when running from maven. 
When compiling under bazel, we're running into an error with classes that use lombok's `@Builder`, in combination
with a default value using `@Builder.Default` and a `@NoArgsConstructor` annotation. 

I would expect the same result, regardless of whether it was built under maven or bazel. Instead it compiles fine using maven,
and fails using bazel when compiling the hjar with the following error:

```
INFO: Invocation ID: c635e5ea-e600-476c-b127-52efb676e5d1
Loading:
Loading: 0 packages loaded
Analyzing: 13 targets (5 packages loaded, 0 targets configured)
INFO: Analysed 13 targets (5 packages loaded, 5 targets configured).
INFO: Found 13 targets...
[1 / 7] [-----] Compiling Java headers src/main/java/com/example/bazel/lombok/stringlist/libstringlist-hjar.jar (1 files) and running annotation processors (AnnotationProcessorHider$AnnotationProcessor)
[17 / 20] Compiling Java headers src/main/java/com/example/bazel/lombok/stringlist/libstringlist-hjar.jar (1 files) and running annotation processors (AnnotationProcessorHider$AnnotationProcessor); 1s local
ERROR: C:/users/jan-willem/projects/bazel-lombok/src/main/java/com/example/bazel/lombok/stringlist/BUILD:1:1: Compiling Java headers src/main/java/com/example/bazel/lombok/stringlist/libstringlist-hjar.jar (1 files) and running annotation processors (AnnotationProcessorHider$AnnotationProcessor) failed (Exit 1)
src\main\java\com\example\bazel\lombok\stringlist\StringList.java:16: warning: @Builder.Default requires an initializing expression (' = something;').
src\main\java\com\example\bazel\lombok\stringlist\StringList.java:12: error: cannot find symbol
  symbol:   method $default$strings()
  location: class com.example.bazel.lombok.stringlist.StringList
INFO: Elapsed time: 2,950s, Critical Path: 2,30s
INFO: 0 processes.
FAILED: Build did NOT complete successfully
FAILED: Build did NOT complete successfully
```

Manually running the code through delombok and using its output as source works fine using bazel.

### Bugs: what's the simplest, easiest way to reproduce this bug? Please provide a minimal example if possible.

One of:
    
* `bazel build ...`
* `bazel run //src/main/java/com/example/bazel/lombok/stringlist:application`
* `bazel test //src/test/java/com/example/bazel/lombok/stringlist` 

For completion I've included a pom that builds the same sources using maven: `mvn clean test`

To verify everything works when manually running the source through delombok:

*  `bazel run //src/main/java/com/example/bazel/lombok/stringlist:application-delomboked`
*  `bazel test //src/test/java/com/example/bazel/lombok/stringlist:delomboked`

### What operating system are you running Bazel on?

I've tested this using Windows 10, Ubuntu under WSL and a separate machine running Debian 9.6

### What's the output of `bazel info release`?

On the used Windows machine: 
```
INFO: Invocation ID: b9aeb91e-5af2-4ea6-964b-a49428f41508
release 0.20.0
```

Ubuntu under WSL:
```
release 0.19.2
```

On Debian:
```
INFO: Invocation ID: bb09cb14-d774-4e0f-b4db-d0af55250386
release 0.21.0
```

### What's the output of `git remote get-url origin ; git rev-parse master ; git rev-parse HEAD` ?

https://github.com/jwillebrands/bazel-lombok.git\
66c8a6714c8c733c0391d8a16f9a4e81b696ffcb\
66c8a6714c8c733c0391d8a16f9a4e81b696ffcb

###  Have you found anything relevant by searching the web?

I ran into an old issue with Lombok under bazel that should have been resolved long ago: https://github.com/bazelbuild/bazel/issues/4393

Other than that I've not been able to find anything (seemingly) related, neither in Bazel's nor in Lombok's issue tracker.
