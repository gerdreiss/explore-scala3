lazy val root = project
  .in(file("."))
  .settings(
    name := "explore-scala3",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "3.10.0",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "2.1.27",
      "dev.zio" %% "zio-interop-cats" % "23.1.0.14",
      "org.typelevel" %% "cats-effect" % "3.7.1",
      "com.github.javafaker" % "javafaker" % "1.0.2",
      "org.scalameta" %% "munit" % "1.3.6" % Test
    )
  )
