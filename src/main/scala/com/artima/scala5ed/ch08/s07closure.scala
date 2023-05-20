/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functions and Closures - Closures
 */
package com.artima.scala5ed.ch08

@main
def s07closure(): Unit =
  var more = 1

  // a _closed term_ is a function literal not referring to variable external to its scope
  val increasing = (x: Int) => x + 1
  println("A closed term: " + increasing(41))

  // a function value created at runtime from a function literal is a _closure_
  // if it is an _open term_, having _free variables_ whose binding has to be _captured_
  // a _closure_ closes an _open term_ on its _free variables_
  val addMore = (x: Int) =>
    // "x" is a _bound variable_ has a meaning in the function context
    // "more" is a _free variable_, the meaning is coming from outside the function
    x + more

  // calling a closure
  println("A closure: " + addMore(10))

  // in Scala, a closure sees the changes of the captured free variables
  more = 5
  println("A closure after changing the captured free variable: " + addMore(10))

  // Changes in a closure changes on a captured variable are visible from outside
  val someNumbers = List(-11, -10, -5, 0, 5, 10)
  var sum = 0
  someNumbers.foreach(sum += _)
  println("A closure that changes its free variable: " + sum)

  // the free variable is captured whe the closure is created
  def makeIncrease(more: Int) = (x: Int) => x + more

  val inc1 = makeIncrease(1)
  val inc9999 = makeIncrease(9999)

  println("Captured is 1: " + inc1(10))
  println("Captured is 9999: " + inc9999(10))
