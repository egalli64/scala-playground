/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 5 - Lists - Lecture 5.3 - Higher-order list functions
 */
package org.coursera.efpl.course1.week5

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Lecture3Suite extends AnyFunSuite with Matchers:
  test("pack nil") {
    pack(Nil) shouldBe Nil
  }

  test("pack simple") {
    pack(List(1, 2, 3)) shouldBe List(List(1), List(2), List(3))
  }

  test("pack triplet") {
    pack(List(1, 1, 1)) shouldBe List(List(1, 1, 1))
  }

  test("pack sample") {
    val l = List("a", "a", "a", "b", "c", "c", "a")
    val expected = List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))
    pack(l) shouldBe expected
  }

  test("encode sample") {
    val l = List("a", "a", "a", "b", "c", "c", "a")
    val expected = List(("a", 3), ("b", 1), ("c", 2), ("a", 1))
    encode(l) shouldBe expected
  }
