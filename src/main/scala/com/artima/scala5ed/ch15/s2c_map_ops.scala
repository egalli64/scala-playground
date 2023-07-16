/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Other Collections - Sets and maps
  map - common operations
 */
package com.artima.scala5ed.ch15

import scala.collection.mutable

@main
def s2c_map_ops(): Unit =
  // 1. immutable map
  val numbers = Map("i" -> 1, "ii" -> 2)
  println("Create immutable map: " + numbers)

  val m2 = numbers + ("vi" -> 6)
  println("Add an entry: " + m2)

  val m3 = numbers - "ii"
  println("Remove an entry: " + m3)

  val m4 = numbers ++ List("iii" -> 3, "v" -> 5)
  println("List-add: " + m4)

  val m5 = numbers -- List("i", "ii")
  println("List-remove: " + m5)

  println("Original map size: " + numbers.size)
  println("Contains 'ii'? " + numbers.contains("ii"))
  println("The value associated to 'ii' key: " + numbers("ii"))
  println("The keys (iterable): " + numbers.keys)
  println("The key set (a new set): " + numbers.keySet)
  println("The values (iterable): " + numbers.values)
  println("Is empty? " + numbers.isEmpty)
  println("---")

  // 2. mutable map
  val words = mutable.Map.empty[String, Int]
  println("An empty, mutable map " + words)

  words += ("one" -> 1)
  println("Add: " + words)

  words -= "one"
  println("Remove: " + words)

  words ++= List("one" -> 1, "two" -> 2, "three" -> 3)
  println("List-add: " + words)

  words --= List("one", "two")
  println("List-remove: " + words)
