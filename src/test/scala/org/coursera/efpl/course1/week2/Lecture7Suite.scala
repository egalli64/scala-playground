/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 2 - High Order Functions - Lecture 2.7 - Evaluations and Operators
 */
package org.coursera.efpl.course1.week2

class Lecture7Suite extends munit.FunSuite:
  test("Rational7 creation") {
    val r = Rational7(1, 2)
    assertEquals(r.numerator, 1)
    assertEquals(r.denominator, 2)
  }

  test("Adding rational") {
    val r = Rational7(1, 2) + Rational7(1, 3)
    assertEquals(r.numerator, 5)
    assertEquals(r.denominator, 6)
  }
