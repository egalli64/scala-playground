/*
  https://docs.scala-lang.org/scala3/book/taste-vars-data-types.html
  https://github.com/egalli64/scala-playground

  Implicit / explicit variable type declaration
  String interpolation, multiline string
 */
package com.github.egalli64.s02

@main def implicitExplicit(): Unit =
  // implicit Int
  val a = 1
  // explicit Int
  val b: Int = 2
  // implicit Double
  val c = Math.PI

  // string interpolation
  println(s"An int: $a")
  println(s"a + b + c is ${a + b + c}")

  // string interpolation on class by multiline string
  println(s"""Scala numeric types:
    $Byte
    $Short
    $Int
    $Long
    $Float
    $Double""")

  // when "normal" numbers are not enough
  val d = BigInt("1000000000000000000000000")
  val e = d * 2
  println(s"A big int: $e")

  println(s"c is a ${c.getClass}, e is a ${e.getClass}")
