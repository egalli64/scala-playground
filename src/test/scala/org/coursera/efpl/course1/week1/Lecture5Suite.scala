/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 1 - Functions & Evaluations - Lecture 1.5 - Square root with Newton's method
 */
package org.coursera.efpl.course1.week1

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Lecture5Suite extends AnyFunSuite with Matchers:
  import Lecture5.sqrt

  test("Square root of 'normal' number") {
    sqrt(121.0) shouldBe 11.0
  }

  test("Square root of 1") {
    sqrt(1.0) shouldBe (1.0 +- 1e-15)
  }

  test("Square root of small number") {
    sqrt(1e-21) shouldBe (9.536e-7 +- 1e-10)
  }

  test("Square root of big number") {
    sqrt(1e21) shouldBe (31_622_776_601.0 +- 1.0)
  }

  test("Square root of very big number") {
    sqrt(1e51) shouldBe (3.162_277_660e25 +- 1e16)
  }
