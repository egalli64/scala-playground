/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Classes and Objects - Case classes
 */
package com.artima.scala5ed.ch04

@main
def s4case(): Unit =
  // Scala "case class" is close to Java record
  case class Person(name: String, age: Int)

  // implementation is done by the factory apply() in the case class companion object
  // arguments are stored in fields with the same names of the parameters
  val p = Person("Sally", 39)

  // Accessors are provided, named as the fields
  println(p.name)
  println(p.age)

  // A toString() override is generated
  println(p)

  // hashCode() and equals() are generated
  println(p == Person("Sally", 25))
  println(p == Person("Sally", 39))

  // Our definitions have higher priority than the compiler ones, we can add whatever we need
  case class MyPerson(name: String, age: Int):
    def appendToName(suffix: String): MyPerson = MyPerson(s"$name$suffix", age)

  object MyPerson:
    // Ensure non-empty name is capitalized
    def apply(name: String, age: Int): MyPerson =
      val capitalizedName =
        if name.nonEmpty then name.charAt(0).toUpper + name.substring(1)
        else throw IllegalArgumentException("Empty name")
      new MyPerson(capitalizedName, age)

  val q = MyPerson("sally", 42)
  println(q)

  val q2 = q.appendToName(" Smith")
  println(q2)
