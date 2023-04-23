/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Next Steps in Scala - Use (sets and) maps
 */
package com.artima.scala5ed.ch03

import scala.collection.mutable

@main
def s10bMap(): Unit =
  // Mutable and immutable versions of Map are available

  // a mutable empty map, we need to specify the key and value types
  val treasureMap = mutable.Map.empty[Int, String]
  println("The empty map: " + treasureMap)

  // modify the mutable map adding new pairs to it

  // "->" is an _extension method_ called on the left "operand" with the right one as parameter, returns a tuple
  treasureMap += 1 -> "Go to island."
  treasureMap += 2 -> "Find big X on ground."
  treasureMap += 3 -> "Dig."

  println("The treasure map: " + treasureMap)

  // access to a value applying the key to the map
  println("Step 2 in map is: " + treasureMap(2))

  // immutable is default
  val romanNumeral = Map(1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V")
  println(romanNumeral)

  // won't compile
  // romanNumeral += 6 -> "VI"

  println(romanNumeral(3))
