/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functional Objects - Auxiliary constructors
 */
package com.artima.scala5ed.ch06

@main
def s07constructors(): Unit =
  /**
   * A class with an auxiliary constructor (besides the primary constructor)
   *
   * @param numerator
   *   the numerator
   * @param denominator
   *   the denominator
   */
  class Rational(val numerator: Int, val denominator: Int):
    require(denominator != 0)

    /**
     * An auxiliary constructor - denominator defaulted to 1
     *
     * Each auxiliary constructor must invoke another constructor of the same class as first action
     *
     * Only the primary constructor can invoke a superclass constructor
     *
     * @param numerator
     *   the numerator
     */
    def this(numerator: Int) = this(numerator, 1)

    override def toString = s"$numerator/$denominator"

  val r = Rational(3)
  println(r)
