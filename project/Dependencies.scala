import sbt._

import sbt._

object Dependencies {
  object Versions {
    val ocensusVersion = "0.2.0"
    val mu = "0.19.2-SNAPSHOT"
    val protobuf = "3.6.1"
    val scalaTest = "3.0.5"
  }

  lazy val ocensusProto = "io.opencensus"    % "opencensus-proto" % Versions.ocensusVersion
  lazy val scalaTest = "org.scalatest"       %% "scalatest"       % Versions.scalaTest
  lazy val muFs2 = "io.higherkindness"       %% "mu-rpc-fs2"      % Versions.mu
  lazy val muRpcServer = "io.higherkindness" %% "mu-rpc-server"   % Versions.mu
  lazy val protobuf = "com.google.protobuf"  % "protobuf-java"    % Versions.protobuf
}
