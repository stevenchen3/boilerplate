import Dependencies._

lazy val commonSettings = Seq(
  name         := "sbt-scala",
  version      := "0.9.0",
  organization := "alphash.io",
  scalaVersion := "2.11.8",
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
  javacOptions in Compile ++= Seq(
    "-source", "1.8",
    "-target", "1.8",
    "-Xlint:unchecked",
    "-Xlint:deprecation"
  ),
  javaOptions in Test ++= Seq("-Dconfig.resource=test.conf"),
  javaOptions in run ++= Seq(
    "-Xms1024m",
    "-Xmx2048m",
    "-XX:+UseParallelGC",
    "-server"
  ),
  javaOptions in Universal := (javaOptions in run).value // propagate `run` settings to packaging scripts
)

lazy val root = Project(id = "sbt-scala", base = file("."))
  .enablePlugins(JavaServerAppPackaging, UniversalPlugin)
  .settings(commonSettings: _*)
  .settings(fork in run     := false)
  .settings(fork in Test    := true)
  .settings(coverageEnabled := true)  // change to `false` when comes to packaging and distribution
  //.settings(coverageExcludedPackages := "example\\.fp\\.notes")
  .settings(libraryDependencies ++= akkaDeps)
  .settings(libraryDependencies ++= akkaHttpDeps)
  .settings(libraryDependencies ++= scalatestDeps)
  .settings(libraryDependencies ++= gRPCDeps)
  .settings(libraryDependencies ++= unitTestDeps)
//  .settings(mainClass in (Compile, run) := Some("example.algorithms.QuickSort"))

// ScalaPB settings
// Auto-generated Scala case classes for protobuf will be in `target/scala-2.11/src_managed/main`
PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)
