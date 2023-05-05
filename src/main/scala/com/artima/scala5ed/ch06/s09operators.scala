/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functional Objects - Defining operators
 */
package com.artima.scala5ed.ch06

import scala.annotation.{tailrec, targetName}

@main
def s09operators(): Unit =
  class Rational(n: Int, d: Int):
    require(d != 0)
    private val g = gcd(n.abs, d.abs)
    val numerator: Int = n / g
    val denominator: Int = d / g

    def this(n: Int) = this(n, 1)

    /**
     * "+" is a valid method name, the target name could be used externally to Java
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
     * "*" is a valid method name, the target name could be used externally to Java
     *
     * @param that
     *   the other rational
     * @return
     *   this * that
     */
    @targetName("multiply")
    def *(that: Rational): Rational =
      Rational(numerator * that.numerator, denominator * that.denominator)

    override def toString = s"$numerator/$denominator"

    @tailrec
    private def gcd(a: Int, b: Int): Int = if b == 0 then a else gcd(b, a % b)

  val x = Rational(1, 2)
  val y = Rational(2, 3)
  println(s"$x + $y = ${x + y}")
  println(s"$x * $y = ${x * y}")
