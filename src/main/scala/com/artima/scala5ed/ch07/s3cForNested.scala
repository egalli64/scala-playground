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

  /**
   * Nested loop example
   *
   * @param pattern
   *   the searched pattern in files
   */
  def grep(pattern: String): Unit =
    for
      // outer loop on filesHere on the "file" loop variable
      file <- filesHere if file.getName.endsWith(".sbt")
      // inner loop on fileLines on the "line" loop variable
      line <- fileLines(file) if line.trim.matches(pattern)
    do
      // body of the (internal) loop, uses the loop variables
      println(s"$file: ${line.trim}")

  /**
   * Nested loop example, with a mid-stream variable binding
   *
   * @param pattern
   *   the searched pattern in files
   */
  def grep2(pattern: String): Unit =
    for
      // filtered outer loop
      file <- filesHere if file.getName.endsWith(".sbt")
      // inner loop
      line <- fileLines(file)
      // define mid-stream variable "trimmed" before filtering
      trimmed = line.trim if trimmed.matches(pattern)
    do
      // use a plain loop variable and the mid-stream one
      println(s"$file: $trimmed")

  println("*** Grep version 1 ***")
  grep(".*scala-.*")

  println("*** Grep version 2 ***")
  grep2(".*scala-.*")
