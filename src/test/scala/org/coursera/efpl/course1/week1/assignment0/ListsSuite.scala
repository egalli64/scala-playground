/*
  Functional Programming Principles in Scala - Getting Started
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 1 - Getting Started - Example - Practice Programming Assignment
 */
package org.coursera.efpl.course1.week1.assignment0

import org.coursera.efpl.course1.week1.assigment0.Lists.Lists.*

class ListsSuite extends munit.FunSuite:
  test("sum of a few numbers") {
    assert(sum(List(1, 2, 0)) == 3)
  }

  test("max of a few numbers") {
    assert(max(List(3, 7, 2)) == 7)
  }
