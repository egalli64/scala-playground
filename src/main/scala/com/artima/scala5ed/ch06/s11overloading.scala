/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functional Objects - Method overloading
 */
package com.artima.scala5ed.ch06

import scala.annotation.{tailrec, targetName}

@main
def s11overloading(): Unit =
  class Rational(n: Int, d: Int):
    require(d != 0)

    private val g = gcd(n.abs, d.abs)
    val numerator: Int = n / g
    val denominator: Int = d / g

    def this(n: Int) = this(n, 1)

    /**
     * Adding the current rational to the param - first overload
     *
     * @param that
     *   the other rational
     * @return
     *   this + that
     */
    @targetName("plus")
    def +(that: Rational): Rational =
      Rational(
        numerator * that.denominator + that.numerator * denominator,
        denominator * that.denominator
      )

    /**
     * Adding the current rational to the param - second overload
     *
     * @param i
     *   an integer
     * @return
     *   this + i
     */
    @targetName("plus")
    def +(i: Int): Rational = Rational(numerator + i * denominator, denominator)

    override def toString = s"$numerator/$denominator"

    @tailrec
    private def gcd(a: Int, b: Int): Int =
      if b == 0 then a else gcd(b, a % b)

  val r = Rational(2, 3) // 2/3
  println(s"$r + $r = ${r + r}")
  println(s"$r + 2 = ${r + 2}")
