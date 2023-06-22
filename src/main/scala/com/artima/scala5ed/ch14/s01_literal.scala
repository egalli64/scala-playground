/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - List literals

  List: array-like but immutable and with a recursive structure
 */
package com.artima.scala5ed.ch14

@main
def s01_literal(): Unit =
  val fruits = List("apples", "oranges", "pears")
  println(s"Fruits: $fruits")

  val numbers = List(1, 2, 3, 4)
  println(s"Numbers: $numbers")

  val diagonal3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
  println(s"A diagonal matrix 3x3: $diagonal3")

  val empty = List()
  println(s"An empty list: $empty")
