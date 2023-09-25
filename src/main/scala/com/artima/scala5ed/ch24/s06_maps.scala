/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Collections in Depth - Maps
  A map is an iterable of key/value pairs (mappings/associations)
 */
package com.artima.scala5ed.ch24

@main
def s06_maps(): Unit =
  val map1 = Map("x" -> 24, "y" -> 25, "z" -> 26)
  val map2 = Map(("x", 24), ("y", 25), ("z", 26))
  println(s"Two ways to create the same map: $map1, $map2")
