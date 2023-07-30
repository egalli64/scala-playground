/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Scala’s Hierarchy - Scala’s class hierarchy
 */
package com.artima.scala5ed.ch17

@main
def s1_hierarchy(): Unit =
  // Any: top class in Scala
  val a: Any = 1
  println("an 'Any': " + a)

  val b: AnyVal = 2
  println("an 'AnyVal': " + b)

  // won't compile: Int is abstract; it cannot be instantiated
  // instances of AnyVal could be only literals
  // val c = new Int

  println("A hash code: " + 1234567890123L.hashCode())

  println("RichInt adds methods to Int by implicit conversion ...")
  println("Max between 42 and 43: " + 42.max(43))
  println("Min between 42 and 43: " + 42.min(43))
  println(1 until 5)
  println(1 to 5)
  println("Absolute value: " + -3.abs)

  val c: AnyRef = "hello"
  println("an 'AnyRef': " + c)
