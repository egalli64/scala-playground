/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 2 - High Order Functions - Lecture 2.1 - Higher-order functions
 */
package org.coursera.efpl.course1.week2

import scala.annotation.tailrec

object Lecture1:
  /**
   * Sum all the values in an interval
   *
   * @param a lower bound
   * @param b upper bound
   * @return sum, or zero if inconsistent interval
   */
  def sumInterval(a: Int, b: Int): Int =
    if a > b then 0 else a + sumInterval(a + 1, b)

  /**
   * Cube
   *
   * @param x an integer
   * @return cube of input
   */
  def cube(x: Int): Int = x * x * x

  /**
   * Sum the cube of all the values in an interval
   *
   * @param a lower bound
   * @param b upper bound
   * @return sum of cubes, or zero if inconsistent interval
   */
  def sumCubes(a: Int, b: Int): Int =
    if a > b then 0 else cube(a) + sumCubes(a + 1, b)

  def fact(x: Int): Int =
    if x < 2 then 1 else x * fact(x - 1)

  /**
   * Sum the factorial of all the values in an interval
   *
   * @param a lower bound
   * @param b upper bound
   * @return sum of cubes, or zero if inconsistent interval
   */
  def sumFactorials(a: Int, b: Int): Int =
    if a > b then 0 else fact(a) + sumFactorials(a + 1, b)

  def identity(x: Int): Int = x

  /**
   * Sum of interval by higher order function. The caller decide how to transform each value
   *
   * @param f the function to be applied at each value (Int as input, Int as output)
   * @param a lower bound
   * @param b upper bound
   * @return sum of the result of f, or zero if inconsistent interval
   * */
  def sum(f: Int => Int, a: Int, b: Int): Int =
    if a > b then 0
    else f(a) + sum(f, a + 1, b)

  /**
   * Tail recursive version
   *
   * @param f the function to be applied to each value
   * @param lower the lower bound
   * @param upper the upper bound
   * @return sum of all f(x)
   */
  def sumTR(f: Int => Int, lower: Int, upper: Int): Int =
    @tailrec
    def loop(lower: Int, accumulator: Int): Int =
      if lower > upper then accumulator
      else loop(lower + 1, accumulator + f(lower))

    loop(lower, 0)

/**
 * Smoke test for lecture 2.1
 */
@main
def main(): Unit =
  import Lecture1.*

  println("- Calling different methods")
  println("Plain interval: " + sumInterval(2, 6))
  println("Cube interval: " + sumCubes(2, 6))
  println("Factorial interval: " + sumFactorials(2, 6))

  println("- Calling the same higher-order function with different method as parameter")
  println("Plain interval: " + sum(identity, 2, 6))
  println("Cube interval: " + sum(cube, 2, 6))
  println("Factorial interval: " + sum(fact, 2, 6))

  println("- Calling the same higher-order function with different anonymous function as parameter")
  println("Plain interval: " + sum((x: Int) => x, 2, 6))
  println("Cube interval: " + sum((x: Int) => x * x * x, 2, 6))

  println("- Tail recursive version")
  // when the input types for anonymous function ca be inferred, we can leave them out
  println("Plain interval: " + sumTR(x => x, 2, 6))
  println("Cube interval: " + sumTR(x => x * x * x, 2, 6))
