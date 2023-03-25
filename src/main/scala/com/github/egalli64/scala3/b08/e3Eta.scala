/*
  https://docs.scala-lang.org/scala3/book/fun-eta-expansion.html
  https://github.com/egalli64/scala-playground

  Functions - Eta Expansion
 */
package com.github.egalli64.scala3.b08

@main
def eta(): Unit =
  /*
    Function and method are two different concept, even though in Scala 3 things are blurred
    Method should be part of a class - in Scala 3 also outside, as toplevel definition, or in an extension
    Definition is still quite different
   */
  def isEvenMethod(i: Int) = i % 2 == 0
  val isEvenFunction = (i: Int) => i % 2 == 0

  /*
    ETA expansion in Scala 3 let method be used when a function is expected
   */
  val values = List(1,2,3)
  println("Filter by function: " + values.filter(isEvenFunction))
  println("Filter by method: " + values.filter(isEvenMethod))
