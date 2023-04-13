/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  A Scalable Language - A language that grows on you
 */
package com.artima.scala5ed.ch01

@main
def s01(): Unit =
  /*
    Scala as a high level language - statically typed but feeling like a dynamic typed one
   */
  var capital = Map("US" -> "Washington", "France" -> "Paris")
  capital += ("Japan" -> "Tokyo")

  println("France capital is " + capital("France"))

  /*
    Built on Java: scala.math.BigInt wraps java.math.BigInteger
   */
  def factorial(x: BigInt): BigInt =
    if x == 0 then 1 else x * factorial(x - 1)

  println("Scala 30! = " + factorial(30))

  /*
    Direct access to Java, if you really need it
   */
  import java.math.BigInteger

  def factorialJ(x: BigInteger): BigInteger =
    if x == BigInteger.ZERO then BigInteger.ONE
    else x.multiply(factorialJ(x.subtract(BigInteger.ONE)))

  println("Java 30! = " + factorialJ(BigInteger("30")))
