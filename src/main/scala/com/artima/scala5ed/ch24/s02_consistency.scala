/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Collections in Depth - Collections consistency
 */
package com.artima.scala5ed.ch24

import scala.collection.mutable

@main
def s02_consistency(): Unit =
  // every kind of collection can be created by the same uniform syntax
  println(Iterable("x", "y", "z"))
  println(Map("x" -> 24, "y" -> 25, "z" -> 26))

  // same for specific collection implementations
  println(List("x", "y", "z"))
  println(mutable.HashMap("x" -> 24, "y" -> 25, "z" -> 26))
