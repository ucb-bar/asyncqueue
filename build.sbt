organization := "edu.berkeley.cs"

version := "2.0.0"

name := "asyncqueue-lite"

scalaVersion := "2.13.10"

val chiselVersion = "3.6.0"

libraryDependencies += "edu.berkeley.cs" %% "chisel3" % chiselVersion
libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4"
Test / testForkedParallel := true

addCompilerPlugin("edu.berkeley.cs" % "chisel3-plugin" % chiselVersion cross CrossVersion.full)
