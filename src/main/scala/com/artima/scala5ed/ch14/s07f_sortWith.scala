/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - Higher-order methods on class List
  A higher-order method takes one or more functions as arguments

  Sorting lists: sortWith
 */
package com.artima.scala5ed.ch14

@main
def s07f_sortWith(): Unit =
  val numbers = List(2, -4, 6, -8)
  println(numbers)

  println("Natural order: " + numbers.sortWith(_ < _))
  println("Descending order: " + numbers.sortWith(_ > _))
