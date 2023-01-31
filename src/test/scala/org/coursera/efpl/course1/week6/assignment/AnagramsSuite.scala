/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 6 - Collections - Practice Programming Assignment: Anagrams
 */
package org.coursera.efpl.course1.week6.assignment

class AnagramsSuite extends munit.FunSuite:
  import Anagrams.*

  test("wordOccurrences: abode") {
    val expected = List(('a', 1), ('b', 1), ('d', 1), ('e', 1), ('o', 1))
    assertEquals(wordOccurrences("abode"), expected)
  }

  test("wordOccurrences: Robert (3pts)") {
    val expected = List(('b', 1), ('e', 1), ('o', 1), ('r', 2), ('t', 1))
    assertEquals(wordOccurrences("Robert"), expected)
  }

  test("sentenceOccurrences: abode e (5pts)") {
    val expected = List(('a', 1), ('b', 1), ('d', 1), ('e', 2), ('o', 1))
    assertEquals(sentenceOccurrences(List("abode", "e")), expected)
  }

  test("dictionaryByOccurrences.get: eat (10pts)") {
    val occurrences = List(('a', 1), ('e', 1), ('t', 1))
    val expected = List("ate", "eat", "tea")
    dictionaryByOccurrences.get(occurrences) match
      case Some(actual) => assertEquals(actual, expected)
      case None         => fail("Missing values")
  }

  test("dictionaryByOccurrences missing: xxx") {
    val occurrences = List(('x', 3))
    assertEquals(dictionaryByOccurrences(occurrences), Nil)
  }

  test("wordAnagrams married (2pts)") {
    assertEquals(wordAnagrams("married").toSet, Set("married", "admirer"))
  }

  test("wordAnagrams player (2pts)") {
    assertEquals(wordAnagrams("player").toSet, Set("parley", "pearly", "player", "replay"))
  }
