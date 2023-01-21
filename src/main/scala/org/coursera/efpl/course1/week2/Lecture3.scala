/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 2 - High Order Functions - Lecture 2.3 - Example: Finding Fixed Points
 */
package org.coursera.efpl.course1.week2

import scala.annotation.tailrec

/**
 * The Newton's method to calculate the square root is based on the search of the fixed point
 * for the function y = x / y (being x = y * y)
 *
 * Let's write a generic function to generate a fixed-point based function
 *
 * @param f the fixed point transformation
 * @param firstGuess the initial guess for the solution
 * @return the specific function for the given fixed point function
 * */
def fixedPoint(f: Double => Double)(firstGuess: Double): Double =
  val tolerance = 0.000_001

  def isCloseEnough(x: Double, y: Double): Boolean =
    Math.abs((x - y) / x) < tolerance

  @tailrec
  def iterate(guess: Double): Double =
    val next = f(guess)
    if isCloseEnough(guess, next) then next else iterate(next)

  iterate(firstGuess)

/**
 * However, using the fixed point won't work for our square root algorithm.
 * Variation in steps could be too wide, leading to infinite loop.
 * To reduce the oscillation, let's use the average of the two values
 * <li>y => (y + x / y) / 2
 * @param x user input
 * @return square root of x
 */
def sqrtFix(x: Double): Double = fixedPoint(y => (y + x/y) / 2)(x / 2)

/**
 * The fix shown above makes to code less readable.
 * Let's write another function to improve it.
 * <p>
 * Average dumping: reduce oscillation around a fixed point
 *
 * @param f the original function
 * @param x the user input
 * @return the function to be used by fixed point
 * */
def averageDamp(f: Double => Double)(x: Double): Double = (x + f(x)) / 2

/**
 * A more readable version of our square root function
 *
 * @param x user input
 * @return square root of x
 * */
def sqrt(x: Double): Double = fixedPoint(averageDamp(y => x / y))(x / 2)

/**
 * Smoke test for lecture 3
 * */
@main def lecture3(): Unit =
  println(sqrtFix(2))
  println(sqrt(2))
