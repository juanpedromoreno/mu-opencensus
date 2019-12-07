import Dependencies._

ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(name := "mu-opencensus", libraryDependencies ++= Seq(muRpcServer, muFs2, ocensusProto, protobuf, scalaTest % Test))
  .settings(
    Seq(
      resolvers += Resolver.sonatypeRepo("snapshots"),
      idlType := "proto",
      srcGenSerializationType := "Protobuf",
      srcGenJarNames := Seq("protobuf-java", "opencensus-proto"),
      srcGenSourceDirs ++= Seq((Compile / resourceManaged).value / "proto" / "resource"),
      srcGenTargetDir := (Compile / sourceManaged).value / "compiled_proto",
      libraryDependencies ++= Seq("io.higherkindness" %% "mu-rpc-channel" % Versions.mu),
      sourceGenerators in Compile += (Compile / srcGen).taskValue
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
