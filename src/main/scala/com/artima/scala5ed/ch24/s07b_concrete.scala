/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Collections in Depth - Concrete immutable collection classes
  Queue, range, red-black tree, bit set
 */
package com.artima.scala5ed.ch24

@main
def s07b_concrete(): Unit =
  /*
    Queue
   */
  val empty = scala.collection.immutable.Queue[Int]()
  println("\nAn empty queue: " + empty)

  val has1 = empty.enqueue(1)
  println("A single-element queue: " + has1)

  val has123 = has1.enqueueAll(List(2, 3))
  println("A queue: " + has123)

  // splat the tuple returned by dequeue
  val (element, has23) = has123.dequeue
  println(s"After dequeue: $element and $has23")

  /*
    Range
   */
  val closeRange123 = 1 to 3
  println("\nRange [1 .. 3]: " + closeRange123.mkString(" "))

  val closeRange = 5 to 14 by 3
  println("Range by 3 [5 .. 14]: " + closeRange.mkString(" "))

  val openRange123 = 1 until 3
  println("Range [1 .. 3): " + openRange123.mkString(" "))

  /*
    Red-black tree
   */
  val emptyTree = collection.immutable.TreeSet.empty[Int]
  println("\nAn empty tree: " + emptyTree)

  val aTree = emptyTree + 1 + 3 + 3
  println("A tree: " + aTree)

  /*
    Bit set
   */
  val bits = scala.collection.immutable.BitSet.empty
  println("\nAn empty bit set: " + bits)

  val moreBits = bits + 3 + 4 + 4
  println("A bit set: " + moreBits)
  println("Is 3 in the bit set? " + moreBits(3))
  println("Is 0 in the bit set? " + moreBits(0))
