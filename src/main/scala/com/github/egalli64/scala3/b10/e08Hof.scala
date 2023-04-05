/*
  https://docs.scala-lang.org/scala3/book/collections-methods.html
  https://github.com/egalli64/scala-playground

  Collections Methods - Higher-order functions and lambdas
 */
package com.github.egalli64.scala3.b10

@main
def e08Hof(): Unit =
  val values = List(10, 20, 30, 40, 10)
  println("The given list: " + values)

  println("Filtering")
  println("Explicit: " + values.filter((i: Int) => i < 25))
  println("Implicit type: " + values.filter(i => i < 25))
  println("Implicit parameter: " + values.filter(_ < 25))

  println("Specialized filtering")
  println("dropWhile() less than 25: " + values.dropWhile(_ < 25))
  println("filterNot less tha 25: " + values.filterNot(_ < 25))
  println("find() more than 20 (first - Option): " + values.find(_ > 20))
  println("takeWhile() less than 30: " + values.takeWhile(_ < 30))

  println("HOFs accept lambdas, functions, methods")
  def doubler(i: Int) = i * 2
  println("Mapping by function")
  println("Explicit: " + values.map((i: Int) => doubler(i)))
  println("Implicit - method value (single parameter): " + values.map(doubler))

  println("Combining more HOFs")
  println(
    "Filter < 40, take while < 30, map * 10: "
      + values
        .filter(_ < 40)
        .takeWhile(_ < 30)
        .map(_ * 10)
  )
