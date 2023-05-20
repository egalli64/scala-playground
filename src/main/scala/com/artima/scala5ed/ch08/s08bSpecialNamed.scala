/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functions and Closures - Special function call forms - Named arguments
 */
package com.artima.scala5ed.ch08

@main
def s08aSpecialNamed(): Unit =
  /**
   * A simple function with two parameters
   *
   * @param distance
   *   first parameter
   * @param time
   *   second parameter
   * @return
   *   the calculated average speed
   */
  def speed(distance: Float, time: Float) = distance / time

  // the standard positional notation could be unclear
  println(speed(100, 10))

  // to improve readability, named arguments could be used
  println(speed(distance = 100, time = 10))
  println(speed(time = 10, distance = 100))
