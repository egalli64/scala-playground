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
  println("A pair (arrow syntax): " + tom)

  val kim = ("Kim", 12)
  println("Another pair (parentheses): " + kim + "\n")

  // an immutable Map[String, Int]
  val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8, tom, kim)
  println("A map: " + scores)
  // Can't mutate an immutable map
  // scores += "Tom" -> 23

  // an empty mutable map
  val scores2 = scala.collection.mutable.Map[String, Int]()
  println("A mutable map: " + scores2)
  scores2 += "Tom" -> 23
  println("Mutated map: " + scores2)
