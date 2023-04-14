/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 2 - High Order Functions - Lecture 2.6 - More Fun with Rationals
 */
package org.coursera.efpl.course1.week2

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Lecture6Suite extends AnyFunSuite with Matchers:
  test("Rational6 creation") {
    val r = Rational6(1, 2)

    r.numerator shouldBe 1
    r.denominator shouldBe 2
  }

  test("RationalLazy creation") {
    val r = RationalLazy(1, 2)

    r.numerator shouldBe 1
    r.denominator shouldBe 2
  }
