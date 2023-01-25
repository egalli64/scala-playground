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
      assertEquals(chars(t2), List('a', 'b', 'd'))
  }

  test("chars leaf") {
    new TestTrees:
      assertEquals(chars(l1), List('x'))
  }

  test("make CodeTree") {
    new TestTrees:
      assertEquals(weight(makeCodeTree(t1, t2)), 14)
  }

  import scala.concurrent.duration.*
  override val munitTimeout: FiniteDuration = 10.seconds
