Example to reproduce: https://github.com/bufbuild/buf-gradle-plugin/issues/172

The following gradle command will hang:

```gradle
./gradlew clean bufBuild --no-build-cache
```

If in `build.gradle.kts` change `protobufVersion` to `3.24.4`, the command works OK

This only applies to `com.google.protobuf:protobuf-kotlin` which has `com.google.protobuf:protobuf-java` as transitive dependency.

If I don't need kotlin DSL feature and directly including `protobuf-java`, the command also works.

__Something interesting happens for bufBuild + protobuf-kotlin v3.25.0+__
