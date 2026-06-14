lazy val root = project
  .in(file("."))
  .settings(
    name := "explore-scala3",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "3.8.4",
    libraryDependencies += "org.scalameta" %% "munit" % "1.3.2" % Test
  )
