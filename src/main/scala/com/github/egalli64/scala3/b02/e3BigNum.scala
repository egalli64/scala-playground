/*
  https://docs.scala-lang.org/scala3/book/taste-collections.html
  https://github.com/egalli64/scala-playground

  BigInt and BigDecimal
 */
package com.github.egalli64.scala3.b02

@main
def bigNum(): Unit =
  // 1. BigInt are bigger than Long!
  val bi = BigInt(Long.MaxValue)
  println("Max long as big int: " + bi)

  val bi2 = bi * bi
  println("Squared max long as big int: " + bi2)

  // 1b. Usual arithmetic operators supported
  println("Big int divided by 10: " + bi2 / 10)

  // 2. BigDecimal do not have the rounding problems of IEEE floating points
  val dr1 = 3.0
  val dr2 = 2.1
  println(s"Plain double subtraction: $dr1 - $dr2 = ${dr1 - dr2}")
  val bd1 = BigDecimal(3.0)
  val bd2 = BigDecimal(2.1)
  println(s"Big decimal subtraction: $bd1 - $bd2 = ${bd1 - bd2}")
