/*
  https://docs.scala-lang.org/scala3/book/fp-immutable-values.html
  https://github.com/egalli64/scala-playground

  Functional Programming - Immutable Values

  In pure functional programming, only immutable values are used.
  All variables are "val"
  Only immutable collections classes are used
  Apply functions to existing collections to create new collection
 */
package com.github.egalli64.scala3.b11

@main
def e1immutable(): Unit =
  val names = List("jane", "jon", "mary", "joe")
  println("Names are: " + names)
  println("Capitalized names starting by 'j' are: " + names.filter(_(0) == 'j').map(_.capitalize))

  case class Person(firstName: String, lastName: String)
  val tom = Person("Tom", "Holz")
  println("Case class with constant fields are preferred: " + tom)

  val tom2 = tom.copy(lastName = "Hohenholzer")
  println("Instead of change an object, create a modified copy: " + tom2)
