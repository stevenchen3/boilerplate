import sbt._

object Dependencies {
  // Akka main library dependencies
  lazy val akkaVersion = "2.4.16"
  val akkaDeps = Seq(
    "com.typesafe.akka" %% "akka-actor",
    "com.typesafe.akka" %% "akka-stream"
  ).map(_ % akkaVersion)

  // Akka HTTP library dependencies
  lazy val akkaHttpVersion = "10.0.2"
  val akkaHttpDeps = Seq(
    "com.typesafe.akka" %% "akka-http-core",
    "com.typesafe.akka" %% "akka-http",
    "com.typesafe.akka" %% "akka-http-spray-json"
  ).map(_ % akkaHttpVersion)

  val unitTestDeps = Seq(
    "com.novocode" % "junit-interface" % "0.11"  % "test",
    "junit"        % "junit"           % "4.11"  % "test",
    "org.mockito"  % "mockito-core"    % "1.8.5" % "test"
  )
}
