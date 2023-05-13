/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Built-in Control Structures - For expressions (Producing a new collection)
 */
package com.artima.scala5ed.ch07

import java.io.File

@main
def s3dForExpression(): Unit =
  val filesHere: Array[File] = new java.io.File(".").listFiles
  def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toArray

  // "yield" push an element of the given type (here, a File) in the resulting array
  def tFiles = for file <- filesHere if file.getName.endsWith("t") yield file

  // the t-files names, as a string
  println(tFiles.mkString(", "))

  // generate an array with lengths of the trimmed lines containing "scala" in files ending by ".sbt"
  val lineLengths = for
    file <- filesHere if file.getName.endsWith(".sbt")
    line <- fileLines(file)
    trimmed = line.trim if trimmed.matches(".*scala.*")
  yield trimmed.length

  println(lineLengths.mkString(", "))
