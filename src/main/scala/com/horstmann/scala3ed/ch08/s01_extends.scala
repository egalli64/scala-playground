/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  8. Inheritance
   1. Extending a Class
 */
package com.horstmann.scala3ed.ch08

@main
def s01_extends(): Unit =
  class Person:
    var name = ""

  /**
   * Employee is-a Person
   */
  final class Employee extends Person:
    var salary = 0.0

    def description: String = s"An employee named $name with salary $salary"

  val fred = Employee()
  fred.name = "Fred"
  fred.salary = 50_000.0
  println(fred.description)

  // won't compile: Illegal inheritance from final class 'Employee'
  // class Sale extends Employee
