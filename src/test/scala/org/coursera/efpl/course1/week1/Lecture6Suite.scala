/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 1 - Functions & Evaluations - Lecture 1.6 - Blocks and lexical scope
 */
package org.coursera.efpl.course1.week1

class Lecture6Suite extends munit.FunSuite:
  import Lecture6.sqrt

  test("Square root of 'normal' number") {
    assertEqualsDouble(sqrt(121.0), 11.0, 0.000_001)
  }

  test("Square root of 1") {
    assertEqualsDouble(sqrt(1.0), 1.0, 0.000_001)
  }

  test("Square root of small number") {
    assertEqualsDouble(sqrt(0.1e-20), Math.sqrt(0.1e-20), 0.000_001)
  }

  test("Square root of big number") {
    assertEqualsDouble(sqrt(1e20), Math.sqrt(1e20), 0.000_001)
  }

  test("Square root of very big number") {
    assertEqualsDouble(sqrt(1e50), Math.sqrt(1e50), 0.000_001)
  }