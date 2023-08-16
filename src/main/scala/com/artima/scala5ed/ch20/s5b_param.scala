/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Abstract Members - Initializing abstract val's

  Trait parametric fields: trait fields values are computed _before_ the trait initialization!
 */
package com.artima.scala5ed.ch20

import scala.annotation.{tailrec, targetName}

@main
def s5b_param(): Unit =
  trait RationalTrait(val numerator: Int, val denominator: Int):
    require(denominator != 0)
    private val g = gcd(numerator, denominator)
    val _numerator: Int = numerator / g
    val _denominator: Int = denominator / g

    @tailrec
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    override def toString = s"$_numerator/$_denominator"

  val x = 42
  // generating on the fly an anonymous class with trait parametric fields, notice the empty class body!
  val rt = new RationalTrait(1 * x, 2 * x) {}
  println(rt)

  // object definition based on a trait with parametric fields
  object TwoThirds extends RationalTrait(2, 3)
  println(TwoThirds)

  class RationalClass(numerator: Int, denominator: Int)
      extends RationalTrait(numerator, denominator):
    @targetName("plus")
    def +(that: RationalClass) = new RationalClass(
      _numerator * that._denominator + that._numerator * _denominator,
      _denominator * that._denominator
    )

  val rc1 = RationalClass(1, 3)
  val rc2 = RationalClass(1, 4)
  val rc3 = rc1 + rc2

  println(s"$rc1 + $rc2 = $rc3")
