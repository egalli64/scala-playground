/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  4. Map, Option, Tuple
   9. Zipping
 */
package com.horstmann.scala3ed.ch04

@main
def s9_zip():Unit =
  val symbols = Array("<", "-", ">")
  println("Symbols: " + symbols.mkString(" "))

  val counts = Array(2, 10, 2)
  println("Counts: " + counts.mkString(" "))

  val pairs = symbols.zip(counts)
  println("Zip to match symbols to counts: " + pairs.mkString(" "))

  val mapped = pairs.toMap
  println("Zip to map: " + mapped)
