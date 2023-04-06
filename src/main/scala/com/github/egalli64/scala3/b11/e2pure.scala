/*
  https://docs.scala-lang.org/scala3/book/fp-pure-functions.html
  https://github.com/egalli64/scala-playground

  Functional Programming - Pure Functions

  A function is pure if it always returns the same output from the same input
  Its output depends only on its parameters and its implementation
  It only computes the output

  So:
  It doesn't modify its parameters
  It doesn't mutate any hidden state
  It doesn't have any "back doors"

 */
package com.github.egalli64.scala3.b11

@main
def e2pure(): Unit =
  println("Math.abs() is pure: " + Math.abs(-42.18))
  println("Math.ceil() is pure: " + Math.abs(-42.18))
  println("Math.max() is pure: " + Math.max(-42.18, -25.12))
  println("...")
  println("Math.isEmpty() is pure: " + "".isEmpty)
  println("Math.length() is pure: " + "".length)
  println("Math.substring() is pure: " + "Bobby".substring(0, 3))
  println("...")
  println("Println() is impure, since interact with console")
  println("currentTimeMillis is impure, does not depend only on parameters: " + java.lang.System.currentTimeMillis)

  println("sys.error is impure, since it returns Nothing, throwing an exception")
  try sys.error("Boom!")
  catch case ex: RuntimeException => println("Something went wrong: " + ex.getMessage)

  def double(i: Int): Int = i * 2
  println("Defining and using the pure function double(): " + double(21))

  def sum(xs: List[Int]): Int = xs match
    case Nil => 0
    case head :: tail => head + sum(tail)
  println("Defining and using the pure recursive function sum(): " + sum((1 to 10).toList))
