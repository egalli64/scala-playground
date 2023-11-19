/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  8. Inheritance
   2. Overriding Methods
 */
package com.horstmann.scala3ed.ch08

@main
def s02_override(): Unit =
  class Person:
    var name = ""

    /**
     * A final method, no override for it
     *
     * @return
     *   a minimal object description
     */
    final def minimalDescription = s"Person name is $name"

    /**
     * Override Object.toString
     *
     * @return
     *   an object description
     */
    override def toString = s"${getClass.getName}[name=$name]"

  class Employee extends Person:
    var salary = 0.0

    /**
     * Override Person.toString
     *
     * @return
     *   the super toString enriched with Employee information
     */
    override def toString = s"${super.toString}[salary=$salary]"

    // won't compile, cannot override final member method
    // override def minimalDescription = ""

  val fred = Employee()
  fred.name = "Fred"
  fred.salary = 50000
  println(fred)
