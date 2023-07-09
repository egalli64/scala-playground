/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - Higher-order methods on class List
  A higher-order method takes one or more functions as arguments

  Predicates over lists: forall and exists
 */
package com.artima.scala5ed.ch14

@main
def s07c(): Unit =
  val numbers = List(2, 4, 6, 8)
  // 1. forall, check if all elements satisfy a predicate
  val allEven = numbers.forall(_ % 2 == 0)
  println(s"Are all $numbers even? $allEven")

  // 2. exists, check if at least an element satisfies a predicate
  val hasSixMultiple = numbers.exists(_ % 6 == 0)
  println(s"Is there a 6 multiple in $numbers? $hasSixMultiple")
