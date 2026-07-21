lazy val root = project
  .in(file("."))
  .settings(
    name := "explore-scala3",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "3.8.4",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "2.1.26",
      "dev.zio" %% "zio-interop-cats" % "23.1.0.13",
      "org.typelevel" %% "cats-effect" % "3.7.0",
      "org.scalameta" %% "munit" % "1.3.4" % Test
    )
  )
