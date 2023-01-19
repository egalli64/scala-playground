/*
  Functional Programming Principles in Scala - Getting Started
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 1 - Getting Started - Example - Practice Programming Assignment
 */
package org.coursera.efpl.course1.week1.assigment

import scala.annotation.tailrec

object Lists:
  /**
   * Sum of all elements in the passed list xs.
   *
   * It is required to use the following methods in class `List`:
   *  - `xs.isEmpty` `true` if the list is empty
   *  - `xs.head` the head element of the list or exception
   *  - `xs.tail` the list without its `head` element
   *
   * @param xs A list of natural numbers
   * @return The sum of all elements in `xs`
   */
  def sum(xs: List[Int]): Int = if xs.isEmpty then 0 else xs.head + sum(xs.tail)

  /**
   * The largest element in a list of integers or throws `java.util.NoSuchElementException`.
   * ''Hint:'' Again, think of a recursive solution instead of using looping
   * constructs. You might need to define an auxiliary method.
   *
   * @param xs A list of natural numbers
   * @return The largest element in `xs`
   * @throws java.util.NoSuchElementException if `xs` is an empty list
   */
  def max(xs: List[Int]): Int = max(xs.tail, xs.head)

  /**
   * Auxiliary method implementing recursion
   *
   * @param xs A list of natural numbers
   * @param cur The largest element so far
   * @return The largest element in the original list
   */
  @tailrec
  private def max(xs: List[Int], cur: Int): Int = if xs.isEmpty then cur else max(xs.tail, Math.max(xs.head, cur))
