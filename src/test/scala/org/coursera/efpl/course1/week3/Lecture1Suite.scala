/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 3 - Data and Abstraction - Lecture 3.1 - Class hierarchies
 */
package org.coursera.efpl.course1.week3

class Lecture1Suite extends munit.FunSuite:
  test("singleton") {
    val s = IntSet.singleton(42)
    assert(s.contains(42))
    assert(!s.contains(24))
  }

  test("non-empty") {
    val s = NonEmpty(42, Empty, Empty)
    assert(s.contains(42))
    assert(!s.contains(24))
  }

end Lecture1Suite
