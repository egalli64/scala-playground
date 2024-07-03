/*
Scala for the Impatient Third Edition - Cay S. Horstmann
Source code shown in the book
Download the zip file from: https://horstmann.com/scala/

https://github.com/egalli64/scala-playground

2. Control Structures and Functions
 3. Block Expressions and Assignments
  A block value is the value of its last expression - notice that assignments are Units!
 */
package com.horstmann.scala3ed.ch02

@main
def s03_block(): Unit =
  val x = 7
  val x0 = 5
  val y = 3
  val y0 = 4

  // 1. brackets required to signal a block
  // 2. semicolons required to signal end of statement in block
  // 3. the last statement is evaluated, the rhs assigned to the lhs
  val distance = { val dx = x - x0; val dy = y - y0; scala.math.sqrt(dx * dx + dy * dy) }
  println(s"the distance between ($x, $y) and ($x0, $y0) is $distance")

  // same, in a more scala3-idiomatic way
  // 1. no brackets, but newline
  // 2. no semicolon, but newline
  val distance2 =
    val dx = x - x0
    val dy = y - y0
    scala.math.sqrt(dx * dx + dy * dy)
  println(s"the distance between ($x, $y) and ($x0, $y0) is $distance")
