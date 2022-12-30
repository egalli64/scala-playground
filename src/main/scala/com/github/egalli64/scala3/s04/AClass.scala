/*
  https://docs.scala-lang.org/scala3/book/taste-modeling.html
  https://github.com/egalli64/scala-playground

  OOP Domain Modeling: class
 */
package com.github.egalli64.scala3.s04

// a class - builtin canonical constructor
class Person(var firstName: String, var lastName: String):
  // a no-arg method
  def fullName = s"$firstName $lastName"

@main def aClass() : Unit =
  // a value object
  val p = Person("John", "Stephens")
  println(p.firstName)

  // variable members could be reassigned
  p.firstName += "ny"
  p.lastName = "Legend"
  println(p.fullName)
