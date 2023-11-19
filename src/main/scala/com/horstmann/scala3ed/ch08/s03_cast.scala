/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  8. Inheritance
   3. Type Checks and Casts
 */
package com.horstmann.scala3ed.ch08

import scala.util.Random

@main
def s03_cast(): Unit =
  class Person:
    var name = ""
    override def toString: String = getClass.getName + "[name=" + name + "]"

  class Employee extends Person:
    var salary = 0.0
    override def toString: String = super.toString + "[salary=" + salary + "]"

  class Manager extends Employee

  // generated randomly an object in the Person hierarchy
  val p = Random.nextInt(3) match
    case 0 => new Person
    case 1 => new Employee
    case _ => new Manager

  p.name = "Tom"
  println(p)

  // protected cast - however, pattern matching is the preferred Scala way
  if p.isInstanceOf[Employee] then
    val s = p.asInstanceOf[Employee] // s has type Employee
    println(s"Being an employee, we can set salary for ${s.name}")
    s.salary = 50000

  // direct check of the object class (meh)
  if p.getClass == classOf[Employee] then println("It's an Employee instance")

  // preferred way, pattern matching
  p match
    case x: Employee => println(s"${x.name} is-an employee with salary ${x.salary}")
    case _           => println(s"${p.name} is not an employee")
