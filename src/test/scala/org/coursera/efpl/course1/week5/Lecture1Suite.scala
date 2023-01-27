/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 5 - Lists - Lecture 5.1 - A Closer Look at Lists
 */
package org.coursera.efpl.course1.week5

class Lecture1Suite extends munit.FunSuite:
  trait TestLists:
    val fruits: List[String] = List("Apple", "Orange", "Banana")
    val single: List[Int] = List(42)

  test("my last for list") {
    new TestLists:
      assertEquals(last(fruits), "Banana")
      assertEquals(last(single), 42)
      intercept[NoSuchElementException] {
        last(Nil)
      }
  }

  test("my init for list") {
    new TestLists:
      assertEquals(init(fruits), List("Apple", "Orange"))
      assertEquals(init(single), Nil)
      intercept[UnsupportedOperationException] {
        init(Nil)
      }
  }

  test("my concatenate for lists") {
    new TestLists:
      assertEquals(concatenate(fruits, Nil), fruits)
  }

  test("my reverse for list") {
    new TestLists:
      assertEquals(reverse(fruits), List("Banana", "Orange", "Apple"))
  }

  test("my removeAt for list") {
    new TestLists:
      assertEquals(removeAt(1, fruits), List("Apple", "Banana"))
  }

  test("my flatten (for list)") {
    val xs = List(List(1, 1), 2, List(3, List(5, 8)))
    assertEquals(flatten(xs), List(1, 1, 2, 3, 5, 8))
  }
