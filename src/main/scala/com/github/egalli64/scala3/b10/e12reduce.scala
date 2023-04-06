/*
  https://docs.scala-lang.org/scala3/book/collections-methods.html
  https://github.com/egalli64/scala-playground

  Collections Methods - reduce()
 */

package com.github.egalli64.scala3.b10

@main
def e12reduce(): Unit =
  // a reducing function
  def add(x: Int, y: Int): Int =
    val result = x + y
    println(s"received $x and $y, their sum is $result")
    result

  // a sequence
  val data = 1 to 5

  // reduce a sequence
  val x = data.reduce(add)
  println(s"The reduction of sequence [$data] by add() leads to $x")

  println("Same, using a lambda: " + data.reduce(_ + _))
  println("Same, using the method sum(): " + data.sum)
