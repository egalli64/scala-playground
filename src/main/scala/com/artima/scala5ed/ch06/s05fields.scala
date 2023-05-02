/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functional Objects - Adding fields
 */
package com.artima.scala5ed.ch06

@main
def s05fields(): Unit =
  /**
   * If the class parameter are not specified as val or var they can be accessed only in the current
   * object
   *
   * To let them be accessible as field val/var should be defined in the class body and properly
   * assigned - or use val/var in the parameter list
   *
   * @param numerator
   *   the numerator
   * @param denominator
   *   the denominator
   */
  class Rational(val numerator: Int, val denominator: Int):
    require(denominator != 0)

    override def toString = s"$numerator/$denominator"

    /**
     * Not even a method could access a private field in _another_ object of the same class
     *
     * @param that
     *   another rational
     * @return
     *   a new rational sum of the two original ones
     */
    def add(that: Rational): Rational =
      Rational(
        numerator * that.denominator + that.numerator * denominator,
        denominator * that.denominator
      )

  val oneHalf = Rational(1, 2)
  // if not stated differently, fields are public
  println(s"$oneHalf is ${oneHalf.numerator} divided by ${oneHalf.denominator}")
  val twoThirds = Rational(2, 3)
  val result = oneHalf.add(twoThirds)
  println(s"$oneHalf + $twoThirds = $result")
