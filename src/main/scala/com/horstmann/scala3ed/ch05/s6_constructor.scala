/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  5. Classes
   6. The Primary Constructor - part of the class definition
 */
package com.horstmann.scala3ed.ch05

@main
def s6_constructor(): Unit =
  /**
   * A class defining its primary constructor with two fields, both val's
   *
   * @param name
   *   the person name, initialized the field name
   * @param age
   *   the person age, initialized the field age
   */
  class Person(val name: String, val age: Int):
    // each statement is executed as body of the primary constructor
    println("Just constructed another person")

    def description = s"$name is $age years old"

  val tom = Person("Tom", 42)
  println(tom.description)

  /**
   * A class defining its primary constructor with two fields, both val's. Having parameters with
   * default values, the need of auxiliary constructors is limited
   *
   * @param name
   *   the person name, initialized the field name
   * @param age
   *   the person age, initialized the field age
   */
  class Person2(val name: String = "", val age: Int = 0):
    // each statement is executed as body of the primary constructor
    println("Just constructed another person")

    def description = s"$name is $age years old"

  val bob = Person2("Bob")
  println(bob.description)

  /**
   * A class defining its primary constructor with no fields, just parameters
   *
   * @param firstName
   *   person first name
   * @param lastName
   *   person last name
   * @param age
   *   person age
   */
  class Person3(firstName: String, lastName: String, age: Int):
    val name: String = firstName + " " + lastName

    def description = s"$name is $age years old"

  val kim = Person3("Kim", "Biscuit", 28)
  println(kim.description)
  println(kim.name)

  // won't compile, "age" is not a Person3 field, it is just a constructor parameter
  // println(kim.age)

  /**
   * The Primary constructor could be private
   *
   * @param name
   *   the person name
   * @param id
   *   the person id
   */
  class Person4 private (val name: String, val id: Int):
    println("Person created with id " + id)
    def this(name: String) =
      this(name, 42)

  // won't compile, no public constructor matching arguments
  // val tim = Person4("Tim", 32)

  val jim = Person4("Jim")
  println(jim.name)
