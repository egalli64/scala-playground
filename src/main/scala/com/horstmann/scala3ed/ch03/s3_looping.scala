/*
Scala for the Impatient Third Edition - Cay S. Horstmann
Source code shown in the book
Download the zip file from: https://horstmann.com/scala/

https://github.com/egalli64/scala-playground

3. Working with Arrays
 3. Traversing Arrays and Array Buffers
 */
package com.horstmann.scala3ed.ch03

@main
def s3_looping(): Unit =
  // looping on array
  //
  val a = Array(4, 5, 3)
  println(s"An array: " + a.mkString(", "))

  print("Looping on its values: ")
  for x <- a do print(x + " ")
  println()

  print("Looping on its indices: ")
  for i <- a.indices do print(s"a($i) is ${a(i)} ")
  println()

  print("... from right to left [ ")
  for i <- a.indices.reverse do print(s"a($i)=${a(i)} ")
  println("]")

  print("Same, less readable [ ")
  for i <- a.length - 1 to 0 by -1 do print(s"a($i)=${a(i)} ")
  println("]")

  print("Looping on range in [0, len): ")
  // or: i <- 0 until a.length
  // or: 0 to a.length -1
  for i <- Range(0, a.length) do print(s"a($i) is ${a(i)} ")
  println("\n")

  // looping on array buffer
  //
  val b = a.toBuffer
  b ++= List(2, 7)
  b.remove(0, 2)
  println("An array buffer: " + b)

  print("Looping on its values: ")
  for x <- b do print(x + " ")
  println()

  print("Looping on its indices: ")
  for i <- b.indices do print(s"b($i) is ${b(i)} ")
  println()

  print("... from right to left [ ")
  for i <- b.indices.reverse do print(s"b($i)=${b(i)} ")
  println("]")
