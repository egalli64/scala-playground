/*
  https://docs.scala-lang.org/scala3/book/collections-methods.html
  https://github.com/egalli64/scala-playground

  Collections Methods - map() and filter()
 */
package com.github.egalli64.scala3.b10

@main
def e09mapFilter(): Unit =
  val oneToTen = (1 to 10).toList
  println("An int list: " + oneToTen)

  val names = List("adam", "brandy", "chris", "david")
  println("A string list: " + names)

  println("Map to double (explicit): " + oneToTen.map((i: Int) => i * 2))
  println("Map to double (implicit / single parameter): " + oneToTen.map(_ * 2))

  println("Map to capitalize: " + names.map(_.capitalize))
  println("Map to tuple: " + names.map(s => (s.length, s.capitalize)))
  println("Map to Map: " + names.map(s => (s.capitalize, s.length)).toMap)
  println("Map to boolean: " + oneToTen.map(_ < 5))

  println("Filter less than 5: " + oneToTen.filter(_ < 5))
  println("Filter even: " + oneToTen.filter(_ % 2 == 0))
  println("Filter shorter than 5 names: " + names.filter(_.length < 5))

  println("Filter less than 4 than map * 10: " + oneToTen.filter(_ < 4).map(_ * 10))
