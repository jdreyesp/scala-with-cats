name := "scala-with-cats"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "1.4.0"
)

scalacOptions += "-language:higherKinds"