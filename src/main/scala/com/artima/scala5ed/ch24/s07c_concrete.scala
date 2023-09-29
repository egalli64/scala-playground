/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Collections in Depth - Concrete immutable collection classes
  VectorMap, ListMap
 */
package com.artima.scala5ed.ch24

import scala.collection.immutable.VectorMap

@main
def s07c_concrete(): Unit =
  /*
    VectorMap
   */
  println("VectorMap, the entries keep the insertion order")

  val vm = VectorMap.empty[Int, String]
  println("An empty vector map: " + vm)

  val vm1 = vm + (1 -> "one")
  println("An single entry vector map: " + vm1)

  val vm2 = vm1 + (2 -> "two")
  println("A two entries vector map: " + vm2)
  println("Comparing a vector map with a 'normal' map: " + (vm2 == Map(2 -> "two", 1 -> "one")))

  /*
    ListMap
   */
  val map = collection.immutable.ListMap(1 -> "one", 2 -> "two")
  println("A map accessed as list: " + map)
  println("An element in the list map: " + map(2))
