/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 5 - Lists - Lecture 5.3 - Higher-order list functions
 */
package org.coursera.efpl.course1.week5

class Lecture3Suite extends munit.FunSuite:
  test("pack nil") {
    assertEquals(pack(Nil), Nil)
  }

  test("pack simple") {
    assertEquals(pack(List(1, 2, 3)), List(List(1), List(2), List(3)))
  }

  test("pack triplet") {
    assertEquals(pack(List(1, 1, 1)), List(List(1, 1, 1)))
  }

  test("pack sample") {
    val l = List("a", "a", "a", "b", "c", "c", "a")
    val expected = List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))
    assertEquals(pack(l), expected)
  }

  test("encode sample") {
    val l = List("a", "a", "a", "b", "c", "c", "a")
    val expected = List(("a", 3), ("b", 1), ("c", 2), ("a", 1))
    assertEquals(encode(l), expected)
  }
