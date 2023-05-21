/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functions and Closures - Tail recursion
 */
package com.artima.scala5ed.ch08

import scala.annotation.tailrec

@main
def s10tail(): Unit =

  /**
   * A non-tail-recursive function
   *
   * @param x
   *   input value
   * @return
   *   an irrelevant result
   */
  def boom(x: Int): Int =
    if x == 0 then throw new Exception("boom!")
    else
      // _not_ tail recursive! The result of recursion is used by the caller to generate its result
      boom(x - 1) + 1

  try boom(3)
  catch case ex: Exception => ex.printStackTrace()

  /**
   * A tail-recursive function
   *
   * @param x
   *   input value
   * @return
   *   an irrelevant result
   */
  @tailrec
  def bang(x: Int): Int =
    if x == 0 then throw new Exception("bang!")
    else bang(x - 1)

  try bang(3)
  catch case ex: Exception => ex.printStackTrace()
