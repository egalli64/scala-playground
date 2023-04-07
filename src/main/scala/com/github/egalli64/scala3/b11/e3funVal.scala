/*
  https://docs.scala-lang.org/scala3/book/fp-functions-are-values.html
  https://github.com/egalli64/scala-playground

  Functional Programming - Functions Are Values
 */
package com.github.egalli64.scala3.b11

@main
def e3funVal(): Unit =
  /*
    Functions are values
   */
  val values = 1 to 10
  val doubler = (x: Int) => x * 2
  val lessThanFive = (x: Int) => x < 5

  println("Mapping values by doubler: " + values.map(doubler))
  println("Filtering values by lessThanFive: " + values.filter(lessThanFive))

  /*
    Anonymous functions are also known as lambdas
   */
  println("Mapping values by lambda: " + values.map(_ * 2))
  println("Filtering values by lambda: " + values.filter(_ < 5))

  println("Filtering and mapping: " + values.filter(_ < 5).map(_ * 2))

  /*
    Eta expansion: in a HOF we could use lambda, function, method
   */
  val names = List("bobby", "joe", "jennifer")
  println(names.map(_.toUpperCase))
  println(names.map(_.capitalize))
  println(names.map(_.length))

  val fruits = List("apple", "pear")
  println(fruits.map(_.toUpperCase))
  println(fruits.flatMap(_.toUpperCase))

  val numbers = List(5, 1, 3, 11, 7)
  println(numbers.map(_ * 2))
  println(numbers.filter(_ > 3))
  println(numbers.takeWhile(_ < 6))
  println(numbers.sortWith(_ < _))
  println(numbers.sortWith(_ > _))

  println(numbers.takeWhile(_ < 6).sortWith(_ < _))
