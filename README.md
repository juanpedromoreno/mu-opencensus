Mu IDL generation from proto files
==================================

Use the service proto files defined by the OpenCensus project to generate mu service definitions:

```
sbt compile
```

The `build.sbt` file includes references to both the OpenCensus proto JAR as well as the Google protobuf JAR.  This is
because OpenCensus proto files import Google's timestamp definition.

OpenCensus protobuf models do compile with the scalaPB plugin, but fail to compile with the idl-gen plugin.

The error reported is as follows:

```
compile
protoc-jar: protoc version: 3.6.0, detected platform: osx-x86_64 (mac os x/x86_64)
protoc-jar: embedded: bin/3.6.0/protoc-3.6.0-osx-x86_64.exe
protoc-jar: executing: [/var/folders/m3/_bxmtk_13z1fnm54cczf9w5h0000gn/T/protocjar9526121542652863700/bin/protoc.exe, --plugin=protoc-gen-proto2_to_proto3, --include_imports, --descriptor_set_out=common.proto.desc, --proto_path=/Users/davidc/ext-projects/mu-opencensus/target/scala-2.12/resource_managed/main/proto/opencensus/proto/agent/common/v1, common.proto]
google/protobuf/timestamp.proto: File not found.
common.proto: Import "google/protobuf/timestamp.proto" was not found or had errors.
common.proto:62:3: "google.protobuf.Timestamp" is not defined.
[error] higherkindness.skeuomorph.ProtobufCompilationException: Protoc failed to compile protobuf file
[error]         at higherkindness.skeuomorph.protobuf.ParseProto$.$anonfun$runProtoc$2(ParseProto.scala:65)
[error]         at cats.MonadError.$anonfun$ensure$1(MonadError.scala:14)
[error]         at cats.effect.internals.IORunLoop$.liftedTree3$1(IORunLoop.scala:225)
[error]         at cats.effect.internals.IORunLoop$.step(IORunLoop.scala:225)
[error]         at cats.effect.IO.unsafeRunTimed(IO.scala:321)
[error]         at cats.effect.IO.unsafeRunSync(IO.scala:240)
[error]         at higherkindness.mu.rpc.idlgen.proto.ProtoSrcGenerator$.generateFrom(ProtoSrcGenerator.scala:46)
[error]         at higherkindness.mu.rpc.idlgen.Generator.$anonfun$generateFrom$1(Generator.scala:30)
[error]         at scala.collection.TraversableLike.$anonfun$flatMap$1(TraversableLike.scala:240)
[error]         at scala.collection.Iterator.foreach(Iterator.scala:937)
[error]         at scala.collection.Iterator.foreach$(Iterator.scala:937)
[error]         at scala.collection.AbstractIterator.foreach(Iterator.scala:1425)
[error]         at scala.collection.IterableLike.foreach(IterableLike.scala:70)
[error]         at scala.collection.IterableLike.foreach$(IterableLike.scala:69)
[error]         at scala.collection.AbstractIterable.foreach(Iterable.scala:54)
[error]         at scala.collection.TraversableLike.flatMap(TraversableLike.scala:240)
[error]         at scala.collection.TraversableLike.flatMap$(TraversableLike.scala:237)
[error]         at scala.collection.AbstractTraversable.flatMap(Traversable.scala:104)
[error]         at higherkindness.mu.rpc.idlgen.Generator.generateFrom(Generator.scala:29)
[error]         at higherkindness.mu.rpc.idlgen.Generator.generateFrom$(Generator.scala:25)
[error]         at higherkindness.mu.rpc.idlgen.proto.ProtoSrcGenerator$.generateFrom(ProtoSrcGenerator.scala:33)
[error]         at higherkindness.mu.rpc.idlgen.GeneratorApplication.generateFrom(GeneratorApplication.scala:63)
[error]         at higherkindness.mu.rpc.idlgen.IdlGenPlugin$.$anonfun$idlGenTask$1(IdlGenPlugin.scala:186)
[error]         at sbt.util.FileFunction$.$anonfun$cached$1(FileFunction.scala:73)
[error]         at sbt.util.FileFunction$.$anonfun$cached$4(FileFunction.scala:147)
[error]         at sbt.util.Difference.apply(Tracked.scala:313)
[error]         at sbt.util.Difference.apply(Tracked.scala:293)
[error]         at sbt.util.FileFunction$.$anonfun$cached$3(FileFunction.scala:143)
[error]         at sbt.util.Difference.apply(Tracked.scala:313)
[error]         at sbt.util.Difference.apply(Tracked.scala:288)
[error]         at sbt.util.FileFunction$.$anonfun$cached$2(FileFunction.scala:142)
[error]         at higherkindness.mu.rpc.idlgen.IdlGenPlugin$.$anonfun$taskSettings$6(IdlGenPlugin.scala:159)
[error]         at scala.Function1.$anonfun$compose$1(Function1.scala:44)
[error]         at sbt.internal.util.$tilde$greater.$anonfun$$u2219$1(TypeFunctions.scala:40)
[error]         at sbt.std.Transform$$anon$4.work(System.scala:67)
[error]         at sbt.Execute.$anonfun$submit$2(Execute.scala:269)
[error]         at sbt.internal.util.ErrorHandling$.wideConvert(ErrorHandling.scala:16)
[error]         at sbt.Execute.work(Execute.scala:278)
[error]         at sbt.Execute.$anonfun$submit$1(Execute.scala:269)
[error]         at sbt.ConcurrentRestrictions$$anon$4.$anonfun$submitValid$1(ConcurrentRestrictions.scala:178)
[error]         at sbt.CompletionService$$anon$2.call(CompletionService.scala:37)
[error]         at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
[error]         at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
[error]         at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
[error]         at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
[error]         at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
[error]         at java.base/java.lang.Thread.run(Thread.java:835)
[error] (srcGen) higherkindness.skeuomorph.ProtobufCompilationException: Protoc failed to compile protobuf file
[error] Total time: 1 s, completed 29 May 2019, 11:05:55
sbt:mu-opencensus>
```
