/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Collections in Depth - Sets
  A set is an iterable with no duplicate element
 */
package com.artima.scala5ed.ch24

@main
def s05_sets(): Unit =
  val fruit = Set("apple", "orange", "peach", "banana")

  println("A set: " + fruit)
  println(s"Test if an element is in the set via contains: ${fruit.contains("apple")}")
  println(s"Apply on a set is a synonym of contains: ${fruit.apply("apple")} ${fruit("apple")}")

  var s = Set(1, 2, 3)
  println("A variable immutable set: " + s)
  s += 4
  s -= 2
  println("After adding 4 and subtracting 2 (different object!): " + s)

  val ms = collection.mutable.Set(1, 2, 3)
  println("A value mutable set: " + ms)
  ms += 4
  ms -= 2
  println("After adding 4 and subtracting 2 (same object!): " + ms)
