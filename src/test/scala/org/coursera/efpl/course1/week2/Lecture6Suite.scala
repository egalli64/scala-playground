/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 2 - High Order Functions - Lecture 2.6 - More Fun with Rationals
 */
package org.coursera.efpl.course1.week2

class Lecture6Suite extends munit.FunSuite:
  test("Rational6 creation") {
    val r = Rational6(1, 2)
    assertEquals(r.numerator, 1)
    assertEquals(r.denominator, 2)
  }

  test("RationalLazy creation") {
    val r = RationalLazy(1, 2)
    assertEquals(r.numerator, 1)
    assertEquals(r.denominator, 2)
  }
