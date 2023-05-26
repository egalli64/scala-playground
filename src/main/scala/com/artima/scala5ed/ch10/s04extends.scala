/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Composition and Inheritance - Extending classes
 */
package com.artima.scala5ed.ch10

@main
def s04extends(): Unit =
  /**
   * An abstract class
   */
  abstract class Element:
    def contents: Vector[String]
    def height: Int = contents.length
    def width: Int = if height == 0 then 0 else contents(0).length

  /**
   * A concrete class extending an abstract class
   *
   * Without "extends" derivation from AnyRef would be assumed
   *
   * @param cs
   *   a string vector
   */
  class VectorElement(cs: Vector[String]) extends Element:
    /**
     * Implicit override (implementation) of an inherited abstract method
     *
     * Composition: VectorElement has a Vector[String]
     *
     * @return
     *   the contents
     */
    def contents: Vector[String] = cs

  // By Liskov: VectorElement could be used as an Element
  val elements: Element = VectorElement(Vector("a", "b", "c"))
  println(s"${elements.contents}: ${elements.width}, ${elements.height}")
