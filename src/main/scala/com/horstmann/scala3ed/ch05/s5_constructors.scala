/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  5. Classes
   5. Auxiliary Constructors - besides the primary one
    They are named "this", first statement is a call to another constructor
 */
package com.horstmann.scala3ed.ch05

@main
def s5_constructors(): Unit =
  /**
   * A class with two auxiliary constructors
   */
  class Person:
    private var name = ""
    private var age = 0

    /**
     * An auxiliary constructor calling the primary constructor
     *
     * @param name
     *   the person name
     */
    def this(name: String) =
      this()
      this.name = name

    /**
     * Another auxiliary constructor, this one calling the previous auxiliary constructor
     *
     * @param name
     *   the person name
     * @param age
     *   the person age
     */
    def this(name: String, age: Int) =
      this(name)
      this.age = age

  val kim = Person()
  val tom = Person("Tom")
  val bob = Person("Bob", 42)
  println(s"$kim, $tom, and $bob")
