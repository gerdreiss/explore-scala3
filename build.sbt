lazy val root = project
  .in(file("."))
  .settings(
    name := "explore-scala3",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "3.8.4",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "2.1.26",
      "org.scalameta" %% "munit" % "1.3.3" % Test
    )
  )
