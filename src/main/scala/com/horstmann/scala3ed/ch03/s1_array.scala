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
  println(s"strings is sized ${strings.length} contains ${strings.mkString(", ")}")

  val moreStrings = Array.ofDim[String](5)
  println(s"moreStrings is sized ${moreStrings.length} contains ${moreStrings.mkString(", ")}")

  val numbers = Array.ofDim[Int](10)
  println(s"numbers is sized ${numbers.length} contains ${numbers.mkString(", ")}")

  // setter
  strings(0) = "Goodbye"
  println(s"Now strings contains ${strings.mkString(", ")}")
