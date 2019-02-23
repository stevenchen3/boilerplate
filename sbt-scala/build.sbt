import Dependencies._

lazy val commonSettings = Seq(
  name         := "sbt-scala",
  version      := "0.9.0-SNAPSHOT",
  organization := "alphash.io",
  scalaVersion := "2.12.8",
  scalacOptions in Compile ++= Seq(
    "-encoding",
    "UTF-8",
    "-target:jvm-1.8",
    "-deprecation",
    "-feature",
    "-unchecked",
    "-Xlog-reflective-calls",
    "-Xlint"
  ),
  javacOptions in Compile ++= Seq("-source", "1.8", "-target", "1.8"),
  javaOptions in Test ++= Seq("-Dconfig.resource=test.conf"),
  javaOptions in run  ++= Seq("-Xms1g", "-Xmx2g", "-XX:+UseParallelGC", "-server"),
  javaOptions in Universal := (javaOptions in run).value, // propagate `run` settings to packaging scripts
  resolvers ++= Seq(
    Resolver.sonatypeRepo("releases"),
    Resolver.typesafeRepo("releases")
  )
)

//lazy val grpcJavaPluginPath = "/usr/local/bin/protoc-gen-grpc-java"
lazy val root = Project(id = "sbt-scala", base = file("."))
  .enablePlugins(JavaServerAppPackaging, UniversalPlugin)
  //.enablePlugins(ProtobufPlugin)
  .settings(commonSettings: _*)
  .settings(fork in run     := false)
  .settings(fork in Test    := true)
  .settings(coverageEnabled := true)  // change to `false` when comes to packaging and distribution
  //.settings(coverageExcludedPackages := "example\\.fp\\.notes")
  .settings(libraryDependencies ++= akkaDeps)
  .settings(libraryDependencies ++= akkaHttpDeps)
  .settings(libraryDependencies ++= gRpcDeps)
  .settings(libraryDependencies ++= scalatestDeps)
  .settings(libraryDependencies ++= unitTestDeps)
  //// To generate gRPC Java classes, below protobuf options are required
  //.settings(protobufProtocOptions in ProtobufConfig ++= Seq(
  //  s"--plugin=protoc-gen-grpc-java=$grpcJavaPluginPath",
  //  // Output to where other generated protobuf Java classes reside
  //  // By default, SBT will compile sources from this directory
  //  s"--grpc-java_out=${sourceManaged.value}/main/compiled_protobuf"
  //))
  //.settings(mainClass in (Compile, run) := Some("example.algorithms.QuickSort"))

// ScalaPB settings
// Auto-generated Scala case classes for protobuf will be in `target/scala-2.11/src_managed/main`
//PB.targets in Compile := Seq(
//  scalapb.gen() -> (sourceManaged in Compile).value
//)
