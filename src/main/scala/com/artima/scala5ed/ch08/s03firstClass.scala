/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functions and Closures - First-class functions
  A function could be written as unnamed literal and then passed around as value
  Function literal: in the source code, compiled to a Java method handle
  Function value: runtime object - see class-object relation
 */
package com.artima.scala5ed.ch08

@main
def s03firstClass(): Unit =
  // RHS: function literal - LHS: the handle to the Java method
  val increase = (x: Int) => x + 1
  // RHS: invoking the function value
  val result = increase(10)
  println(result)

  // A function literal definition could take more lines
  val addTwo = (x: Int) =>
    val increment = 2
    x + increment
  println(addTwo(10))

  val someNumbers = List(-11, 5, 0, 10)
  println(someNumbers)
  // passing function literals to methods
  println("Print each value")
  someNumbers.foreach((x: Int) => println(x))
  println("Filter positive elements")
  println(someNumbers.filter((x: Int) => x > 0))