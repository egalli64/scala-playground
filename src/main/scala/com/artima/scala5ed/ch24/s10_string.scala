/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Collections in Depth - Strings
  - as the arrays, they can be converted to sequences
 */
package com.artima.scala5ed.ch24

@main
def s10_string(): Unit =
  val str = "hello"
  println("A string: " + str)
  println("Reverted string: " + str.reverse)
  println("To upper mapping on chars: " + str.map(_.toUpper))
  println("Substring dropping head: " + str.drop(3))
  println("Substring slicing: " + str.slice(1, 4))
  val s: Seq[Char] = str
  println("Converted to char sequence: " + s)
