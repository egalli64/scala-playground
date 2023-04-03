/*
  https://docs.scala-lang.org/scala3/book/collections-classes.html
  https://github.com/egalli64/scala-playground

  Collections Types - Set: an iterable collection with no order nor duplicates

  Immutable set - but also a mutable one is available
 */
package com.github.egalli64.scala3.b10

@main
def e05Set(): Unit =
  // New empty set
  val noNumbers = Set[Int]()
  println("No numbers: " + noNumbers)

  val noLetters = Set[Char]()
  println("No letters: " + noLetters)

  // New set with values - duplicates are discarded
  val numbers = Set(1, 2, 3, 3, 3)
  println("Numbers: " + numbers)

  val letters = Set('a', 'b', 'c', 'c')
  println("Letters: " + letters)

  // + factory method to add a new element
  val numbers4 = numbers + 4
  println("Numbers with 4: " + numbers4)

  // ++ factory method to add a sequence - the result in a new HashSet
  val moreNumbers = numbers ++ Seq(9, 8, 7)
  println("More numbers: " + moreNumbers)
