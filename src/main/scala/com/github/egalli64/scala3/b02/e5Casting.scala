/*
  https://docs.scala-lang.org/scala3/book/first-look-at-types.html
  https://github.com/egalli64/scala-playground

  Type casting
 */
package com.github.egalli64.scala3.b02

@main
def casting(): Unit =
  // 1. widening is free
  val b: Byte = 42
  val s: Short = b
  val i: Int = s
  val l: Long = i
  val f: Float = l
  val d: Double = f

  println(s"A byte: $b, a short: $s, an int: $i, a long: $l, a float: $f, a double: $d")

  // 1b. char to int is kind of strange
  val c = '☺'
  val ic: Int = c
  println(s"A char: $c, converted to int: $ic")

  // 1c. long to float could be dangerous (precision loss)
  val ll = 987_654_321
  val lf: Float = ll
  val ld: Double = ll
  println(s"A large long: $ll, converted to float: $lf, better to jump straight to double: $ld")

  // 1d. narrowing requires explicit cast
  val sb: Byte = d.toByte
  println(s"Narrowing a small double ($d) to a byte ($sb) asks for explicit cast")
