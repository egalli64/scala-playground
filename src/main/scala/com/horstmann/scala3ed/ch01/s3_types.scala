/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  1. The Basics 3. Commonly Used Types
 */
package com.horstmann.scala3ed.ch01

@main
def s3_types(): Unit =
  // Invoking methods on values

  // Generating a String from an Int
  val s1 = 1.toString
  println("First char in s1 is: " + s1(0))

  // Generating a Range for Int in 1 .. 10
  val r = 1.to(10)
  println("toString on r is: " + r)

  /*
    A Scala String is more than a Java String
    When required it is wrapped in a StringOps
   */
  // These two expressions are equivalent, Yielding to "lo"
  println("String intersection: " + "Hello".intersect("World"))
  print("Same, making the StringOps operation nature explicit: ")
  println(scala.collection.StringOps("Hello").intersect("World"))

  /*
    A Scala Int is more than a Java Integer
    When required it is wrapped in a RichInt
   */
  println("RichInt to generate a range from an Int: " + scala.runtime.RichInt(1).to(10))

  // Use type conversions (and not casts) in Scala
  println("A Double converted to Int: " + 99.44.toInt)
  println("An Int converted to Char: " + 99.toChar)
