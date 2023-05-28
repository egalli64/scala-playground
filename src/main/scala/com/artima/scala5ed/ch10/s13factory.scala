/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Composition and Inheritance - Defining a factory object
 */
package com.artima.scala5ed.ch10

@main
def s13factory(): Unit =
  /**
   * A factory object, centralized access to the hierarchy
   */
  object Element:
    def elem(contents: Vector[String]): Element = VectorElement(contents)
    def elem(chr: Char, width: Int, height: Int): Element = UniformElement(chr, width, height)
    def elem(line: String): Element = LineElement(line)

  import Element.elem

  abstract class Element:
    def contents: Vector[String]
    def width: Int = if height == 0 then 0 else contents(0).length
    def height: Int = contents.length
    def above(that: Element): Element = elem(this.contents ++ that.contents)
    def beside(that: Element): Element =
      elem(for (left, right) <- this.contents.zip(that.contents) yield left + right)
    override def toString: String = contents.mkString("\n")
  end Element

  class VectorElement(val contents: Vector[String]) extends Element

  class UniformElement(
      ch: Char,
      override val width: Int,
      override val height: Int
  ) extends Element:
    private val line = ch.toString * width
    def contents: Vector[String] = Vector.fill(height)(line)

  class LineElement(s: String) extends Element:
    val contents: Vector[String] = Vector(s)
    override def width: Int = s.length
    override def height = 1

  val el1 = elem(Vector("one", "two"))
  println("Element by vector:\n" + el1)
  val el2 = elem("three")
  println("Element by string: " + el2)
  val el3 = elem('x', 5, 3)
  println("Element by char and dimensions:\n" + el3)
  val el4 = el1.above(el2)
  println("Merge of an element above another:\n" + el4)
  val el5 = el4.beside(el3)
  println("Merge of an element beside another:\n" + el5)
