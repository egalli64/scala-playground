/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Built-in Control Structures - For expressions (intro)
 */
package com.artima.scala5ed.ch07

@main
def s3aForIntro(): Unit =
  // Given an iterable - here, the files in current executable directory
  val filesHere = new java.io.File(".").listFiles
  // Print _each_ file in the sequence, the _generator_ "<-" let us iterate on an iterable
  for file <- filesHere do println(file)

  // We can loop on a Range using the syntax "x to y"
  for i <- 1 to 4 do println(s"To iteration $i")

  // Or, more in Java style, "x until y", terminal value excluded
  for i <- 1 until 4 do println(s"Until iteration $i")
