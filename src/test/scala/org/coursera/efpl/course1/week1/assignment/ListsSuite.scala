/*
  Functional Programming Principles in Scala - Getting Started
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 1 - Getting Started - Example - Practice Programming Assignment
 */
package org.coursera.efpl.course1.week1.assignment

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ListsSuite extends AnyFunSuite with Matchers:
  import Lists.*

  test("sum of a few numbers") {
    sum(List(1, 2, 0)) shouldBe 3
  }

  test("max of a few numbers") {
    max(List(3, 7, 2)) shouldBe 7
  }
