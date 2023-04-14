/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 4 - Types and Pattern Matching - Practice Programming Assignment: Huffman Coding
 */
package org.coursera.efpl.course1.week4.assignment

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class HuffmanSuite extends AnyFunSuite with Matchers:
  import Huffman.*

  trait TestTrees {
    val t1: Fork = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
    val t2: Fork = Fork(
      Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5),
      Leaf('d', 4),
      List('a', 'b', 'd'),
      9
    )
    val l1: Leaf = Leaf('x', 7)
  }

  test("weight of a larger tree (10pts)") {
    new TestTrees:
      weight(t1) shouldBe 5
  }

  test("weight /2") {
    new TestTrees:
      weight(t2) shouldBe 9
  }

  test("weight leaf") {
    new TestTrees:
      weight(l1) shouldBe 7
  }

  test("chars of a larger tree (10pts)") {
    new TestTrees:
      chars(t2) shouldBe string2Chars("abd")
  }

  test("chars leaf") {
    new TestTrees:
      chars(l1) shouldBe string2Chars("x")
  }

  test("make CodeTree minimal") {
    new TestTrees:
      weight(makeCodeTree(l1, l1)) shouldBe 14
  }

  test("make CodeTree") {
    new TestTrees:
      weight(makeCodeTree(t1, t2)) shouldBe 14
  }

  test("string2chars hello world") {
    val expected = List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd')
    string2Chars("hello, world") shouldBe expected
  }

  test("times for cecco") {
    val result = times(string2Chars("cecco"))
    result.size shouldBe 3
    result.head._1 shouldBe 'c'
    result.head._2 shouldBe 3
  }

  test("make ordered leaf list for some frequency table (15pts)") {
    val actual = makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3)))
    val expected = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3))
    actual shouldBe expected
  }

  test("singleton positive") {
    assert(singleton(List(Leaf('a', 1))))
  }

  test("singleton multiple") {
    assert(!singleton(List(Leaf('a', 1), Leaf('b', 1))))
  }

  test("singleton empty") {
    assert(!singleton(Nil))
  }

  test("combine empty") {
    combine(Nil) shouldBe Nil
  }

  test("combine singleton") {
    val l = List(Leaf('a', 1))
    combine(l) shouldBe List(Leaf('a', 1))
  }

  test("combine of some leaf list (15pts)") {
    val input = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    val expected = List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4))
    combine(input) shouldBe expected
  }

  test("until") {
    val input = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    val actual = until(singleton, combine)(input)
    actual.size shouldBe 1
    weight(actual.head) shouldBe 7
  }

  test("create code tree") {
    val actual = createCodeTree(List('c', 'e', 'c', 'c', 'o'))
    weight(actual) shouldBe 5

    val lcs = chars(actual)
    lcs.size shouldBe 3
    lcs.head shouldBe 'e'
    lcs.tail.head shouldBe 'o'
  }

  test("decode") {
    new TestTrees:
      decode(t1, List(0, 1, 1, 0)) shouldBe "abba".toList
  }

  test("encode") {
    new TestTrees:
      encode(t1)("ab".toList) shouldBe List(0, 1)
  }

  test("decode and encode a very short text should be identity (10pts)") {
    new TestTrees:
      decode(t1, encode(t1)("ab".toList)) shouldBe "ab".toList
  }

  test("codebits") {
    val table = List(('a', List(0)), ('b', List(1)))
    codeBits(table)('a') shouldBe List(0)
    codeBits(table)('b') shouldBe List(1)
  }

  test("convert t1") {
    new TestTrees:
      private val result = convert(t1)
      result.size shouldBe 2
      result.head._1 shouldBe 'a'
      result.head._2.head shouldBe 0
      result.tail.head._1 shouldBe 'b'
      result.tail.head._2.head shouldBe 1
  }

  test("convert t2") {
    new TestTrees:
      private val result = convert(t2)
      result.size shouldBe 3

      // a -> 0, 0
      result.head._1 shouldBe 'a'
      result.head._2.head shouldBe 0
      result.head._2.tail.head shouldBe 0

      // b -> 0, 1
      result.tail.head._1 shouldBe 'b'
      result.tail.head._2.head shouldBe 0
      result.tail.head._2.tail.head shouldBe 1
  }

  test("merge code tables") {
    val p1 = ('a', List(0))
    val p2 = ('b', List(1))
    mergeCodeTables(List(p1), List(p2)) shouldBe List(p1, p2)
  }

  test("quick encode") {
    new TestTrees:
      private val l = quickEncode(t1)(string2Chars("abba"))
      l.size shouldBe 4
      l.head shouldBe 0
      l.tail.head shouldBe 1
  }
end HuffmanSuite
