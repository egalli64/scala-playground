/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Basic Types and Operations - Object equality
 */
package com.artima.scala5ed.ch05

@main
def s8equality(): Unit =
  // Comparison for (dis)equality for Int
  println(s"1 == 2? ${1 == 2}")
  println(s"1 != 2? ${1 != 2}")
  println(s"2 == 2? ${2 == 2}")

  // Comparison for (dis)equality for List
  val listA = List(1, 2, 3)
  val listB = List(1, 2, 3)
  val listC = List(1, 2, 4)
  println(s"listA == listB? ${listA == listB}")
  println(s"listA == listC? ${listA == listC}")

  // Different types
  println(s"1 == 1.0 (yes!)? ${1 == 1.0}")

  // won't compile: cannot be compared
  // println(s"listA == \"hello\"? ${listA == "hello"}")

  // Against null
  println(s"listA == null? ${listA == null}")
  println(s"null == listB? ${null == listB}")

  // Different object are equal if the content is same
  println(s"hello == hell + o? ${"hello" == ("hell" + "o")}")

  // Spoiler on reference equality
  println(s"listA eq listB? ${listA eq listB}")
  println(s"listA ne listB? ${listA ne listB}")
  println(s"listA eq listA? ${listA eq listA}")
