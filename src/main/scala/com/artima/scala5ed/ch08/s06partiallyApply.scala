/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functions and Closures - Partially applied functions
 */
package com.artima.scala5ed.ch08

@main
def s06partiallyApply(): Unit =
  // given a function ...
  def sum(a: Int, b: Int, c: Int) = a + b + c
  // _applying_ it _to_ the arguments means means invoking it with the given arguments
  val result = sum(1, 2, 3)
  println("Applying sum() to 1, 2, 3 leads to " + result)

  // Partially applied sum (no argument provided)
  val a = sum // sum _ // sum(_, _, _)
  println(a(1, 2, 3))
  // Same, using the explicit form
  println(a.apply(1, 2, 3))

  // Same, as eta expansion
  val a2 = sum
  println(a2(1, 2, 3))

  // More interestingly, to apply _b_ only one argument is required (for the second parameter)
  val b = sum(1, _, 3)
  println(s"Applying b() to 2: ${b(2)}, and to 5: ${b(5)}")
