/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 1 - Functions & Evaluations - Lecture 1.6 - Blocks and lexical scope
 */
package org.coursera.efpl.course1.week1

import scala.annotation.tailrec

object Lecture6:
  /**
   * Square root of argument, Newton's method in a block
   *
   * */
  def sqrt(x: Double): Double =
    // we can have auxiliary definitions inside a block, private to it
    @tailrec
    def sqrtImprover(guess: Double): Double =
      val improved = improve(guess)
      if isGoodEnough(guess, improved) then improved
      else sqrtImprover(improved)

    def isGoodEnough(previous: Double, current: Double): Boolean =
      Math.abs(previous - current) < 0.000_001

    def improve(guess: Double): Double =
      (guess + x / guess) / 2

    // last statement - define the block value
    sqrtImprover(x / 2)
