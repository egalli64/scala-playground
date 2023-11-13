/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  4. Map, Option, Tuple
   2. Accessing Map Values
 */
package com.horstmann.scala3ed.ch04

@main
def s2_map_get(): Unit =
  // an immutable Map[String, Int]
  val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
  println("A map: " + scores)

  // Access to value by apply is unsafe, an exception is thrown when key is missing
  println("Bob's score is " + scores("Bob"))
  // Protect it with a try-catch block
  try println("Tom's score is " + scores("Tom"))
  catch case ex: NoSuchElementException => println("Beware of exceptions, " + ex)

  // Or, check if key is available first
  println("Dan's score is " + (if scores.contains("Dan") then scores("Dan") else "missing"))

  // Or, use get, that returns an Option
  println("Mia's score is " + scores.get("Mia"))
  println("Alice's score is " + scores.get("Alice"))

  // Or, use getOrElse
  println("Kim's score is " + scores.getOrElse("Kim", "missing"))

  // Or, convert the immutable map to a map with default value for apply
  val scores2 = scores.withDefaultValue(0)
  println("Tom's score is " + scores2("Tom"))
