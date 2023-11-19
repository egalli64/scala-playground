/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  8. Inheritance
   4. Superclass Construction - only the primary constructor can call the super constructor
 */
package com.horstmann.scala3ed.ch08

@main
def s04_super(): Unit =
  /**
   * Base class
   *
   * @param name
   *   person name
   * @param age
   *   person age
   */
  class Person(val name: String, val age: Int):
    override def toString: String =
      getClass.getName + "[name=" + name + ",age=" + age + "]"

  /**
   * Employee is-a Person
   *
   * @param name
   *   person name
   * @param age
   *   person age
   * @param salary
   *   employee salary
   */
  class Employee(name: String, age: Int, var salary: Double) extends Person(name, age):
    override def toString: String = super.toString + "[salary=" + salary + "]"

  import java.nio.charset.*
  import java.nio.file.*

  /**
   * A Scala class extending a Java class
   *
   * @param p
   *   the path
   * @param cs
   *   the charset
   */
  class ModernPrintWriter(p: Path, cs: Charset = StandardCharsets.UTF_8)
      extends java.io.PrintWriter(Files.newBufferedWriter(p, cs))

  val e = Employee("Fred", 42, 50000)
  val p = Files.createTempFile("temp", ".txt")
  val out = ModernPrintWriter(p)
  out.println(e)
  out.close()
  println(Files.readString(p))
  Files.delete(p)
