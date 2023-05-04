/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functional Objects - Private fields and methods
 */
package com.artima.scala5ed.ch06

import scala.annotation.tailrec

@main
def s08private(): Unit =
  class Rational(n: Int, d: Int):
    require(d != 0)

    // internal detail, the GCD, used to simplify numerator and denominator - when possible
    private val g = gcd(n.abs, d.abs)
    val numerator: Int = n / g
    val denominator: Int = d / g

    def this(n: Int) = this(n, 1)

    override def toString = s"$numerator/$denominator"

    /**
     * Internal detail, used to calculate the GCD
     * @param a
     *   an integer
     * @param b
     *   another integer
     * @return
     *   their GCD
     */
    @tailrec
    private def gcd(a: Int, b: Int): Int = if b == 0 then a else gcd(b, a % b)

  val r = Rational(66, 42)
  println(r)
