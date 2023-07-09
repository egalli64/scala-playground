/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - Higher-order methods on class List
  A higher-order method takes one or more functions as arguments

  Filtering lists: filter, partition, find, takeWhile, dropWhile, and span
 */
package com.artima.scala5ed.ch14

@main
def s07b(): Unit =
  val numbers = List(1, 2, 3, 4, 5)
  val words = List("the", "quick", "brown", "fox")

  // 1. filter, keep in result list the elements for which the predicate is true
  val evenNumbers = numbers.filter(_ % 2 == 0)
  println(s"From $numbers to $evenNumbers")

  val lenThreeWords = words.filter(_.length == 3)
  println(s"From $words to $lenThreeWords")

  // 2. partition, generate two lists, predicate true or false
  val evenOddNumbers = numbers.partition(_ % 2 == 0)
  println(s"From $numbers to $evenOddNumbers")

  // 3. find, like filter, but returns just the first element in an Option (Some or None)
  val firstEven = numbers.find(_ % 2 == 0)
  println(s"From $numbers to $firstEven")

  val firstNegative = numbers.find(_ < 0)
  println(s"From $numbers to $firstNegative")

  // 4. takeWhile, keep taking until predicate is true
  val upToFour = numbers.takeWhile(_ < 4)
  println(s"From $numbers to $upToFour")

  // 5. dropWhile, keep discarding until predicate is true
  val fromFourPlus = numbers.dropWhile(_ < 4)
  println(s"From $numbers to $fromFourPlus")

  // 6. span, generate two lists, taking/dropping until predicate is true
  val spanOnFour = numbers.span(_ < 4)
  println(s"From $numbers to $spanOnFour")
