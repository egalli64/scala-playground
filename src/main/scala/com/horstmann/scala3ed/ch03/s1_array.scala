/*
Scala for the Impatient Third Edition - Cay S. Horstmann
Source code shown in the book
Download the zip file from: https://horstmann.com/scala/

https://github.com/egalli64/scala-playground

3. Working with Arrays
 1. Fixed-Length Arrays
 */
package com.horstmann.scala3ed.ch03

@main
def s1_array(): Unit =
  val strings = Array("Hello", "World")
  println(s"an array of strings sized ${strings.length} containing ${strings.mkString(", ")}")

  val moreStrings = Array.ofDim[String](5)
  println(s"another array of strings sized ${moreStrings.length} containing ${moreStrings.mkString(", ")}")

  val numbers = Array.ofDim[Int](10)
  println(s"an array of int sized ${numbers.length} containing ${numbers.mkString(", ")}")

  // setter
  strings(0) = "Goodbye"
  println(s"Now the first array contains ${strings.mkString(", ")}")
