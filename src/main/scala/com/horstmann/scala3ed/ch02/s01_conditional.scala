/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  2. Control Structures and Functions
   1. Conditional Expressions
 */
package com.horstmann.scala3ed.ch02

import scala.util.Random

@main
def s01_conditional(): Unit =
  val x = Random().nextInt(2)

  // an Int if-else
  val x1 = if x > 0 then 1 else -1
  println(s"From 0, 1 to -1, 1: $x1, type is ${x1.getClass}")

  // a Matchable if-else (in the worst case, Any will be used)
  val x2 = if x > 0 then "positive" else -1
  println(s"From 0, 1 to -1, 'positive': $x2, type is ${x2.getClass}")

  // do not use an if with no else as expression, or you'll always get Unit!
  // val x3 = if x > 0 then "positive"
  // println(s"${x3}, type is ${x3.getClass}")
