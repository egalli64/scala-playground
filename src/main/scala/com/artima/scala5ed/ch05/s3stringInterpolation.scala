/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Basic Types and Operations - String interpolation: s"", raw"", f""
 */
package com.artima.scala5ed.ch05

@main
def s3stringInterpolation(): Unit =
  val name = "reader"

  // s"..." is a processed string literal
  println(s"Hello, $name!")
  // same as string concatenation, in a more friendly way
  println("Hello, " + name + "!")

  // any expression could go after $, but braces are required for non-identifier chars
  println(s"The answer is ${6 * 7}")

  // raw"" does not recognize escape
  println(raw"No\\\\escape!")

  // f"" uses printf-like formatting
  println(f"Plain: ${math.Pi}, limited to 5 decimal: ${math.Pi}%.5f")
