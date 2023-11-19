/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  8. Inheritance
   7. Abstract Fields
 */
package com.horstmann.scala3ed.ch08

@main
def s07_abstract_field(): Unit =
  /**
   * An abstract class
   */
  abstract class Person:
    /**
     * An abstract field with an abstract getter and no setter
     */
    val id: Int

    /**
     * An abstract field with abstract getter and setter
     */
    var name: String

    override def toString = s"${getClass.getName} with name $name and id $id"

  /**
   * Employee is-a concrete Person
   *
   * @param id
   *   the person id
   */
  class Employee(val id: Int) extends Person:
    /**
     * name is concrete, too
     */
    var name = ""

  val wilma = Employee(1728)
  wilma.name = "Wilma"
  println(wilma)

  // fred is an instance of an anonymous Person subclass
  val fred = new Person() {
    val id = 1729
    var name = "Fred"
  }
  println(fred)
