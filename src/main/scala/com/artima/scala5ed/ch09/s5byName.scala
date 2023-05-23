/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Control Abstraction - By-name parameters
 */
package com.artima.scala5ed.ch09

@main
def s5byName(): Unit =
  var assertionsEnabled = true

  /**
   * An assert emulation
   *
   * @param predicate
   *   the condition to be tested is passed in a lambda, so that the condition is evaluated only if
   *   the assertion mechanism is activated
   */
  def myAssert(predicate: () => Boolean): Unit =
    if assertionsEnabled && !predicate() then throw new AssertionError

  myAssert(() => 5 > 3)
  println("The predicate passed is true, so no assertion is thrown")

  try myAssert(() => 5 > 13)
  catch
    case _: AssertionError => println("The predicate passed is false, so an assertion is thrown")

  assertionsEnabled = false
  myAssert(() => 5 > 13)
  println("The assertion mechanism is disabled, so no assertion is thrown")

  /**
   * Same as above, but the parameter is passed by name
   *
   * @param predicate
   *   passed by name
   */
  def byNameAssert(predicate: => Boolean): Unit =
    if assertionsEnabled && !predicate then throw new AssertionError

  // passing a lambda by name
  byNameAssert(5 > 13)
  println("The assertion mechanism (by name) is disabled, so no assertion is thrown")

  assertionsEnabled = true

  byNameAssert(5 > 3)
  println("The predicate passed is true, so no assertion (by name) is thrown")

  try byNameAssert(5 > 13)
  catch
    case _: AssertionError =>
      println("The predicate passed is false, so an assertion (by name) is thrown")
