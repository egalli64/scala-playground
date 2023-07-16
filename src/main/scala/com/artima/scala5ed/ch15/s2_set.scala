/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Other Collections - Sets and maps
  set - Predef immutable
 */
package com.artima.scala5ed.ch15

// make mutable set accessible
import scala.collection.mutable

@main
def s2_set(): Unit =
  // 1. immutable set
  val numbers = Set(1, 2, 3)
  println(s"An immutable int set: " + numbers)
  val plus5 = numbers + 5
  println(s"The original set: $numbers, another set by appending: $plus5")
  val minus3 = numbers - 3
  println(s"Another set by removing: $minus3")
  val plus5_6 = numbers ++ List(5, 6)
  println(s"Another set by list-append: $plus5_6")
  val minus1_2 = numbers -- List(1, 2)
  println(s"Another set by list-remove: $minus1_2")
  val intersect = numbers & Set(1, 3, 5, 7)
  println(s"Another set by intersection: $intersect")

  println("The original set size: " + numbers.size)
  println("Contains 3? " + numbers.contains(3))

  // 2. mutable set
  val text = "See Spot run. Run, Spot. Run!"
  println("A string: " + text)
  val wordsArray = text.split("[ !,.]+")
  println(s"An array of strings sized ${wordsArray.size}: " + wordsArray.mkString(" "))

  val words = mutable.Set.empty[String]
  println(s"An empty mutable set ${System.identityHashCode(words)}: " + words)

  for word <- wordsArray do words += word.toLowerCase
  println(s"The mutable ${System.identityHashCode(words)} set populated: " + words)

  words -= "spot"
  println("Remove an item: " + words)

  words ++= List("do", "re", "mi")
  println("List-append: " + words)

  words --= List("do", "re")
  println("List-remove: " + words)

  words.clear
  println("Cleared: " + words)