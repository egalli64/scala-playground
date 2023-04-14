/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 5 - Lists - Lecture 5.1 - A Closer Look at Lists
 */
package org.coursera.efpl.course1.week5

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Lecture1Suite extends AnyFunSuite with Matchers:
  trait TestLists:
    val fruits: List[String] = List("Apple", "Orange", "Banana")
    val single: List[Int] = List(42)

  test("my last for list") {
    new TestLists:
      last(fruits) shouldBe "Banana"
      last(single) shouldBe 42
      intercept[NoSuchElementException] {
        last(Nil)
      }
  }

  test("my init for list") {
    new TestLists:
      init(fruits) shouldBe List("Apple", "Orange")
      init(single) shouldBe Nil
      intercept[UnsupportedOperationException] {
        init(Nil)
      }
  }

  test("my concatenate for lists") {
    new TestLists:
      concatenate(fruits, Nil) shouldBe fruits
  }

  test("my reverse for list") {
    new TestLists:
      reverse(fruits) shouldBe List("Banana", "Orange", "Apple")
  }

  test("my removeAt for list") {
    new TestLists:
      removeAt(1, fruits) shouldBe List("Apple", "Banana")
  }

  test("my flatten (for list)") {
    val xs = List(List(1, 1), 2, List(3, List(5, 8)))
    flatten(xs) shouldBe List(1, 1, 2, 3, 5, 8)
  }
