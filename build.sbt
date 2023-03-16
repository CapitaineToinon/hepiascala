val scala3Version = "3.2.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "hepiascala",
    version := "2.1.0",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.11" % Test
    ),
    Compile / scalaSource := baseDirectory.value / "src",
    Test / scalaSource := baseDirectory.value / "test-src"
  )
