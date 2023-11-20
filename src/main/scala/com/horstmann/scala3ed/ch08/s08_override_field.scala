/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  8. Inheritance
   8. Overriding Fields
 */
package com.horstmann.scala3ed.ch08

@main
def s08_override_field(): Unit =
  /**
   * Base class, has a name val field
   *
   * @param name
   *   the person name
   */
  class Person(val name: String):
    override def toString = s"${getClass.getName}[name=$name]"

  /**
   * Is-a Person
   *
   * @param codename
   *   the agent codename
   */
  class SecretAgent(codename: String) extends Person(codename):
    /**
     * A val can override another val
     */
    override val name = "secret"

  // a val can override a parameterless def, too
  // override val toString = "secret"

  /**
   * Base class, has an abstract def id
   */
  abstract class User:
    /**
     * Each user has an ID that is computed in some way
     *
     * @return
     *   the user id
     */
    def id: Int

  /**
   * Is-an User, override the def id with a val id, provided in the constructor
   *
   * @param id
   *   the used id, overridden
   */
  class Student(override val id: Int) extends User

  val fred = Person("Fred")
  println("Person name is " + fred.name)

  val james = SecretAgent("007")
  println("SecretAgent name is " + james.name)

  val u: User = Student(1729)
  println("Student id is " + u.id)
