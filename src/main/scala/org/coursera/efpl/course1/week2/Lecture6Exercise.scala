/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 2 - High Order Functions - Lecture 2.6 - More Fun with Rationals
 */
package org.coursera.efpl.course1.week2

import scala.annotation.tailrec

class RationalLazy(x: Int, y: Int):
  require(y > 0, s"$x $y - denominator must be positive")

  @tailrec private def gcd(a: Int, b: Int): Int = if b == 0 then a else gcd(b, a % b)

  val numerator: Int = x
  val denominator: Int = y

  def add(that: RationalLazy): RationalLazy = RationalLazy(this.numerator * that.denominator + that.numerator * this.denominator, this.denominator * that.denominator)

  override def toString: String =
    val g = gcd(numerator, denominator)
    val num = numerator / g
    val den = denominator / g
    s"$num/$den"


@main def lecture6Exercise(): Unit =
  // this works fine
  val r1 = RationalLazy(6, 8)
  val r2 = RationalLazy(4, 32)

  println(s"$r1 + $r2 = ${r1.add(r2)}")

// but: beware of overflow!
