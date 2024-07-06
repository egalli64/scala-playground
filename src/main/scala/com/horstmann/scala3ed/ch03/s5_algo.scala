/*
Scala for the Impatient Third Edition - Cay S. Horstmann
Source code shown in the book
Download the zip file from: https://horstmann.com/scala/

https://github.com/egalli64/scala-playground

3. Working with Arrays
 5. Common Algorithms
 */
package com.horstmann.scala3ed.ch03

import scala.collection.mutable.ArrayBuffer

@main
def s5_algo(): Unit =
  val a = Array(1, 7, 2, 9)
  val b = a.toBuffer
  println(s"Given the array ${a.mkString(", ")} and the array buffer $b")

  // sum
  println(s"Using the method sum to add up all the elements: ${a.sum}, ${b.sum}\n")

  // max
  println(s"Using max to get the largest element: ${a.max}, ${b.max}")
  val bs = ArrayBuffer("Mary", "had", "a", "little", "lamb")
  println(s"On strings, in $bs max is ${bs.max}\n")

  // sorting
  val aSorted = a.sorted
  val bSorted = b.sorted
  println(s"Using the method sorted: ${aSorted.mkString(", ")} - $bSorted")

  val aDescSorted = a.sortWith(_ > _)
  val bDescSorted = b.sortWith(_ > _)
  println(s"Using sortWith with a lambda: ${aDescSorted.mkString(", ")} - $bDescSorted")

  // sort in-place
  a.sortInPlace
  // not available on buffer
  // b.sortInPlace
  println("Using sortInPlace only on array: " + a.mkString(", "))
