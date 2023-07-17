/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Other Collections - Initializing collections
 */
package com.artima.scala5ed.ch15

import scala.collection.immutable.TreeSet
import scala.collection.mutable

@main
def s4_init(): Unit =
  val al = List(1, 2, 3)
  println("A list (implicit call to apply): " + al)

  val al2 = List.apply(1, 2, 3)
  println("Another list (explicit call to apply): " + al2)

  val as = Set('a', 'b', 'c')
  println("A set: " + as)

  val mm = mutable.Map("hi" -> 2, "there" -> 5)
  println("A mutable map: " + mm)

  val aa = Array(1.0, 2.0, 3.0)
  println("An array: " + aa.mkString(" "))

  /*
      when inferred collection type is not good
   */
  val msi = mutable.Set(42)
  println("A mutable set of int: " + msi)
  // can't add a String to a collection of int!
  // stuff += "abracadabra"

  val msa = mutable.Set[Any](42)
  msa += "abracadabra"
  println("A mutable set of Any: " + msa)

  val colors = List("blue", "yellow", "red", "green")
  println("A string list: " + colors)

  /*
      converting a collection to another collection
   */

  // No implicit Ordering defined for List[String]
  // val ts = TreeSet(colors)

  // Use the to method for explicit conversion
  val treeSet = colors to TreeSet
  println("Converted to an ordered set: " + treeSet)

  /*
      converting to array or list
   */
  println("Converted to list: " + treeSet.toList)
  println("Converted to array: " + treeSet.toArray.mkString(" "))

  /*
      converting between mutable and immutable sets and maps
   */
  val mutableSet = treeSet to mutable.Set
  println("Converted to mutable set: " + mutableSet)

  val immutableSet = mutableSet to Set
  println("Converted to immutable set: " + immutableSet)

  val immutableMap = mm to Map
  println("Map converted to immutable: " + immutableMap)
