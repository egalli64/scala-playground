/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  4. Map, Option, Tuple
   1. Constructing a Map
 */
package com.horstmann.scala3ed.ch04

@main
def s1_map_build(): Unit =
  // maps contain pairs
  val tom = "Tom" -> 42
  println("A pair: " + tom)

  val kim = ("Kim", 12)
  println("Another pair: " + kim)

  // an immutable Map[String, Int]
  val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8, tom, kim)
  println("A map: " + scores)

  // an empty mutable map
  val scores2 = scala.collection.mutable.Map[String, Int]()
  println("Another map: " + scores2)
