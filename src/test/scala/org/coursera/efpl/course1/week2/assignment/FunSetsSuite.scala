/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 2 - Functions & Evaluations - Practice Programming Assignment: Functional Sets
 */
package org.coursera.efpl.course1.week2.assignment

class FunSetsSuite extends munit.FunSuite:

  import FunSets.*

  trait TestSets:
    val s1: FunSet = singletonSet(1)
    val s2: FunSet = singletonSet(2)
    val s3: FunSet = singletonSet(3)
    val odds: FunSet = x => x % 2 == 1

  test("singleton one") {
    /**
     * Testing on a new instance of the TestSets trait */
    new TestSets:
      assert(contains(s1, 1), "expecting 1")
      assert(!contains(s1, 2), "not expecting 2")
  }

  test("union one and two") {
    new TestSets:
      val s: FunSet = union(s1, s2)
      assert(contains(s, 1), "expecting 1")
      assert(contains(s, 2), "expecting 2")
      assert(!contains(s, 3), "not expecting 3")
  }

  test("intersect one and odds") {
    new TestSets:
      val s: FunSet = intersect(s1, odds)
      assert(contains(s, 1), "expecting 1")
      assert(!contains(s, 33), "not expecting 33")
  }

  test("diff odds and one") {
    new TestSets:
      val s: FunSet = diff(odds, s1)
      assert(!contains(s, 1), "not expecting 1")
      assert(contains(s, 3), "expecting 3")
  }

  test("filter odds and x less than 10") {
    new TestSets:
      val s: FunSet = filter(odds, x => x < 10)
      assert(contains(s, 9), "expecting 9")
      assert(!contains(s, 11), "not expecting 11")
  }

  test("forall one, two, and three") {
    new TestSets:
      val s: FunSet = union(union(s1, s2), s3)
      assert(forall(s, x => x > 0 && x < 4), "x in [0,4), expecting true")
      assert(!forall(s, x => x > 0 && x < 3), "x in [0,3), not expecting true")
  }

  test("exists one, two, and three") {
    new TestSets:
      val s: FunSet = union(union(s1, s2), s3)
      assert(exists(s, x => x == 2), "expecting 2")
      assert(!exists(s, x => x < 0), "not expecting negative")
  }

  test("map odds to even") {
    new TestSets:
      val s: FunSet = map(odds, x => x + 1)
      assert(forall(s, x => x % 2 == 0), "expecting all even")
  }

  test("map one, two, and three to negative") {
    new TestSets:
      val s: FunSet = map(union(union(s1, s2), s3), x => -x)
      assert(exists(s, x => x == -2), "expecting -2")
      assert(!exists(s, x => x > 0), "not expecting positive")
  }

  import scala.concurrent.duration.*

  override val munitTimeout: FiniteDuration = 10.seconds
end FunSetsSuite
