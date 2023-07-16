/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Other Collections - Sorted sets and maps
 */
package com.artima.scala5ed.ch15

import scala.collection.immutable.TreeSet
import scala.collection.mutable

@main
def s2d_sorted(): Unit =
  val ts = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
  println(ts)

  val tm = mutable.TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')
  println(tm)
  tm += (2 -> 'x')
  println(tm)
