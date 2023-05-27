/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Composition and Inheritance - Overriding methods and fields

  In Scala, fields and methods belong to the same namespace
  So, a field can override a parameterless method
  But, no field and method could have the same name in the same class
 */
package com.artima.scala5ed.ch10

@main
def s05override(): Unit =
  /**
   * An abstract class
   */
  abstract class Element:
    def contents: Vector[String]
    def height: Int = contents.length
    def width: Int = if height == 0 then 0 else contents(0).length

  /**
   * A derived class
   *
   * @param cs
   *   a string vector
   */
  class VectorElement(cs: Vector[String]) extends Element:
    /**
     * A val implementing an abstract method!
     */
    val contents: Vector[String] = cs

    // Not allowed: name clash between field and method
    // def contents = null

  val elements: VectorElement = VectorElement(Vector("a", "b", "c"))
  println(s"${elements.contents}: ${elements.width}, ${elements.height}")
