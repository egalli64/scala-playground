/*
  https://docs.scala-lang.org/scala3/book/collections-classes.html
  https://github.com/egalli64/scala-playground

  Collections Types - Vector
 */
package com.github.egalli64.scala3.b10

@main
def e02Vector(): Unit =
  /*
    Vector is an indexed immutable sequence

    Random access in constant time
   */
  val numbers = Vector(1, 2, 3, 4, 5)
  println("Numbers: " + numbers)

  val names = Vector("Tom", "Bob")
  println("Names: " + names)

  case class Person(name: String)
  val people = Vector(
    Person("Bert"),
    Person("Ernie"),
    Person("Grover")
  )
  println("People: " + people)

  // new vector by prepending +: / ++:, appending :+ / :++, concatenating ++ (same as prepending)
  // both prepending and appending have the same high performance
  val names2 = "Mik" +: names
  println("Prepending a name: " + names2)

  val names3 = names ++: names2
  println("Prepending names (point of view of the right operand): " + names3)

  val numbers2 = numbers :+ 6
  println("Appending a number: " + numbers2)

  val numbers3 = numbers :++ numbers2
  println("Appending numbers (point of view of the left operand): " + numbers3)

  // looping on a vector
  for name <- names do println(name)
