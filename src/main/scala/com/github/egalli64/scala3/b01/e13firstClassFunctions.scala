/*
  https://docs.scala-lang.org/scala3/book/taste-functions.html
  https://github.com/egalli64/scala-playground

  First-class functions
 */
package com.github.egalli64.scala3.b01

@main
def firstClass(): Unit =
  val l = (1 to 10).toList

  // passing a lambda to map() on a list - explicit
  println(l.map(i => i * 2))
  // passing a lambda to map() on a list - implicit
  println(l.map(_ * 2))

  // using a function instead of a lambda
  def doubler(x: Int): Int = x * 2
  println(l.map(doubler))

  // chain operations on a list
  println(l.filter(_ > 3).filter(_ % 2 == 0).map(_ * 10))
