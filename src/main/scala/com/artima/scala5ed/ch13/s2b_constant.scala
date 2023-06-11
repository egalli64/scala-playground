/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Pattern Matching - Kinds of patterns - Constant

  Any literal, val, singleton could be used as a constant
  Constant vs variable: if the first letter is lowercase a pattern variable is assumed
 */
package com.artima.scala5ed.ch13

@main
def s2b(): Unit =
  def describe(x: Any) = x match
    case 5       => "five"
    case true    => "truth"
    case "hello" => "hi!"
    case Nil     => "the empty list"
    case _       => "something else"

  assert(describe(5) == "five")
  assert(describe(true) == "truth")
  assert(describe("hello") == "hi!")
  assert(describe(Nil) == "the empty list")
  assert(describe(List(1, 2, 3)) == "something else")

  /**
   * Pattern constant vs pattern variable
   *
   * @param x
   *   could be anything
   * @return
   *   a description of x
   */
  def checkZero(x: Any) = x match
    case 0             => "zero"
    case somethingElse => s"not zero: $somethingElse"

  assert(checkZero(0) == "zero")
  assert(checkZero(null) == "not zero: null")

  import math.{Pi, E}
  def checkAgainstPi(x: Double) = x match
    // Pi is assumed to be a constant and not a pattern variable, because it starts with an uppercase letter
    case Pi => true
    case _  => false

  assert(checkAgainstPi(Pi))
  assert(!checkAgainstPi(E))

  val myPi = Pi
  def checkAgainstMyPi(x: Double) = x match
    // enclosing the name in backtick force the constant interpretation
    case `myPi` => true
    case _      => false

  assert(checkAgainstMyPi(Pi))
  assert(!checkAgainstMyPi(E))
