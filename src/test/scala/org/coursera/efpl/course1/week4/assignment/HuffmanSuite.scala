/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 4 - Types and Pattern Matching - Practice Programming Assignment: Huffman Coding
 */
package org.coursera.efpl.course1.week4.assignment

class HuffmanSuite extends munit.FunSuite:
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
      assertEquals(weight(t1), 5)
  }

  test("weight /2") {
    new TestTrees:
      assertEquals(weight(t2), 9)
  }

  test("weight leaf") {
    new TestTrees:
      assertEquals(weight(l1), 7)
  }

  test("chars of a larger tree (10pts)") {
    new TestTrees:
      assertEquals(chars(t2), string2Chars("abd"))
  }

  test("chars leaf") {
    new TestTrees:
      assertEquals(chars(l1), string2Chars("x"))
  }

  test("make CodeTree minimal") {
    new TestTrees:
      assertEquals(weight(makeCodeTree(l1, l1)), 14)
  }

  test("make CodeTree") {
    new TestTrees:
      assertEquals(weight(makeCodeTree(t1, t2)), 14)
  }

  test("string2chars hello world") {
    assertEquals(
      string2Chars("hello, world"),
      List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd')
    )
  }

  test("times for cecco") {
    val result = times(string2Chars("cecco"))
    assertEquals(result.size, 3)
    assertEquals(result.head._1, 'c')
    assertEquals(result.head._2, 3)
  }

  test("make ordered leaf list for some frequency table (15pts)") {
    val actual = makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3)))
    val expected = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3))
    assertEquals(actual, expected)
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
    assertEquals(combine(Nil), Nil)
  }

  test("combine singleton") {
    val l = List(Leaf('a', 1))
    assertEquals(combine(l), l)
  }

  test("combine of some leaf list (15pts)") {
    val input = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    val expected = List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4))
    assertEquals(combine(input), expected)
  }

  test("until") {
    val input = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    val actual = until(singleton, combine)(input)
    assertEquals(actual.size, 1)
    assertEquals(weight(actual.head), 7)
  }

  test("create code tree") {
    val actual = createCodeTree(List('c', 'e', 'c', 'c', 'o'))
    assertEquals(weight(actual), 5)

    val lcs = chars(actual)
    assertEquals(lcs.size, 3)
    assertEquals(lcs.head, 'e')
    assertEquals(lcs.tail.head, 'o')
  }

  test("decode") {
    new TestTrees:
      assertEquals(decode(t1, List(0, 1, 1, 0)), "abba".toList)
  }

  test("encode") {
    new TestTrees:
      assertEquals(encode(t1)("ab".toList), List(0, 1))
  }

  test("decode and encode a very short text should be identity (10pts)") {
    new TestTrees:
      assertEquals(decode(t1, encode(t1)("ab".toList)), "ab".toList)
  }

  test("codebits") {
    val table = List(('a', List(0)), ('b', List(1)))
    assertEquals(codeBits(table)('a'), List(0))
    assertEquals(codeBits(table)('b'), List(1))
  }

  test("convert t1") {
    new TestTrees:
      private val result = convert(t1)
      assertEquals(result.size, 2)
      assertEquals(result.head._1, 'a')
      assertEquals(result.head._2.head, 0)
      assertEquals(result.tail.head._1, 'b')
      assertEquals(result.tail.head._2.head, 1)
  }

  test("convert t2") {
    new TestTrees:
      private val result = convert(t2)
      assertEquals(result.size, 3)

      // a -> 0, 0
      assertEquals(result.head._1, 'a')
      assertEquals(result.head._2.head, 0)
      assertEquals(result.head._2.tail.head, 0)

      // b -> 0, 1
      assertEquals(result.tail.head._1, 'b')
      assertEquals(result.tail.head._2.head, 0)
      assertEquals(result.tail.head._2.tail.head, 1)
  }

  test("merge code tables") {
    val p1 = ('a', List(0))
    val p2 = ('b', List(1))
    assertEquals(mergeCodeTables(List(p1), List(p2)), List(p1, p2))
  }

  test("quick encode") {
    new TestTrees:
      private val l = quickEncode(t1)(string2Chars("abba"))
      assertEquals(l.size, 4)
      assertEquals(l.head, 0)
      assertEquals(l.tail.head, 1)
  }

  import scala.concurrent.duration.*
  override val munitTimeout: FiniteDuration = 10.seconds
end HuffmanSuite
