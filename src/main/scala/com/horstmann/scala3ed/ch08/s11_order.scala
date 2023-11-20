/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  8. Inheritance
   11. Construction Order
 */
package com.horstmann.scala3ed.ch08

@main
def s11_order(): Unit =
  class Creature:
    val range: Int = 10
    println(s"range is $range")

    val env: Array[Int] = Array.ofDim[Int](range)
    println("So, env is sized " + env.length)

  class Ant extends Creature:
    override val range = 2

  println("Creating a creature")
  val c = new Creature

  println("Creating an ant (consider using lazy val)")
  val ant = new Ant
