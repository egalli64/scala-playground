/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Collections in Depth - Concrete mutable collection classes
  Hash tables
  Bit set
 */
package com.artima.scala5ed.ch24

import java.util.concurrent.ConcurrentMap
import scala.collection.mutable

@main
def s08c_concreteMutable(): Unit =
  /*
    mutable.HashMap
   */
  val map = mutable.HashMap.empty[Int, String]
  println("A mutable empty hash map: " + map)

  map += (1 -> "make a web site")
  println("After adding an entry: " + map)

  map += (3 -> "profit!")
  println("After adding a second entry: " + map)

  println("Accessing value associated to key 1: " + map(1))
  println("The map contains key 2? " + map.contains(2))

  /*
    mutable.BitSet
   */
  val bits = mutable.BitSet.empty
  println("A mutable empty bit set: " + bits)

  bits += 1
  println("After adding 1: " + bits)
  bits += 3
  println("After adding 3: " + bits)
