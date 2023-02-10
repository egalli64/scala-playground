/*
  https://docs.scala-lang.org/scala3/book/taste-collections.html
  https://github.com/egalli64/scala-playground

  AnyVal - value types
 */
package com.github.egalli64.scala3.b02

@main
def anyVal(): Unit =
  // 1. Numeric types
  val b: Byte = 1
  val s: Short = 2
  val i: Int = 4
  val l: Long = 8
  val f: Float = 4.0
  val d: Double = 8.0
  println(s"A byte: $b, a short: $s, an int: $i, a long: $l, a float: $f, a double: $d")

  // 1b. Default numeric types, Int and Double
  val di = 42
  val dd = 42.0
  println("Default type for an integer is Int: " + di.isInstanceOf[Int])
  println("Default type for a floating point is Double: " + dd.isInstanceOf[Double])

  // 1c. Forcing a non-default numeric type with a single letter
  val fl = 42L
  val ff = 42.0f
  println("Integer forcefully defined as Long by postfix 'L': " + fl.isInstanceOf[Long])
  println("Floating point forcefully defined as Float by postfix 'F': " + ff.isInstanceOf[Float])

  // 2. Char and String
  val ec: Char = 'e'
  val es: String = "Explicit"
  println(s"A char: $ec, a string: $es")

  val ic = 'i'
  val is = "Implicit"
  println("It's easy for Scala detect a char: " + ic.isInstanceOf[Char])
  println("It's easy for Scala detect a string: " + is.isInstanceOf[String])
  println("Remember that a string is not a value, but a reference: " + is.isInstanceOf[AnyRef])
