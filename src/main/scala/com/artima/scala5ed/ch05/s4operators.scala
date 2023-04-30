/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Basic Types and Operations - Operators are methods
 */
package com.artima.scala5ed.ch05

@main
def s4operators(): Unit =
  // The infix operator + is actually an overloaded method defined for Int
  val sumByOperator = 1 + 2
  val sumByMethod = 1.+(2)
  val sumLong = 1 + 2L
  println(s"$sumByOperator is $sumByMethod is $sumLong")

  // Any method taking just one parameter could be used as an infix operator
  val s = "Hello, world!"
  // Using the operator notation to invoke indexOf
  val oPos = s indexOf 'o'
  println(s"Getting the position of the first 'o', calling indexOf as an operator: $oPos")

  // There are only 4 prefix operators: + - ! ~, their method names start by "unary_", es: unary_-
  println(s"${-2}")

  // Any method taking no parameter could be used as postfix operator
  println(s.toLowerCase)

  // It is recommended not to enable this feature except for legacy code
  import scala.language.postfixOps
  val t: String = s toLowerCase;
  println(t)
