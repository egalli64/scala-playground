/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Other Collections - Selecting mutable versus immutable collections
 */
package com.artima.scala5ed.ch15

@main
def s3_immutable(): Unit =
  val people = Set("Nancy", "Jane")
  println("An immutable val set: " + people)

  // can't mutate an immutable collection!
  // people += "Bob"

  var people2 = Set("Nancy", "Jane")
  println("An immutable var set: " + people2)
  // the original set is lost in heap, the new set reference is assigned to the var
  people2 += "Bob"
  println("The new immutable set referenced by var: " + people2)
  people2 -= "Jane"
  println("No more Jane: " + people2)
  people2 ++= List("Tom", "Harry")
  println("Enter Tom and Harry: " + people2)
