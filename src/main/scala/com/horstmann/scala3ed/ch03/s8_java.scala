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
  print("Binary search on Java primitive: ")
  println(java.util.Arrays.binarySearch(a1, 51))

  val a2 = Array("Mary", "a", "had", "lamb", "little")
  // won't compile, it requires the "Object" overload, not allowed is Scala for safety
  // println(java.util.Arrays.binarySearch(a2, "beef"))

  // the conversion should the explicit
  print("Binary search on Java reference: ")
  println(java.util.Arrays.binarySearch(a2.asInstanceOf[Array[Object]], "lamb"))

  // here there is no need to go for Java, for indexed sequence search is implicitly binary
  println("Scala binary search: " + a2.search("lamb"))

  val b = a1.toBuffer
  println("An array buffer: " + b)
  val bj = b.asJava
  println("The array buffer converted to a Java List: " + bj)

  val jl = java.util.List.of(3, 5, 2, 8)
  println("A Java list: " + jl)
  val b2 = jl.asScala
  println("The Java list converted to a Scala buffer: " + b2)
