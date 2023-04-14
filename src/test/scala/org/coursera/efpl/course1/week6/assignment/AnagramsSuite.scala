/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 6 - Collections - Practice Programming Assignment: Anagrams
 */
package org.coursera.efpl.course1.week6.assignment

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class AnagramsSuite extends AnyFunSuite with Matchers:
  import Anagrams.*

  test("wordOccurrences: abode") {
    val expected = List(('a', 1), ('b', 1), ('d', 1), ('e', 1), ('o', 1))
    wordOccurrences("abode") shouldBe expected
  }

  test("wordOccurrences: Robert (3pts)") {
    val expected = List(('b', 1), ('e', 1), ('o', 1), ('r', 2), ('t', 1))
    wordOccurrences("Robert") shouldBe expected
  }

  test("sentenceOccurrences: abode e (5pts)") {
    val expected = List(('a', 1), ('b', 1), ('d', 1), ('e', 2), ('o', 1))
    sentenceOccurrences(List("abode", "e")) shouldBe expected
  }

  test("dictionaryByOccurrences.get: eat (10pts)") {
    val occurrences = List(('a', 1), ('e', 1), ('t', 1))
    val expected = List("ate", "eat", "tea")
    dictionaryByOccurrences.get(occurrences) match
      case Some(actual) => actual shouldBe expected
      case None         => fail("Missing values")
  }

  test("dictionaryByOccurrences missing: xxx") {
    val occurrences = List(('x', 3))
    dictionaryByOccurrences(occurrences) shouldBe Nil
  }

  test("wordAnagrams married (2pts)") {
    wordAnagrams("married").toSet shouldBe Set("married", "admirer")
  }

  test("wordAnagrams player (2pts)") {
    wordAnagrams("player").toSet shouldBe Set("parley", "pearly", "player", "replay")
  }

  test("combinations: [] (8pts)") {
    combinations(Nil) shouldBe List(Nil)
  }

  test("combinations: a") {
    val input = List(('a', 1))
    val expected = Set(
      List(),
      List(('a', 1))
    )
    combinations(input).toSet shouldBe expected
  }

  test("combinations: ab") {
    val input = List(('a', 1), ('b', 1))
    val expected = Set(
      List(),
      List(('a', 1)),
      List(('b', 1)),
      List(('a', 1), ('b', 1))
    )
    combinations(input).toSet shouldBe expected
  }

  test("combinations: abba (8pts)") {
    val abba = List(('a', 2), ('b', 2))
    val expected = Set(
      List(),
      List(('a', 1)),
      List(('a', 2)),
      List(('b', 1)),
      List(('a', 1), ('b', 1)),
      List(('a', 2), ('b', 1)),
      List(('b', 2)),
      List(('a', 1), ('b', 2)),
      List(('a', 2), ('b', 2))
    )
    combinations(abba).toSet shouldBe expected
  }

  test("subtract: lard - x") {
    val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
    val x = List(('x', 1))
    subtract(lard, x) shouldBe lard
  }

  test("subtract: lard - r (10pts)") {
    val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
    val r = List(('r', 1))
    val lad = List(('a', 1), ('d', 1), ('l', 1))
    subtract(lard, r) shouldBe lad
  }

  test("subtract: darla - a") {
    val darla = List(('a', 2), ('d', 1), ('l', 1), ('r', 1))
    val a = List(('a', 1))
    val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
    subtract(darla, a) shouldBe lard
  }

  test("subtract: jimmy - my") {
    val jimmy = List(('i', 1), ('j', 1), ('m', 2), ('y', 1))
    val my = List(('m', 1), ('y', 1))
    val jim = List(('i', 1), ('j', 1), ('m', 1))
    subtract(jimmy, my) shouldBe jim
  }

  test("sentence anagrams: [] (10pts)") {
    val sentence = List()
    sentenceAnagrams(sentence) shouldBe List(Nil)
  }

  test("sentence anagrams: Linux rulez (10pts)") {
    val sentence = List("Linux", "rulez")
    val expected = Set(
      List("Rex", "Lin", "Zulu"),
      List("nil", "Zulu", "Rex"),
      List("Rex", "nil", "Zulu"),
      List("Zulu", "Rex", "Lin"),
      List("null", "Uzi", "Rex"),
      List("Rex", "Zulu", "Lin"),
      List("Uzi", "null", "Rex"),
      List("Rex", "null", "Uzi"),
      List("null", "Rex", "Uzi"),
      List("Lin", "Rex", "Zulu"),
      List("nil", "Rex", "Zulu"),
      List("Rex", "Uzi", "null"),
      List("Rex", "Zulu", "nil"),
      List("Zulu", "Rex", "nil"),
      List("Zulu", "Lin", "Rex"),
      List("Lin", "Zulu", "Rex"),
      List("Uzi", "Rex", "null"),
      List("Zulu", "nil", "Rex"),
      List("rulez", "Linux"),
      List("Linux", "rulez")
    )
    sentenceAnagrams(sentence).toSet shouldBe expected
  }

  test("sentence anagrams: Yes man") {
    val sentence = List("Yes", "man")
    val expected = Set(
      List("en", "as", "my"),
      List("en", "my", "as"),
      List("man", "yes"),
      List("men", "say"),
      List("as", "en", "my"),
      List("as", "my", "en"),
      List("sane", "my"),
      List("Sean", "my"),
      List("my", "en", "as"),
      List("my", "as", "en"),
      List("my", "sane"),
      List("my", "Sean"),
      List("say", "men"),
      List("yes", "man")
    )

    sentenceAnagrams(sentence).toSet shouldBe expected
  }
