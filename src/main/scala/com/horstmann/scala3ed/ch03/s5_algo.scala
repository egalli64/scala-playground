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

  // sum
  println("Adding up all the elements in an array: " + a.sum)
  println("Adding up all the elements in an array (buffer): " + b.sum)

  // max
  val bs = ArrayBuffer("Mary", "had", "a", "little", "lamb")
  println("Getting the 'max' string in an array (buffer): " + bs.max)

  // sorting
  val bSorted = b.sorted
  println(s"$b sorted is $bSorted")

  val bDescendingSorted = b.sortWith(_ > _)
  println(s"$b descending sorted is $bDescendingSorted")

  // sort in-place
  a.sortInPlace()
  println("Now the array a is sorted: " + a.mkString(", "))