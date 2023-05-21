/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Control Abstraction - Currying
 */
package com.artima.scala5ed.ch09

@main
def s3currying(): Unit =
  /**
   * A non-curried function
   *
   * @param x
   *   a value
   * @param y
   *   another value
   * @return
   *   the sum
   */
  def plainOldSum(x: Int, y: Int) = x + y
  println("Uncurried: " + plainOldSum(1, 2))

  /**
   * Curried version of the previous function
   *
   * @param x
   *   a value
   * @param y
   *   another value
   * @return
   *   the sum
   */
  def curriedSum(x: Int)(y: Int) = x + y
  println("Curried: " + curriedSum(1)(2))

  /**
   * Splitting the curried sum() in two functions
   *
   * @param x
   *   the first parameter
   * @return
   *   a function taking a (second) parameter and return the sum
   */
  def first(x: Int) = (y: Int) => x + y

  /**
   * Second part of the currying process
   */
  val second = first(1)

  // invoking the second() step of the curried function
  println("Applying first: " + second)
  println("Applying second: " + second(2))

  // Using eta expansion to get the first step of curried function
  val onePlus = curriedSum(1)
  println("Applying first step of curried: " + onePlus)
  println("Applying second step of curried: " + onePlus(2))
