/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Next Steps in Scala - Use tuples
 */
package com.artima.scala5ed.ch03

@main
def s09(): Unit =
  // A tuple could be used as a simple and fast JavaBean replacement, for instance as composite return value
  val pair = (99, "Luftballons")
  println(s"pair is $pair, a Tuple2[Int, String]")

  val num = pair(0)
  println(s"pair(0) is $num")

  val what = pair(1)
  println(s"pair(1) is $what")

  val tupleSix = ('u', 'r', "the", 1, 4, "me")
  println(s"$tupleSix is a Tuple6Tuple6[Char, Char, String, Int, Int, String]")
