/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  8. Inheritance
   6. Abstract Classes
 */
package com.horstmann.scala3ed.ch08

@main
def s06_abstract(): Unit =
  /**
   * An abstract class
   *
   * @param name
   *   the person name
   */
  abstract class Person(val name: String):
    /**
     * No body, means the method is abstract
     * @return
     */
    def id: Int

    override def toString = s"${getClass.getName} with name $name and id $id"

  /**
   * Since the class implements the super abstract methods, it is not abstract
   *
   * @param name
   *   the person name
   */
  class Employee(name: String) extends Person(name):
    /**
     * override keyword not required for implementing an abstract method
     *
     * @return
     *   the employee id
     */
    def id: Int = name.hashCode

  val e = Employee("Harry")
  println(e)
