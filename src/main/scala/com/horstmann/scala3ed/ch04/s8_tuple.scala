/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  4. Map, Option, Tuple
   8. Tuples
 */
package com.horstmann.scala3ed.ch04

@main
def s8_tuple(): Unit =
  val t = (1, 3.14, "Fred")
  println(s"$t has components: ${t._1}, ${t._2}, ${t._3}")
  println(s"$t has components: ${t(0)}, ${t(1)}, ${t(2)}")

  val (first, second, third) = t
  println(s"Destructured tuple: $first, $second, $third")

  val t2 = ("x", 3) ++ ("y", 4)
  println("Concatenated tuple by ++ is " + t2)

  val t3 = "New York".partition(_.isUpper)
  println("A method returning a tuple: " + t3)