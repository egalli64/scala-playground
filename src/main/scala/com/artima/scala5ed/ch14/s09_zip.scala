/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - Processing multiple lists together
 */
package com.artima.scala5ed.ch14

@main
def s09_zip(): Unit =
  val tens = List(10, 20)
  val units = List(3, 4, 5)
  /*
    1. zip
    a. zip ten and units leads to ((10, 3), (20, 4)) - notice the discarding of 5
    b. mapping each pair to their product leads to (30, 80) - notice the "untupling"
   */
  val multi = tens.zip(units).map((x, y) => x * y)
  println(multi)

  // 2. lazy zip - get rid of intermediate lists
  val lazyMulti = tens.lazyZip(units).map(_ * _)
  println(lazyMulti)

  // --
  val words = List("abc", "de")
  val sizes = List(3, 2)

  // 2a. lazy zip + forall
  val allRight = words.lazyZip(sizes).forall(_.length == _)
  println("All right? " + allRight)

  // 2b. lazy zip + exists
  val someWrong = words.lazyZip(sizes).exists(_.length != _)
  println("Some wrong? " + someWrong)
