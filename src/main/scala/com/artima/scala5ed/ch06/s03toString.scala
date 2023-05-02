/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functional Objects - Reimplementing the toString method
 */
package com.artima.scala5ed.ch06

@main
def s03toString(): Unit =
  /**
   * Override in Scala is explicit
   *
   * @param numerator
   *   the numerator
   * @param denominator
   *   the denominator
   */
  class Rational(numerator: Int, denominator: Int):
    override def toString = s"$numerator/$denominator"

  val x = Rational(1, 3)
  println(x)

  val y = Rational(5, 7)
  println(y)
