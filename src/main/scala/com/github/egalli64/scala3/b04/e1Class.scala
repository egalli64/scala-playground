/*
  https://docs.scala-lang.org/scala3/book/domain-modeling-tools.html
  https://github.com/egalli64/scala-playground

  Domain Modeling - Tools - Class
 */
package com.github.egalli64.scala3.b04

import java.time.LocalDate

/**
 * 1: Class as a template for the creation of object instances
 *
 * The primary constructor is merged with the class definition.
 *
 * Being declared as "var" the fields are mutable. For immutable a field use "val" (or case class).
 *
 * @param name
 *   the person name
 * @param vocation
 *   the person vocation
 */
class Person(var name: String, var vocation: String)

/**
 * 2: Fields and methods
 *
 * The body of the class acts as second initialization step for an object.
 *
 * @param firstName
 *   the person first name
 * @param lastName
 *   the person last name
 */
class Person2(var firstName: String, var lastName: String):
  println("Person2 initialization begins")
  // an extra field - being "val" can't be reassigned
  val fullName: String = firstName + " " + lastName

  // a class method
  def printFullName(): Unit =
    // access the `fullName` field, which is created above
    println(fullName)

  printFullName()
  println("Person2 initialization ends")

/**
 * 3: Default parameters, when an argument is not passed, its default value will be used
 *
 * When overriding a method, is mandatory flag it with the override keyword
 *
 * @param timeout
 *   the timeout, in ms
 * @param linger
 *   the linger time, in ms
 */
class Socket(val timeout: Int = 5_000, val linger: Int = 5_000):
  override def toString = s"timeout: $timeout, linger: $linger"

/**
 * 4: Auxiliary constructors
 *
 * "this" is used to define other constructors and to call internally another constructor
 *
 * By convention, private field names are prefixed with an underscore
 *
 * @param name
 *   student name
 * @param govtId
 *   official id
 */
class Student(var name: String, var govtId: String):
  private var _applicationDate: Option[LocalDate] = None
  private var _studentId: Int = 0

  // [2] a constructor for when the student has completed their application
  def this(name: String, govtId: String, applicationDate: LocalDate) =
    this(name, govtId)
    _applicationDate = Some(applicationDate)

  // [3] a constructor for when the student is approved and now has a student id
  def this(name: String, govtId: String, studentId: Int) =
    this(name, govtId)
    _studentId = studentId

  override def toString: String = s"$name $govtId $_applicationDate $_studentId"

@main
def classes(): Unit =
  /**
   * 1: Instancing an object does not require the keyword "new"
   */
  val p = Person("Bob", "Coder")
  println(s"Name: ${p.name}, vocation: ${p.vocation}")

  // "new" is not a mistake, but can be left out
  val pn = new Person("Bobby", "Bus driver")
  println(s"Name: ${pn.name}, vocation: ${pn.vocation}")

  // Being name defined as "var", could be reassigned to another string
  p.name = "Robert"
  println(s"Renamed: ${p.name}")

  /**
   * 2: The primary constructor sets an extra field and a method
   */
  val p2 = Person2("Bill", "Smith")
  // changing firstName does not affect fullName!
  p2.firstName = "William"
  // won't compile - a "val" can't be reassigned
  // p2.fullName = "Tom"
  print("Full name: ")
  p2.printFullName()
  println(s"First name: ${p2.firstName}, last name: ${p2.lastName}")

  /**
   * 3: Default value for arguments - notice the call by-name parameter feature
   */
  // timeout: 5000, linger: 5000
  println(Socket())

  // timeout: 2500, linger: 5000
  println(Socket(2_500))

  // timeout: 10000, linger: 10000
  println(Socket(10_000, 10_000))

  // timeout: 10000, linger: 5000
  println(Socket(timeout = 10_000))

  // timeout: 5000, linger: 10000
  println(Socket(linger = 10_000))

  /**
   * 4: Auxiliary constructors
   */
  println(Student("Mary", "123"))
  println(Student("Mary", "123", LocalDate.now))
  println(Student("Mary", "123", 456))
