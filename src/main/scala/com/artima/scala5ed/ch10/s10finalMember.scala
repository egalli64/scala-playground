/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Composition and Inheritance - Declaring final members
 */
package com.artima.scala5ed.ch10

@main
def s10finalMember(): Unit =
  abstract class Element:
    def demo = "Element's implementation invoked"

  class VectorElement extends Element:
    final override def demo = "VectorElement's implementation invoked"

  class LineElement extends VectorElement {
    // won't compile - cannot override final member method
    // override def demo = "DemoLineElement's implementation invoked"
  }

  final class OtherElement extends Element:
    override def demo = "OtherElement's implementation invoked"

  // won't compile - illegal inheritance
  // class CannotBeDone extends OtherElement

  println(new VectorElement().demo)
  println(new LineElement().demo)
  println(new OtherElement().demo)
