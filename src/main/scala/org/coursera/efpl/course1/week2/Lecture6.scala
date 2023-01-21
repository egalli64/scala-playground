/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 2 - High Order Functions - Lecture 2.6 - More Fun with Rationals
 */
package org.coursera.efpl.course1.week2

import scala.annotation.tailrec

/**
 * A Rational that simplify numerator and denominator on creation
 * Contextually, we are defining the _primary constructor_
 * <li>all the the statements in the class body are executed
 *
 * @param x numerator
 * @param y denominator */
class Rational6(x: Int, y: Int):
  // Precondition: IllegalArgumentException if not true
  require(y > 0, "Denominator must be positive")

  /**
   * Greater Common Divisor, implementation detail
   *
   * @param a a value
   * @param b other value
   * @return their GCD
   * */
  @tailrec
  private def gcd(a: Int, b: Int): Int = if b == 0 then a else gcd(b, a % b)

  // we should ensure that GCD is positive, otherwise we could try to set the denominator as negative!
  // no need to do the same on y, see require() above
  val numerator: Int = x / gcd(x.abs, y)
  val denominator: Int = y / gcd(x.abs, y)

  /**
   * Auxiliary constructor, here to default the denominator to 1
   *
   * @param x numerator */
  def this(x: Int) = this(x, 1)

  /**
   * Create a new rational by adding a rational to the current on
   * Using "this" could make the code more readable
   *
   * @param that another rational
   * @return the addition */
  def add(that: Rational6): Rational6 =
    Rational6(this.numerator * that.denominator + that.numerator * this.denominator, this.denominator * that.denominator)

  /**
   * Comparing rationals
   *
   * @param that another rational
   * @return true if this rational is less than other one */
  def less(that: Rational6): Boolean =
    this.numerator * that.denominator < that.numerator * this.denominator

  /**
   * Comparing rationals - here the use of "this" let us return the current element
   *
   * @param that another rational
   * @return the largest between the two ones */
  def max(that: Rational6): Rational6 =
    if this.less(that) then that else this

  override def toString: String = s"$numerator/$denominator"

  // the end marker is not mandatory but could improve readability
end Rational6

@main def lecture6(): Unit =
  val r1 = Rational6(12, 24)
  val r2 = Rational6(2, 8)
  val r3 = r1.add(r2)
  println(s"$r1 + $r2 = $r3")
  println(s"Is $r1 less than $r3? ${r1.less(r3)}")
  println(s"$r1 and $r3, the largest is ${r1.max(r3)}")

  // require() is to ensure _the caller_ doesn't pass an unexpected argument
  try
    Rational6(1, -1)
  catch
    case ex: IllegalArgumentException => println(ex)

  // assert() is to ensure _our code_ behaves as expected
  try
    val positive = -2
    assert(positive > 0, "The value should be positive")
  catch
    case ex: AssertionError => println(ex)

  // Using an auxiliary constructor
  println("Four as a rational: " + Rational6(4))
