/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Collections in Depth - The sequence traits Seq, IndexedSeq, and LinearSeq

  A sequence is an iterable with a length and whose elements have fixed index positions, starting from 0
  A linear sequence has efficient head and tail operations
    ex: List and LazyList
  An indexed sequence has efficient apply, length, and (if mutable) update operations
    ex: Array and ArrayBuffer
 */
package com.artima.scala5ed.ch24

@main
def s04_seq(): Unit =
  val xs = List(1, 2, 3)
  println(s"For a seq, apply means indexing: ${xs(1)}, ${xs.apply(2)}")
