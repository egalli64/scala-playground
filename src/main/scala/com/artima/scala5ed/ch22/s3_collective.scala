/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Extension Methods - Collective extensions
 */
package com.artima.scala5ed.ch22

@main
def s3_collective(): Unit =
  println(s"The integer min ${Int.MinValue} absolute value is ${Int.MinValue.abs}!")
  println(s"The integer min ${Int.MinValue} negated is ${-Int.MinValue}!")

  // sibling methods
  extension (n: Int)
    def absOption: Option[Int] = if n != Int.MinValue then Some(n.abs) else None
    def negateOption: Option[Int] = if n != Int.MinValue then Some(n) else None

  println(s"The integer min ${Int.MinValue} absolute value is ${Int.MinValue.absOption}!")
  println(s"The integer min ${Int.MinValue} negated is ${Int.MinValue.negateOption}!")

  // another sibling method in another extension
  extension (n: Int) def isMinValue: Boolean = n == Int.MinValue

  println(s"The integer min ${Int.MinValue} is the minimal value: ${Int.MinValue.isMinValue}")
