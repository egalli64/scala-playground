/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  6. Objects and Enumeration
   4. The apply Method
 */
package com.horstmann.scala3ed.ch06

@main
def s4_apply(): Unit =
  class Person(val name: String, val age: Int)
  /*
    a companion object is implicitly created with an apply in it
    "constructor proxy method", sort of static factory method
    if a companion object is explicitly created, and an apply is provided, no implicit apply from the compiler
   */

  val tom = new Person("Tom", 42)
  println(s"A new person: ${tom.name}, ${tom.age}")

  val bob = Person.apply("Bob", 28)
  println(s"An applied person: ${bob.name}, ${bob.age}")

  val kim = Person("Kim", 35)
  println(s"An implicitly applied person: ${kim.name}, ${kim.age}")
