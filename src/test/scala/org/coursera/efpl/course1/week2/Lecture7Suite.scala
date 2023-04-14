/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 2 - High Order Functions - Lecture 2.7 - Evaluations and Operators
 */
package org.coursera.efpl.course1.week2

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Lecture7Suite extends AnyFunSuite with Matchers:
  test("Rational7 creation") {
    val r = Rational7(1, 2)

    r.numerator shouldBe 1
    r.denominator shouldBe 2
  }

  test("Adding rational") {
    val r = Rational7(1, 2) + Rational7(1, 3)

    r.numerator shouldBe 5
    r.denominator shouldBe 6
  }
