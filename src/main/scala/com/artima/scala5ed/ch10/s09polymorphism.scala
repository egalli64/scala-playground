/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Composition and Inheritance - Polymorphism and dynamic binding
 */
package com.artima.scala5ed.ch10

@main
def s09polymorphism(): Unit =
  abstract class Element:
    def contents: Vector[String]
    def height: Int = contents.length
    def width: Int = if height == 0 then 0 else contents(0).length

  /**
   * Extends Element
   *
   * @param ch
   *   a character
   * @param width
   *   override the original method
   * @param height
   *   override the original method
   */
  class UniformElement(
      ch: Char,
      override val width: Int,
      override val height: Int
  ) extends Element:
    // add a field
    private val line = ch.toString * width
    // implement the declared method (override keyword not required in this case)
    def contents: Vector[String] = Vector.fill(height)(line)

  val ue = UniformElement('x', 2, 3)
  println(ue.contents)

  // simplified hierarchy example
  abstract class DemoElement:
    def demo = "DemoElement's implementation invoked"

  class DemoVectorElement extends DemoElement:
    override def demo = "DemoVectorElement's implementation invoked"

  class DemoLineElement extends DemoVectorElement:
    override def demo = "DemoLineElement's implementation invoked"

  /**
   * No override of demo - the inherited one is invoked at runtime
   */
  class DemoUniformElement extends DemoElement

  def invokeDemo(e: DemoElement) = e.demo

  println(invokeDemo(new DemoVectorElement))
  println(invokeDemo(new DemoLineElement))
  println(invokeDemo(new DemoUniformElement))
