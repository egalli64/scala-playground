/*
  https://docs.scala-lang.org/scala3/book/fp-functions-are-values.html
  https://github.com/egalli64/scala-playground

  Functional Programming - Functional Error Handling

  Option/Some/None (the Option classes) instead of null / exception
 */
package com.github.egalli64.scala3.b11

import scala.io.StdIn.readLine

@main
def e4EH(): Unit =
  val input = readLine("Give me a number: ")

  // imperative approach: exception in case of error
  try
    val value = Integer.parseInt(input.trim)
    println(s"Your input was: $value")
  catch case _: Exception => println("That was not a number!")

  // wrapping parseInt() to use the functional approach
  def parseInt(input: String): Option[Int] =
    try Some(Integer.parseInt(input.trim))
    catch case _: Exception => None

  // consuming an Option by match
  val optNumber = parseInt(input)
  optNumber match
    case Some(value) => println(s"Your input was: $value")
    case None        => println("That was not a number!")

  /**
   * Using a for-yield to generate an option
   * @param a
   *   a string with, hopefully, an int within
   * @param b
   *   a string with, hopefully, an int within
   * @param c
   *   a string with, hopefully, an int within
   * @return
   *   an option int
   */
  def stringsToInt(a: String, b: String, c: String) = for
    x1 <- parseInt(a)
    x2 <- parseInt(b)
    x3 <- parseInt(c)
  yield x1 + x2 + x3

  // consuming the result of stringsToInt
  stringsToInt("1", "2", input) match
    case Some(value) => println(s"The sum is $value")
    case None => println("At least a value was not an int!")
