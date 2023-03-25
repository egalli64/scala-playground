/*
  https://docs.scala-lang.org/scala3/book/fun-anonymous-functions.html
  https://github.com/egalli64/scala-playground

  Functions - Anonymous Functions / Lambda
 */
package com.github.egalli64.scala3.b08

@main
def lambda(): Unit =
  val values = List(1, 2, 3)

  /*
      lambda: block of code passed as argument to a higher-order function

      Here, each value of the current list (referred as _) is doubled and put to a new list
   */
  println(s"Doubling values in list $values:")

  // Explicit notations:
  println(values.map((x: Int) => x * 2))
  // Type inference, Int is deduced by the compiler
  // println(values.map((x) => x * 2))
  // Single parameter, no parenthesis required
  println(values.map(x => x * 2))
  // Using _ as placeholder for the unique parameter
  println(values.map(_ * 2))

  println(s"Printing each value in $values:")
  values.foreach((x: Int) => println(x))
  println("---")
  // values.foreach((x) => println(x + " "))
  // println("---")
  values.foreach(println(_))
  println("---")

  // Implicit parameter to argument matching - only for single parameter and plain argument passing
  values.foreach(println)
  println("---")
