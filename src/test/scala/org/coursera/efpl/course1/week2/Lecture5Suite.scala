/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 2 - High Order Functions - Lecture 2.5 - Functions and Data
 */
package org.coursera.efpl.course1.week2

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Lecture5Suite extends AnyFunSuite with Matchers:
  test("Rational creation") {
    val r = Rational(1, 2)

    r.numerator shouldBe 1
    r.denominator shouldBe 2
  }
