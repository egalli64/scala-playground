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
  println(if x > 0 then 1 else -1)
  // a Matchable if-else (in the worst case, Any will be used)
  println(if x > 0 then "positive" else -1)
  // do not use an if with no else as expression, or you'll always get Unit!
  println(if x > 0 then "positive")