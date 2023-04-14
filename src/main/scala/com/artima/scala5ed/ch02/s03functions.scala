/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  First Steps in Scala - Define some functions
 */
package com.artima.scala5ed.ch02

@main
def s03(): Unit =
  /**
   * A function definition is introduced by "def". Each parameter should have a type annotation
   *
   * @param x
   *   first parameter
   * @param y
   *   second parameter
   * @return
   *   the returned value, its type is given or inferred by the compiler (for recursive function
   *   must be explicit - and in any case is more readable)
   */
  def max(x: Int, y: Int): Int =
    // if-then-else is an expression
    if x > y then x else y

  println("max is " + max(3, 5))

  // One liner is Scala are on a single line
  def max1liner(x: Int, y: Int): Int = if x > y then x else y
  println("max is really " + max1liner(3, 5))

  // a procedure (void result type in Java) has Unit type
  def greet(): Unit = println("Hello, world!")
  greet()
