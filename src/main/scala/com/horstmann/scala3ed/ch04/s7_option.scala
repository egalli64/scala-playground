/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  4. Map, Option, Tuple
   7. The Option Type
 */
package com.horstmann.scala3ed.ch04

@main
def s7_option(): Unit =
  val aFriend: Option[String] = Some("Fred")
  println("A non-empty option: " + aFriend)

  val noFriend: Option[String] = None
  println("An empty option: " + noFriend)

  val scores = Map("Alice" -> 10, "Bob" -> 7, "Cindy" -> 8)
  println("A score map: " + scores)

  val aliceScore = scores.get("Alice")
  println("Alice score: " + aliceScore)
  println("Same (get or else): " + aliceScore.getOrElse("No score"))

  val danScore = scores.get("Dan")
  println("Dan score: " + danScore)
  println("Same (get or else): " + danScore.getOrElse("No score"))

  println("An Option could be used just like a collection")
  for score <- aliceScore do println("The score is (looping): " + score)
  println("Mapped score: " + aliceScore.map(_ + 1))
  val acceptableScore = aliceScore.filter(_ > 5)
  println("Filtered score: " + aliceScore.filter(_ > 5))
  println("Executing foreach-println on an Option")
  aliceScore.foreach(println)
