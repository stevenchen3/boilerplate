import sbt._

object Dependencies {
  // Akka main library dependencies
  lazy val akkaVersion = "2.5.14"
  val akkaDeps = Seq(
    "com.typesafe.akka" %% "akka-actor",
    "com.typesafe.akka" %% "akka-agent",
    "com.typesafe.akka" %% "akka-camel",
    "com.typesafe.akka" %% "akka-cluster",
    "com.typesafe.akka" %% "akka-cluster-metrics",
    "com.typesafe.akka" %% "akka-cluster-sharding",
    "com.typesafe.akka" %% "akka-cluster-tools",
    "com.typesafe.akka" %% "akka-contrib",
    "com.typesafe.akka" %% "akka-multi-node-testkit",
    "com.typesafe.akka" %% "akka-osgi",
    "com.typesafe.akka" %% "akka-persistence",
    "com.typesafe.akka" %% "akka-persistence-tck",
    "com.typesafe.akka" %% "akka-remote",
    "com.typesafe.akka" %% "akka-slf4j",
    "com.typesafe.akka" %% "akka-stream",
    "com.typesafe.akka" %% "akka-stream-testkit",
    "com.typesafe.akka" %% "akka-testkit",
    "com.typesafe.akka" %% "akka-distributed-data",
    "com.typesafe.akka" %% "akka-persistence-query"
  ).map(_ % akkaVersion)

  // Akka HTTP library dependencies
  lazy val akkaHttpVersion = "10.1.3"
  val akkaHttpDeps = Seq(
    "com.typesafe.akka" %% "akka-http-core",
    "com.typesafe.akka" %% "akka-http",
    "com.typesafe.akka" %% "akka-http-testkit",
    "com.typesafe.akka" %% "akka-http-spray-json",
    "com.typesafe.akka" %% "akka-http-jackson",
    "com.typesafe.akka" %% "akka-http-xml"
  ).map(_ % akkaHttpVersion)

  // typelevel Cats library dependencies, including all modules
  val catsVersion = "1.6.0"
  val catsDeps = Seq(
    "org.typelevel" %% "cats-core",
    "org.typelevel" %% "cats-free",
    "org.typelevel" %% "cats-laws",
    "org.typelevel" %% "cats-macros",
    "org.typelevel" %% "cats-testkit"
  ).map(_ % catsVersion)

  // Circe library dependencies
  val circeVersion = "0.11.0"
  val circeDeps = Seq(
    "io.circe" %% "circe-core",
    "io.circe" %% "circe-generic",
    "io.circe" %% "circe-generic-extras",
    "io.circe" %% "circe-optics",
    "io.circe" %% "circe-parser",
    "io.circe" %% "circe-literal"
  ).map(_ % circeVersion)

  // ScalaPB library dependencies
  val scalapbDeps = Seq(
    "io.grpc" % "grpc-netty" % com.trueaccord.scalapb.compiler.Version.grpcJavaVersion,
    "com.trueaccord.scalapb" %% "scalapb-runtime-grpc" % com.trueaccord.scalapb.compiler.Version.scalapbVersion
  )

  // gRPC and Protobuf Java library dependencies
  lazy val gRpcJavaVersion = "1.18.0"
  val gRpcDeps = Seq(
    "io.grpc" % "grpc-auth",
    "io.grpc" % "grpc-core",
    "io.grpc" % "grpc-netty",
    "io.grpc" % "grpc-netty-shaded",
    "io.grpc" % "grpc-protobuf",
    "io.grpc" % "grpc-stub",
    "io.grpc" % "grpc-testing"
  ).map(_ % gRpcJavaVersion)

  val scalacheckDeps = Seq(
    "org.scalacheck" %% "scalacheck" % "1.14.0" % Test
  )

  // Scalatest library dependencies
  val scalatestDeps = Seq(
    "org.scalatest" %% "scalatest" % "3.0.1" % "test",
    "org.scalamock" %% "scalamock-scalatest-support" % "3.5.0" % Test
  )

  val unitTestDeps = Seq(
    "com.novocode" % "junit-interface" % "0.11"  % "test",
    "junit"        % "junit"           % "4.11"  % "test",
    "org.mockito"  % "mockito-core"    % "1.8.5" % "test"
  )
}
