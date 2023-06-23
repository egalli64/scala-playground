/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - First-order methods on class List
  A first-order method does not take any function as argument

  reverse, drop, take, splitAt, apply, flatten
 */
package com.artima.scala5ed.ch14

@main
def s06b(): Unit =
  val letters = List('a', 'b', 'c', 'd', 'e')
  println("Letters are: " + letters)
  println("Reversed letters are: " + letters.reverse)

  println("Drop first 2 letters: " + letters.drop(2))
  println("Take first 2 letters: " + letters.take(2))
  println("Split letters at 2: " + letters.splitAt(2))

  // Applying on array is O(1) on a list is O(n)!
  println("Apply 2 on letters: " + letters.apply(2))
  println("Apply 2 on letters (shorter form): " + letters(2))

  println("Flattening: " + List(List(1, 2), List(3), List(), List(4, 5)).flatten)

  val fruits = List("apples", "oranges", "pears")
  println("Fruits: " + fruits)

  val charFruits = fruits.map(_.toList)
  println("Fruits mapped to Char List: " + charFruits)
  println("Flatten Char Fruits: " + charFruits.flatten)

  println("Flatten fruits (implicitly mapped to Char Lists): " + fruits.flatten)

  // Won't compile - each element should be a list!
  // val x = List(1,2,3).flatten
