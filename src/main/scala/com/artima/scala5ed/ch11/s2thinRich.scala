/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Traits - Thin versus rich interfaces
  - A trait can enrich a thin interface, making it into a rich interface
 */
package com.artima.scala5ed.ch11

import scala.annotation.{tailrec, targetName}

@main
def s1thin(): Unit =
  /**
   * Rich interface _without_ trait
   *
   * @param n
   *   numerator
   * @param d
   *   denominator
   */
  class RationalRich(n: Int, d: Int):
    private val g = gcd(n.abs, d.abs)
    val numerator: Int = n / g
    val denominator: Int = d / g

    @targetName("lt")
    def <(that: RationalRich): Boolean =
      this.numerator * that.denominator < that.numerator * this.denominator
    @targetName("gt")
    def >(that: RationalRich): Boolean = that < this
    @targetName("le")
    def <=(that: RationalRich): Boolean = (this < that) || (this == that)
    @targetName("ge")
    def >=(that: RationalRich): Boolean = (this > that) || (this == that)

    @tailrec
    private def gcd(a: Int, b: Int): Int = if b == 0 then a else gcd(b, a % b)

    override def toString = s"$numerator/$denominator"

  val rr1 = RationalRich(1, 2)
  val rr2 = RationalRich(3, 4)
  println(s"$rr1 <= $rr2 ? ${rr1 <= rr2}")
  println(s"$rr1 >= $rr2 ? ${rr1 >= rr2}")

  /**
   * Rich interface _with_ trait, mixing in Ordered
   *
   * @param n
   *   numerator
   * @param d
   *   denominator
   */
  class Rational(n: Int, d: Int) extends Ordered[Rational]:
    private val g = gcd(n.abs, d.abs)
    val numerator: Int = n / g
    val denominator: Int = d / g

    // Abstract method required by Ordered, used to implement <, >, ...
    def compare(that: Rational): Int =
      this.numerator * that.denominator - that.numerator * this.denominator

    @tailrec
    private def gcd(a: Int, b: Int): Int = if b == 0 then a else gcd(b, a % b)

    override def toString = s"$numerator/$denominator"

  val r1 = Rational(1, 2)
  val r2 = Rational(3, 4)
  println(s"$r1 <= $r2 ? ${r1 <= r2}")
  println(s"$r1 >= $r2 ? ${r1 >= r2}")
