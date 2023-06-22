/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Pattern Matching - Patterns everywhere - Patterns in variable definitions
 */
package com.artima.scala5ed.ch13

@main
def s7a_variable(): Unit =
  val myTuple = (123, "abc")
  // define multiple variables in one shot, by pattern matching
  val (number, string) = myTuple

  println(s"$myTuple, $number, $string")
