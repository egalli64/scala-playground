/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 2 - High Order Functions - Lecture 2.5 - Functions and Data
 */
package org.coursera.efpl.course1.week2

class Lecture5Suite extends munit.FunSuite:
  test("Rational creation") {
    val r = Rational(1, 2)
    assertEquals(r.numerator, 1)
    assertEquals(r.denominator, 2)
  }

