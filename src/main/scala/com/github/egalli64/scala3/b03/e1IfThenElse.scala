/*
  https://docs.scala-lang.org/scala3/book/control-structures.html
  https://github.com/egalli64/scala-playground

  The if/then/else construct
 */

package com.github.egalli64.scala3.b03

import scala.util.Random

@main
def ifThenElse(): Unit =
  val x = Random.nextInt(2)

  // if
  if x == 1 then println("(if /1) Simple if for one: " + x)

  // if block
  if x == 0 then
    println("(if /2) Simple if for zero")
    println("In a python-style block")
  end if // optional "end-if"

  // if / else
  if x == 0 then println("(if / else) if zero ...") else println("(if / else) otherwise ...")

  // if / else if / else
  if x == 0 then println("(if / else if / else) if zero ...")
  else if x == 1 then println("(if / else if / else) else if one ...")
  else println("(if / else if / else) tertium non datur")

  // if expression
  val message = if x == 0 then "zero" else "one"
  println("Expression if: " + message)

  /**
   * Using if expression in a method
   *
   * @param first
   *   a value
   * @param second
   *   another value
   * @return
   *   a string
   */
  def compare(first: Int, second: Int): String =
    if first > second then "First is bigger"
    else if first < second then "Second is bigger"
    else "Equality"

  val y = Random.nextInt(2)
  println("Comparing two values by if-expression: " + compare(x, y))
