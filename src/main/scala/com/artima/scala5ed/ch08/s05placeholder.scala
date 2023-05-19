/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functions and Closures - Placeholder syntax
 */
package com.artima.scala5ed.ch08

@main
def s05placeholder(): Unit =
  val someNumbers = List(-11, 5, 0, 10)
  println("Some numbers: " + someNumbers)

  // Underscore as placeholder to shorten the syntax
  val positives = someNumbers.filter(_ > 0)
  println("Positives: " + positives)

  // Compiler could be not smart enough to deduce the parameter type, sometimes
  // val f = _ + _

  // Multiple underscores mean multiple parameters
  val f = (_: Int) + (_: Int)
  println("Adding two integers: " + f(positives.head, positives(1)))
