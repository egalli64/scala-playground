/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  3. Working with Arrays
   8. Interoperating with Java
 */
package com.horstmann.scala3ed.ch03

import scala.jdk.CollectionConverters.*

@main
def s8_java(): Unit =
  val a1 = Array(7, 11, 23, 51, 73)
  println("An array of Int: " + a1.mkString(", "))

  // using Java, we should follow its approach
  val target1 = 51
  print(s"Binary search for $target1 on array (as Java primitive): ")
  println(java.util.Arrays.binarySearch(a1, target1))

  val a2 = Array("Mary", "a", "had", "lamb", "little")
  val target2 = "beef"
  println("An array of String: " + a2.mkString(", "))
  // won't compile, it requires the "Object" overload, not allowed is Scala for safety
  // println(java.util.Arrays.binarySearch(a2, target2))

  // the conversion should the explicit
  print(s"Binary search for $target2 on array (as Java reference): ")
  println(java.util.Arrays.binarySearch(a2.asInstanceOf[Array[Object]], target2))

  // here there is no need to go for Java, for indexed sequence search is implicitly binary
  println("\nScala binary search")
  println(s"For $target1: " + a1.search(target1))
  println(s"For $target2: " + a2.search(target2))

  println()
  val b = a1.toBuffer
  println("An array buffer: " + b)
  val bj = b.asJava
  println("The array buffer converted to a Java List: " + bj)

  val jl = java.util.List.of(3, 5, 2, 8)
  println("A Java list: " + jl)
  val b2 = jl.asScala
  println("The Java list converted to a Scala buffer: " + b2)

  // As always, binary search assumes the sequence is sorted
  val targetB2 = 2
  println(s"For $targetB2 when the buffer is not sorted: " + b2.search(2))
