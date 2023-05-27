/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Composition and Inheritance - Defining parametric fields
 */
package com.artima.scala5ed.ch10

@main
def s06parametricField(): Unit =
  /**
   * An abstract class
   */
  abstract class Element:
    def contents: Vector[String]
    def height: Int = contents.length
    def width: Int = if height == 0 then 0 else contents(0).length

  /**
   * Combine parameter and field in a single parametric field definition (could be val or var)
   *
   * @param contents
   *   is assigned to "this" contents
   */
  class VectorElement(val contents: Vector[String]) extends Element

  val elements: Element = VectorElement(Vector("a", "b", "c"))
  println(s"${elements.contents}: ${elements.width}, ${elements.height}")

  // base class
  class Cat:
    val dangerous = false

  // derived class
  class Tiger(
      // explicit override of public field
      override val dangerous: Boolean,
      // private extra field
      private var age: Int
  ) extends Cat

  val tom = Cat()
  println(tom.dangerous)

  val bob = Tiger(true, 6)
  println(s"${bob.dangerous}")
