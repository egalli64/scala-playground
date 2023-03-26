/*
  https://docs.scala-lang.org/scala3/book/fun-write-map-function.html
  https://github.com/egalli64/scala-playground

  Functions - Write Your Own map Method
 */
package com.github.egalli64.scala3.b08

import scala.collection.mutable.ListBuffer

@main
def mapping(): Unit =
  /**
   * A generic mapping method
   *
   * @param f
   *   a generic function that transform each element of an A list to a B
   * @param xs
   *   a list of A
   * @tparam A
   *   the base type of the input list
   * @tparam B
   *   the base type of the output list
   * @return
   *   the transformed list
   */
  def map[A, B](f: A => B, xs: List[A]): List[B] =
    // each element of xs is mapped by f() in a new value in the resulting list
    for x <- xs yield f(x)

  // mapping functions for the HOF above
  def toSquareRoot(x: Int) = Math.sqrt(x)
  val toLength = (s: String) => s.length

  // Applying mapping to a list of integers
  val values = List(1, 2, 3, 4)
  println(s"$values to " + map(toSquareRoot, values))

  // Applying mapping to a list of strings
  val data = List("one", "two", "three", "four")
  println(s"$data to " + map(toLength, data))
