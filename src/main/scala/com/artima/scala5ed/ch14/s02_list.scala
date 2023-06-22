/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - The List type

  Lists are homogeneous and covariant, for instance List[String] is a subtype of List[Object]

  Nothing is the "bottom type" of class hierarchy so List[Nothing] is a subtype of any List[T]
 */
package com.artima.scala5ed.ch14

@main
def s02_list(): Unit =
  // explicit type declaration
  val fruits: List[String] = List("apples", "oranges", "pears")
  println(s"Fruits: $fruits")

  val numbers: List[Int] = List(1, 2, 3, 4)
  println(s"Numbers: $numbers")

  val diagonal3: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
  println(s"A diagonal matrix 3x3: $diagonal3")

  val empty: List[Nothing] = List()
  println(s"An empty list: $empty")

  // covariance between List[String] and List[Nothing]
  val xs: List[String] = List()
  println(s"Another empty list: $xs")
