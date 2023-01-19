/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 1 - Functions & Evaluations - Lecture 1.7 - Tail recursion
 */
package org.coursera.efpl.course1.week1

import scala.annotation.tailrec

object Lecture7:
  /**
   * Greater common divisor by Euclid - tail recursive
   *
   * @param a first value
   * @param b second value
   * @return the greater common divisor
   * */
  @tailrec def gcd(a: Int, b: Int): Int =
    if b == 0 then a else gcd(b, a % b)

  /**
   * Factorial - not tail recursive version
   *
   * @param n a natural number
   * @return its factorial
   * */
  def factorial(n: Int): Int =
    if n == 0 then 1 else n * factorial(n - 1)

  /**
   * Factorial - tail recursive version
   *
   * @param n a natural number
   * @return its factorial
   * */
  def factorialTail(n: Int): Int =
    /**
     * Auxiliary definitions for tail recursion
     *
     * @param n current value to process
     * @param partial accumulator for the result
     * @return the factorial
     */
    @tailrec
    def factorial(n: Int, partial: Int): Int =
      if n == 0 then partial else factorial(n-1, partial * n)

    if n < 1 then 1 else factorial(n-1, n)

/**
 * Smoke test for Lecture7
 * */
@main def mainLecture7(): Unit =
  import org.coursera.efpl.course1.week1.Lecture7.*

  val first = 15
  val second = 10
  printf("GCD of %d and %d is %d%n", first, second, gcd(first, second))
  printf("Factorial of %d is %d%n", second, factorial(second))
  printf("Factorial (tail recursive) of %d is %d%n", second, factorialTail(second))
