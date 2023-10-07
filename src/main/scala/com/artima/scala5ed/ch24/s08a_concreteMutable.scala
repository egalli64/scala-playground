/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Collections in Depth - Concrete mutable collection classes
  ArrayBuffer, ListBuffer, StringBuilder, ArrayDeque
 */
package com.artima.scala5ed.ch24

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

@main
def s08a_concreteMutable(): Unit =
  /*
    ArrayBuffer, an array based buffer
   */
  val ab = ArrayBuffer.empty[Int]
  println("An empty ArrayBuffer: " + ab)
  ab += 1
  ab += 10
  println("After appending 1 and 10: " + ab)
  println("Converted to array: " + ab.toArray.mkString("[", ", ", "]"))

  /*
    ListBuffer, a linked list based buffer
   */
  val lb = ListBuffer.empty[Int]
  println("An empty ListBuffer: " + lb)
  lb += 1
  lb += 10
  println("After appending 1 and 10: " + lb)
  println("Converted to list: " + ab.toList)

  /*
    StringBuilder, wrapper for the same Java class
   */
  val sb = new StringBuilder
  sb += 'a'
  sb ++= "bcdef"
  println("After appending 'a' and then \"bcdef\": " + sb)
  println("Converted to string: " + sb.toString)

  /*
    ArrayDeque
   */
  val ad = mutable.ArrayDeque.empty[Int]
  println("An empty ArrayDeque: " + ad)
  ad += 1
  ad.prepend(10)
  println("After appending 1 and prepending 10: " + ad)
  println("Converted to array: " + ad.toArray.mkString("[", ", ", "]"))
