/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - First-order methods on class List
  A first-order method does not take any function as argument

  toString, mkString, addString
 */
package com.artima.scala5ed.ch14

@main
def s06d(): Unit =
  val letters = List('a', 'b', 'c', 'd', 'e')

  // 1. toString
  // implicit call to toString
  println(letters)
  // explicit call to toString
  println(letters.toString)

  // 2. mkString
  println(letters.mkString("[", ",", "]"))
  println(letters.mkString(","))
  println(letters.mkString)

  // 3. addString
  val buffer = new StringBuilder
  buffer.append("The letters elements -> ")
  letters.addString(buffer).append(" <- ")
  buffer.append("With some formatting -> ")
  letters.addString(buffer, "[", ",", "]").append(" <- ")
  println(buffer)