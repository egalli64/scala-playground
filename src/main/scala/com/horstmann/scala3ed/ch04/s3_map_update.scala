/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  4. Map, Option, Tuple
   3. Updating Map Values
 */
package com.horstmann.scala3ed.ch04

import scala.collection.mutable

@main
def s3_map_update(): Unit =
  // mutating a mutable map
  val scores = mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
  println("A mutable map: " + scores)

  // Bob changes its value, Fred is added as new
  scores("Bob") = 10
  scores("Fred") = 7
  println("After updating Bob and adding Fred: " + scores)

  // Bob changes its value, Frida is added as new
  scores ++= Map("Bob" -> 7, "Frida" -> 5)
  println("After adding by ++= a map with Bob and Frida: " + scores)

  // remove a pair by key
  scores -= "Alice"
  println("After removing by -= Alice: " + scores)

  // an immutable map could be used to generate a new map
  val someScores = Map("Alice" -> 10, "Bob" -> 3)
  val moreScores = someScores + ("Cindy" -> 7)
  println(s"From $someScores (immutable) to $moreScores by +")

  // keeping the immutable maps in a single var, discarding the old ones
  var currentScores = moreScores
  println("Immutable scores in a var: " + currentScores)
  // verbosely adding a new pair
  currentScores = currentScores + ("Fred" -> 0)
  println("After adding by + Fred: " + currentScores)
  // handier
  currentScores += "Donald" -> 5
  println("After adding by += Donald: " + currentScores)

  // removing a pair
  currentScores = currentScores - "Fred"
  currentScores -= "Alice"
  println("After removing Fred and Alice: " + currentScores)
