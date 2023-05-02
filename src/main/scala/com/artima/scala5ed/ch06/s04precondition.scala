/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functional Objects - Checking preconditions
 */
package com.artima.scala5ed.ch06

@main
def s04precondition(): Unit =
  /**
   * Use require() to enforce preconditions - an IllegalArgumentException is thrown when fail
   *
   * @param numerator
   *   the numerator
   * @param denominator
   *   the denominator
   */
  class Rational(numerator: Int, denominator: Int):
    require(denominator != 0)
    override def toString = s"$numerator/$denominator"

  try Rational(5, 0)
  catch case ex: IllegalArgumentException => println(ex)
