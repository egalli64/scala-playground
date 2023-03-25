/*
  https://docs.scala-lang.org/scala3/book/fun-function-variables.html
  https://github.com/egalli64/scala-playground

  Functions - Function Variables
 */
package com.github.egalli64.scala3.b08

@main
def funVar(): Unit =
  val values = List(1, 2, 3)
  /*
    A lambda (function literal) could be assigned to a function variable
   */

  // The compiler can't deduce the types, explicit notation required
  // This lambda is a Int => Int function
  val doubler = (i: Int) => i * 2
  println("Doubling values: " + values.map(doubler))

  val triple = (i: Int) => i * 3
  println("Tripling values: " + values.map(triple))

  // Function variables can be used as any other variable
  val multipliers: List[Int => Int] = List(doubler, triple)
  val multiplierByName: Map[String, Int => Int] = Map("2x" -> doubler, "3x" -> triple)

  println("Applying first multiplier: " + values.map(multipliers.head))
  println("Applying 3x multiplier: " + values.map(multiplierByName("3x")))
