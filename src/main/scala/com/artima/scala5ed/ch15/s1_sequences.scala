/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Other Collections - Sequences
 */
package com.artima.scala5ed.ch15

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

@main
def s1_seq(): Unit =
  // 1. List
  val colors = List("red", "blue", "green")
  println("A list: " + colors)
  println("List head: " + colors.head)
  println("List tail: " + colors.tail)

  // 2. Array
  val fiveIntegers = new Array[Int](5)
  println("An array sized 5, default initialized: " + fiveIntegers.mkString(" "))

  val fiveToOne = Array(5, 4, 3, 2, 1)
  println("An array sized 5, initialized: " + fiveToOne.mkString(" "))

  // read/write access by apply
  fiveIntegers(0) = fiveToOne(4)
  fiveIntegers.update(1, fiveToOne.apply(3))
  println("An array after modify: " + fiveIntegers.mkString(" "))

  // 3. List buffer - mutable collection
  val lBuf = new ListBuffer[Int]
  println("A list buffer: " + lBuf)
  lBuf += 1
  println("Append 1: " + lBuf)
  lBuf += 2
  println("Append 2: " + lBuf)
  3 +=: lBuf
  println("Prepend 3: " + lBuf)
  println("Convert to list: " + lBuf.toList)

  // 4. Array buffer
  val aBuf = new ArrayBuffer[Int]()
  println("An array buffer: " + aBuf)
  aBuf += 1
  println("Append 1: " + aBuf)
  aBuf += 2
  println("Append 2: " + aBuf)
  3 +=: aBuf
  println("Prepend 3: " + aBuf)
  println("Convert to array: " + aBuf.toArray.mkString(" "))

  // 5. String - implicit conversion from String to StringOps
  def hasUpperCase(s: String) = s.exists(_.isUpper)

  println(hasUpperCase("Robert Frost"))
  println(hasUpperCase("e e cummings"))
