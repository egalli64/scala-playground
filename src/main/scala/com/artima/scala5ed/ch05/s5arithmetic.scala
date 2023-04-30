/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Basic Types and Operations - Arithmetic operations
 */
package com.artima.scala5ed.ch05

@main
def s5arithmetic(): Unit =
  // +
  println(1.2 + 2.3)
  // -
  println(3 - 1)
  println('b' - 'a')
  // *
  println(2L * 3L)
  // integer division
  println(11 / 4)
  // integer remainder
  println(11 % 4)
  // real division
  println(11.0f / 4.0f)
  // real remainder
  println(11.0 % 4.0)
  // IEEE remainder (rounding division)
  println(math.IEEEremainder(11.0, 4.0))