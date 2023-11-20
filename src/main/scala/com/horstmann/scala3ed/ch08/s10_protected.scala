/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  8. Inheritance
   10. Protected Fields and Methods
 */
package com.horstmann.scala3ed.ch08

@main
def s10_protected(): Unit =
  /**
   * A class with a protected field
   *
   * @param name
   *   Employee name
   * @param age
   *   Employee age
   * @param salary
   *   Employee salary
   */
  class Employee(name: String, age: Int, protected var salary: Double):
    override def toString = s"${getClass.getName}[name=$name,age=$age,salary=$salary]"

  class Manager(name: String, age: Int, salary: Double) extends Employee(name, age, salary):
    def setSalary(newSalary: Double): Unit =
      if newSalary > salary then salary = newSalary
      else println("A manager's salary can never decrease")

    def outranks(other: Manager): Boolean =
      salary > other.salary
      // won't compile, age isn't protected
      // if age > other.age then println("...")

  val fred = Manager("Fred", 42, 100000)
  println(fred)
  val wilma = Manager("Wilma", 39, 120000)
  println(wilma)

  // Won't compile, protected field is not accessible in the package
  // fred.salary = 110000
  fred.setSalary(110000)
  println(fred)
  wilma.setSalary(90000)

  println(wilma)
  println("Wilma outranks Fred? " + wilma.outranks(fred))
