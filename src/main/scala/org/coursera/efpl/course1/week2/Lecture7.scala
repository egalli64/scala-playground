/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 2 - High Order Functions - Lecture 2.7 - Evaluations and Operators
 */
package org.coursera.efpl.course1.week2

import scala.annotation.{tailrec, targetName}

/**
 * Based on Rational6 in Lecture6
 *
 * @param x numerator
 * @param y denominator
 */
class Rational7(x: Int, y: Int):
  @tailrec
  private def gcd(a: Int, b: Int): Int = if b == 0 then a else gcd(b, a % b)

  val numerator: Int = x / gcd(x.abs, y)
  val denominator: Int = y / gcd(x.abs, y)

  def add(that: Rational7): Rational7 =
    Rational7(this.numerator * that.denominator + that.numerator * this.denominator, this.denominator * that.denominator)

  override def toString: String = s"$numerator/$denominator"
end Rational7

/*
  Extension to Rational7 - is used by the code that can see it!

  no access to "this", use the parameter instead (here "r")
  can only add new member
 */
extension (r: Rational7)
  def abs: Rational7 = Rational7(r.numerator.abs, r.denominator)

/*
  A class could have many extensions.

  Operator by relaxed identifier
 */
extension(r: Rational7)
  @targetName("add")
  def +(t: Rational7): Rational7 = r.add(t)

@main
def lecture7(): Unit =
  val r1 = Rational7(1, 2)
  val r2 = Rational7(-1, 3)
  val r3 = r1.add(r2)
  println(s"$r1 + $r2 = $r3")

  val r4 = r2.abs
  println(s"$r2 abs is $r4")

  val r5 = r1 + r4
  println(s"$r1 + $r4 = $r5")
