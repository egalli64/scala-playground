/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  1. The Basics 6. The apply Method
 */
package com.horstmann.scala3ed.ch01

@main
def s6_apply(): Unit =
  println()

  // Parentheses are also used to access a sequence element
  val s = "Hello"
  println(s"'$s' index 4 is '${s(4)}'")
  println(s"Same, but using explicitly apply(): '${s.apply(4)}'")

  // Won't compile, an Ordering is expected by sorted
  // "Bonjour".sorted(3)

  // Divide it in two parts
  val result = "Bonjour".sorted
  println(s"'$result' index 3 is '${result(3)}'")

  // Or explicit the apply() call
  println(s"Same, apply(): '${"Bonjour".sorted.apply(3)}'")

  // In Scala apply is a common way to create an object
  val x1 = BigInt("1234567890")
  val x2 = BigInt.apply("1234567890")

  println(s"$x1 == $x2? ${x1 == x2}")

  // So "new" is commonly avoided
  val x3 = BigInt("1234567890") * BigInt("112358111321")
  println("A big int: " + x3)

  println("Create an array by apply: " + Array(1, 4, 9, 16).mkString(" "))
