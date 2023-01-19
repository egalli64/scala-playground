/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 1 - Functions & Evaluations - Lecture 1.5 - Square root with Newton's method
 */
package org.coursera.efpl.course1.week1

import scala.annotation.tailrec

object Lecture5:
  /**
   * Square root of argument, Newton's method
   *
   * To compute the square root of x
   * - Start with an initial estimate es: guess = x / 2
   * - Improve the estimate taking the mean of guess and x / guess
   * - If the improved estimate is close to the previous estimate, return it
   * - Otherwise call recursively the method
   * */
  def sqrt(x: Double): Double = sqrt(x / 2, x)

  @tailrec
  private def sqrt(guess: Double, x: Double): Double =
    val improved = improve(guess, x)
    if isGoodEnough(guess, improved) then improved
    else sqrt(improved, x)

  private def isGoodEnough(previous: Double, current: Double): Boolean =
    Math.abs(previous - current) < 0.000_001

  private def improve(guess: Double, x: Double): Double =
    (guess + x / guess) / 2
