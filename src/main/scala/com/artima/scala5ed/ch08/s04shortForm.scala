/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functions and Closures - Short forms of function literals
 */
package com.artima.scala5ed.ch08

@main
def s04shortForm(): Unit =
  val someNumbers = List(-11, 5, 0, 10)
  println("Some numbers: " + someNumbers)

  // target typing: parameter type could be deduced by compiler
  val positives = someNumbers.filter((x) => x > 0)
  println("Positives: " + positives)

  // no parentheses required around a parameter whose type is inferred
  val positives2 = someNumbers.filter(x => x > 0)
  println("Positives (v.2): " + positives2)
