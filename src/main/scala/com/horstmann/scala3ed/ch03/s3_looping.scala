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
  val a = Array(4, 5, 3)
  val b = a.toBuffer
  b ++= List(2, 7)
  b.remove(0, 2)

  println("An array: " + a.mkString(", ") + " ")
  // same as for i <- 0 until a.length _or_ 0 <- 0 to a.length -1 _or_ <- Range(0, a.length)
  for i <- a.indices do println(s"a($i) is ${a(i)}")

  println("An array buffer: " + b)
  for i <- b.indices do println(s"b($i) is ${b(i)}")

  print("When the index is not important: ")
  for x <- b do print(x + " ")
  println()

  print("The array from right to left [ ")
  for i <- a.indices.reverse do print(s"a($i)=${a(i)} ")
  println("]")

  print("Same, less readable [ ")
  for i <- a.length - 1 to 0 by -1 do print(s"a($i)=${a(i)} ")
  println("]")
