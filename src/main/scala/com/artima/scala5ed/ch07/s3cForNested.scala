/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Built-in Control Structures - For expressions (Nested iteration)
 */
package com.artima.scala5ed.ch07

import java.io.File

@main
def s3cForNested(): Unit =
  val filesHere: Array[File] = new java.io.File(".").listFiles

  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines().toArray

  def grep(pattern: String): Unit =
    for
      // outer loop on filesHere
      file <- filesHere if file.getName.endsWith(".sbt")
      // inner loop on fileLines
      line <- fileLines(file) if line.trim.matches(pattern)
    do
      // body of the (internal) loop
      println(s"$file: ${line.trim}")

  grep(".*scala.*")
