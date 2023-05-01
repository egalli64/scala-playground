/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functional Objects - Constructing a Rational
 */
package com.artima.scala5ed.ch06

@main
def s02constructing(): Unit =

  /**
   * Rational objects are immutable
   *
   * The compiler generates the class _primary constructor_ using the _class parameters_, any code
   * in the class body that is not part of a method, is put in its body
   *
   * @param numerator
   *   first class parameter
   * @param denominator
   *   second class parameter
   */
  class Rational(numerator: Int, denominator: Int):
    println("Created " + numerator + "/" + denominator)

  // No need of using the keyword "new" if the class has parameters, a universal apply method does the trick
  Rational(3, 5)
