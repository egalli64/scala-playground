/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functions and Closures - Special function call forms - Default parameter values
 */
package com.artima.scala5ed.ch08

@main
def s08cSpecialDefault(): Unit =
  /**
   * Point generator
   *
   * @param x
   *   the x component
   * @param y
   *   the y component
   * @return
   *   a 2-tuple representing a point
   */
  def point(x: Int = 0, y: Int = 0) = (x, y)

  println("A point: " + point(42, 21))
  println("A point on x: " + point(42))
  println("Another point on x: " + point(x = 21))
  println("A point on y: " + point(y = 42))
  println("Origin: " + point())
