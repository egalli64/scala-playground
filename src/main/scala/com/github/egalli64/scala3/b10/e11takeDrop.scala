/*
  https://docs.scala-lang.org/scala3/book/collections-methods.html
  https://github.com/egalli64/scala-playground

  Collections Methods - take() and drop() families (right / while)
 */
package com.github.egalli64.scala3.b10

@main
def e11takeDrop(): Unit =
  val oneToTen = (1 to 10).toList
  println("An int list: " + oneToTen)

  val names = List("adam", "brandy", "chris", "david", "bob")
  println("A string list: " + names)

  println("Take 1 (implicitly left): " + oneToTen.take(1))
  println("Take 2: " + oneToTen.take(2))
  println("Take all (MaxValue - i.e. Java MAX_VALUE): " + oneToTen.take(Int.MaxValue))
  println("Take nothing: " + oneToTen.take(0))
  println("Take right 1: " + oneToTen.takeRight(1))
  println("Take right 2: " + oneToTen.takeRight(2))
  println("Take right all: " + oneToTen.takeRight(Int.MaxValue))
  println("Take right nothing: " + oneToTen.takeRight(0))

  println("Take while len < 5: " + names.takeWhile(_.length < 5))
  println("Take while not chris: " + names.takeWhile(_ != "chris"))

  println("Drop 1 (implicitly left): " + oneToTen.drop(1))
  println("Drop 2: " + oneToTen.drop(2))
  println("Drop all: " + oneToTen.drop(Int.MaxValue))
  println("Drop nothing: " + oneToTen.drop(0))
  println("Drop right 1: " + oneToTen.dropRight(1))
  println("Drop right 2: " + oneToTen.dropRight(2))
  println("Drop right all: " + oneToTen.dropRight(Int.MaxValue))
  println("Drop right nothing: " + oneToTen.dropRight(0))

  println("Drop while len < 5: " + names.dropWhile(_.length < 5))
  println("Drop while not chris: " + names.dropWhile(_ != "chris"))
