/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 1 - Functions & Evaluations - Practice Programming Assignment: Recursion
 */
package org.coursera.efpl.course1.week1.assignment

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class RecursionSuite extends AnyFunSuite with Matchers:
  import Recursion.*

  // pascal
  test("pascal: col=0,row=2") {
    pascal(0, 2) shouldBe 1
  }

  test("pascal: col=1,row=2") {
    pascal(1, 2) shouldBe 2
  }

  test("pascal: col=1,row=3") {
    pascal(1, 3) shouldBe 3
  }

  // balance tests
  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    val input = "(if (zero? x) max (/ 1 x))".toList
    balance(input) shouldBe true
  }

  test("balance: 'I told him ...' is balanced") {
    val input = "I told him (that it's not (yet) done).\n(But he wasn't listening)".toList
    balance(input) shouldBe true
  }

  test("balance: ':-)' is unbalanced") {
    val input = ":-)".toList
    balance(input) shouldBe false
  }

  test("balance: counting is not enough") {
    val input = "())(".toList
    balance(input) shouldBe false
  }

  // countChange

  test("countChange: example given in instructions") {
    countChange(4, List(1, 2)) shouldBe 3
  }

  test("countChange: sorted CHF") {
    countChange(300, List(5, 10, 20, 50, 100, 200, 500)) shouldBe 1022
  }

  test("countChange: no pennies") {
    countChange(301, List(5, 10, 20, 50, 100, 200, 500)) shouldBe 0
  }

  test("countChange: unsorted CHF") {
    countChange(300, List(500, 5, 50, 100, 20, 200, 10)) shouldBe 1022
  }
