/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 2 - High Order Functions - Lecture 2.5 - Functions and Data
 */
package org.coursera.efpl.course1.week2

class Rational(x: Int, y:Int):
  def numerator: Int = x
  def denominator: Int = y
  def add(that: Rational): Rational =
    Rational(numerator * that.denominator + that.numerator * denominator, denominator * that.denominator)
  def mul(that: Rational): Rational =
    Rational(numerator * that.numerator, denominator * that.denominator)

  // exercise 1: unary minus, create a new rational changed in sign
  def neg: Rational = Rational(-numerator, denominator)
  // exercise 2: subtraction
  def sub(that: Rational): Rational = this.add(that.neg)

  // mandatory modifier for overriding method - interpolation in the lighter form
  override def toString: String = s"$numerator/$denominator"

@main
def lecture5(): Unit =
  val r1: Rational = Rational(1, 2)
  printf("A rational with numerator %d, denominator %d%n", r1.numerator, r1.denominator)
  // interpolated string
  println(s"A rational: ${r1.numerator}/${r1.denominator}")

  val r2 = Rational(1, 10)
  val r3 = r1.add(r2).mul(r1)
  println("A rational: " + r3)

  println("A negative rational: " + r1.neg)
  println("Subtraction: " + r1.sub(r2).sub(r3))