/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functional Objects - Self references
 */
package com.artima.scala5ed.ch06

@main
def s06this(): Unit =
  /**
   * To explicitly refer to the current object instance use "this"
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
     * Compare two rationals
     *
     * @param that
     *   another rational
     * @return
     *   true if the current rational is less than the other one
     */
    def lessThan(that: Rational): Boolean =
      // using "this" here is not mandatory but makes the code more balanced
      this.numerator * that.denominator < that.numerator * this.denominator

    /**
     * Compare two rationals
     *
     * @param that
     *   another rational
     * @return
     *   the largest one
     */
    def max(that: Rational): Rational =
      // lessThan() is implicitly called on "this", but to return the current object we have to use "this"
      if this.lessThan(that) then that else this

  val r1 = Rational(1, 2)
  val r2 = Rational(3, 4)

  println(s"$r1 is less than $r2? ${r1.lessThan(r2)}")
  println(s"Comparing $r1 and $r2, the largest is ${r1.max(r2)}")
