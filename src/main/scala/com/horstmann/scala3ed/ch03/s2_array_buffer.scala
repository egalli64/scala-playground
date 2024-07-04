/*
Scala for the Impatient Third Edition - Cay S. Horstmann
Source code shown in the book
Download the zip file from: https://horstmann.com/scala/

https://github.com/egalli64/scala-playground

3. Working with Arrays
 2. Variable-Length Arrays: Array Buffers - ArrayBuffer is equivalent to Java ArrayList
 */
package com.horstmann.scala3ed.ch03

import scala.collection.mutable.ArrayBuffer

@main
def s2_array_buffer(): Unit =
  val b = ArrayBuffer[Int]()
  println(s"An empty int array buffer: " + b)

  b += 1
  println("After appending 1 - O(1): " + b)

  b ++= Array(1, 2, 3, 5, 8)
  println("After appending a collection - O(1): " + b)

  b.dropRightInPlace(3)
  println("After dropping from position 3 to the right - O(1): " + b)

  b.insert(2, 6)
  println("After inserting a 6 in position 2 - O(n): " + b)

  b.insertAll(2, Array(7, 8, 9))
  println("After inserting an iterable in position 2 - O(n): " + b)

  b.remove(2)
  println("After removing the element in position 2 - O(n): " + b)

  b.remove(2, 3)
  println("After removing 3 elements from position 2 on - O(n): " + b)

  // using ArrayBuffer as a raw array builder
  val a = b.toArray
  println(s"The newly created array, ${a.getClass.getName}, is: " + a.mkString(", "))

  b += 42
  println("The array buffer now is: " + b)
  println("Changes on the buffer do not reflect on the raw array: " + a.mkString(", "))