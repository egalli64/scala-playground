/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Other Collections - Sets and maps
  map - Predef immutable
 */
package com.artima.scala5ed.ch15

import scala.collection.mutable

@main
def s2b_map(): Unit =
  val mutableMap = mutable.Map.empty[String, Int]
  println("An empty mutable map of int: " + mutableMap)

  mutableMap("hello") = 1
  mutableMap("there") = 2
  println("Add couples: " + mutableMap)
  println("Access value given a key: " + mutableMap("hello"))

  /**
   * Given a string, counts the word occurrences in it
   *
   * @param text
   *   a textual string
   * @return
   *   words occurrence count
   */
  def countWords(text: String) =
    val counts = mutable.Map.empty[String, Int]
    for rawWord <- text.split("[ ,!.]+") do
      val word = rawWord.toLowerCase
      val count = if counts.contains(word) then counts(word) + 1 else 1
      // version 1: change the value associated to the key, or add a new pair
//      counts(word) = count
      // version 2: add a pair to the map, or change the value associated to the key
      counts += (word -> count)
    counts

  println("Map word to count: " + countWords("See Spot run! Run, Spot. Run!"))
