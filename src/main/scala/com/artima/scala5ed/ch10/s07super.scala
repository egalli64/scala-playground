/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Composition and Inheritance - Invoking superclass constructors
 */
package com.artima.scala5ed.ch10

@main
def s07super(): Unit =
  abstract class Element:
    def contents: Vector[String]
    def height: Int = contents.length
    def width: Int = if height == 0 then 0 else contents(0).length

  class VectorElement(val contents: Vector[String]) extends Element

  /**
   * After "extends" is the super constructor
   *
   * @param s
   *   a string
   */
  class LineElement(s: String) extends VectorElement(Vector(s)):
    override def width: Int = s.length
    override def height = 1

  val le = LineElement("hello")
  println(s"${le.contents}: ${le.height}, ${le.width}")
