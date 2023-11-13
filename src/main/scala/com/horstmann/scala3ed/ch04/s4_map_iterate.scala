/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  4. Map, Option, Tuple
   4. Iterating over Maps
 */
package com.horstmann.scala3ed.ch04

@main
def s4_map_iterate(): Unit =
  val scores = Map("Alice" -> 10, "Bob" -> 7, "Fred" -> 8, "Cindy" -> 7)
  println("a map: " + scores)
  println("map's keys: " + scores.keySet)

  print("map's key/values: ")
  for (k, v) <- scores do print(s"[$k, $v] ")
  println()

  print("map's values: ")
  for v <- scores.values do print(v + " ")
  println()

  val inverted = for (k, v) <- scores yield (v, k)
  println("inversion: " + inverted)
