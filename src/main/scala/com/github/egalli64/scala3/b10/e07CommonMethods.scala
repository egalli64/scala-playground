/*
  https://docs.scala-lang.org/scala3/book/collections-methods.html
  https://github.com/egalli64/scala-playground

  Collections Methods - Examples of common methods

  Available on all sequences
 */
package com.github.egalli64.scala3.b10

@main
def commonMethods(): Unit =
  val values = List(10, 20, 30, 40, 10)
  println("The values: " + values)

  println("Distinct values: " + values.distinct)

  println("Drop 2 element (max) from values: " + values.drop(2))
  println("Drop right 2 element (max) from values: " + values.dropRight(2))

  println("Head of values: " + values.head)
  try
    println(Nil.head)
  catch case ex: NoSuchElementException => println("No head in Nil: " + ex)

  println("Head of values (Option): " + values.headOption)
  println("Head of Nil (Option): " + Nil.headOption)

  println("Init values (values without the last element): " + values.init)

  val others = List(19, 20, 21)
  println("Another list: " + others)
  println("Intersect values and others: " + values.intersect(others))
  println("Last of values: " + values.last)
  try
    println(Nil.last)
  catch case ex: NoSuchElementException => println("No last in Nil: " + ex)

  println("Last of values (Option): " + values.lastOption)
  println("Last of Nil (Option): " + Nil.lastOption)

  println("A slice from 2 until 4 of values: " + values.slice(2, 4))
  println("The tail of values: " + values.tail)
  println("Take 3 elements (max) from values: " + values.take(3))
  println("Take right 2 elements (max) from values: " + values.takeRight(2))
