/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Pattern Matching - Patterns everywhere - Patterns in for expressions
 */
package com.artima.scala5ed.ch13

@main
def s7c(): Unit =
  val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

  // matching each pair k/v in capitals against the pattern (country, city)
  for (country, city) <- capitals do println(s"The capital of $country is $city")

  val results = List(Some("apple"), None, Some("orange"))
  // non-matching elements are discarded, use "case" to avoid a warning
  for case Some(fruit) <- results do println(fruit)
