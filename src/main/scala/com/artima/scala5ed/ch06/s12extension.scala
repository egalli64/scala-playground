/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functional Objects - Extension methods
 */
package com.artima.scala5ed.ch06

import scala.annotation.{tailrec, targetName}

@main
def s12extension(): Unit =
  class Rational(n: Int, d: Int):
    require(d != 0)

    private val g = gcd(n.abs, d.abs)
    val numerator: Int = n / g
    val denominator: Int = d / g

    def this(n: Int) = this(n, 1)

    @targetName("plus")
    def +(that: Rational): Rational =
      Rational(
        numerator * that.denominator + that.numerator * denominator,
        denominator * that.denominator
      )

    @targetName("plus")
    def +(i: Int): Rational = Rational(numerator + i * denominator, denominator)

    override def toString = s"$numerator/$denominator"

    @tailrec
    private def gcd(a: Int, b: Int): Int =
      if b == 0 then a else gcd(b, a % b)

  /**
   * Add methods to an existing class, even a standard one as Int!
   *
   * For extension methods to work, they need to be in scope for the using code
   */
  extension (x: Int)
    @targetName("plus")
    def +(y: Rational): Rational = Rational(x) + y

  val r = Rational(2, 3)
  println(2 + r)
  println(r + 2)
