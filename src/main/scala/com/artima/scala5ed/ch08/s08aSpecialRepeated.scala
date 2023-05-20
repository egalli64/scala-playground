/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functions and Closures - Special function call forms - Repeated parameters
 */
package com.artima.scala5ed.ch08

@main
def s08aSpecialRepeated(): Unit =
  /**
   * varargs, the last parameter may be repeated
   *
   * @param args
   *   zero, one, ... strings to be printed
   */
  def echo(args: String*): Unit =
    // args is internally converted to a sequence
    for arg <- args do println(arg)

  println("***")
  echo()

  println("***")
  echo("one")

  println("***")
  echo("one", "two")

  // we can splat a string sequence to pass its elements as varargs
  val seq = Seq("What's", "up", "doc?")
  println("***")
  echo(seq*)
