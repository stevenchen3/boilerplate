import Dependencies._
import de.johoop.jacoco4sbt._
import JacocoPlugin._
import de.heikoseeberger.sbtheader.license.Apache2_0

val typesafeRepo = "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

lazy val jacocoSettings = Seq(
  Keys.fork in jacoco.Config := false,
  parallelExecution in jacoco.Config := false,
  jacoco.excludes in jacoco.Config := Seq(
    "views*",
    "*Routes*",
    "controllers*routes*",
    "controllers*Reverse*",
    "controllers*javascript*",
    "controller*ref*"
  )
)

lazy val commonSettings = Seq(
  name         := "sbt-java",
  version      := "0.9.0",
  organization := "alphash.io",
  scalaVersion := "2.11.8",
  javacOptions in Compile ++= Seq(
    "-source", "1.7",
    "-target", "1.7",
    "-Xlint:unchecked",
    "-Xlint:deprecation"
  ),
  javacOptions in (Compile, Keys.doc) ++= Seq("-notimestamp", "-linksource", "-Xlint:unchecked"),
  javaOptions in Test ++= Seq("-Dconfig.resource=test.conf"),
  javaOptions in run ++= Seq(
    "-Xms1024m",
    "-Xmx2048m",
    "-XX:+UseParallelGC",
    "-server"
  ),
  testOptions += Tests.Argument(TestFrameworks.JUnit, "-v", "+q"),
  parallelExecution in Test := false,
  fork in Test := true,
  resolvers += typesafeRepo,
  cleanKeepFiles := Seq.empty,
  sources in (Compile, Keys.doc) := Seq.empty,
  headers := Map(
    "java" -> Apache2_0("2017", "Steven Chen")
  )
)

lazy val root = Project(id = "sbt-scala", base = file("."))
  .enablePlugins(JavaServerAppPackaging, UniversalPlugin)
  .settings(commonSettings: _*)
  .settings(jacoco.settings)
  .settings(fork in run     := false)
  .settings(javaOptions in Test += "-Dconfig.resource=test.conf")
  .settings(testOptions in jacoco.Config ++= Seq(
    Tests.Setup {() ⇒ System.setProperty("config.resource", "test.conf")},
    Tests.Cleanup {() ⇒ System.clearProperty("config.resource")}))
  .settings(javaUnidocSettings)
  .settings(net.virtualvoid.sbt.graph.Plugin.graphSettings)
  .settings(libraryDependencies ++= akkaDeps)
  .settings(libraryDependencies ++= unitTestDeps)

