/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Next Steps in Scala - Use sets (and maps)
 */
package com.artima.scala5ed.ch03

import scala.collection.immutable.HashSet
import scala.collection.mutable

@main
def s10aSet(): Unit =
  // Both mutable and immutable Set are available in Scala - immutable is the default choice

  // a var - could be reassigned - immutable Set of String, created by factory apply() on Set companion object
  var jetSet = Set("Boeing", "Airbus")

  // it's a var, it could be reassigned to a _new_ Set with an extra element
  jetSet += "Lear"
  println(jetSet)
  println(jetSet.contains("Cessna"))

  // a val - can't be reassigned - mutable Set of String
  val movieSet = mutable.Set("Spotlight", "Moonlight")

  // do _not_ create a new object, the existing set is modified
  movieSet += "Parasite"
  println(movieSet)

  // when required, an explicit HashSet could be used (here, immutable)
  val hashSet = HashSet("Tomatoes", "Chilies")
  val ingredients = hashSet + "Coriander"
  println(s"$hashSet and $ingredients")
