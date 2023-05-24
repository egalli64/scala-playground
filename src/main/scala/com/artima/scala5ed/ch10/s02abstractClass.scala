/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Composition and Inheritance - Abstract classes
 */
package com.artima.scala5ed.ch10

@main
def s02abstractClass(): Unit =
  /**
   * An abstract class
   */
  abstract class Element:
    /**
     * The declaration of an (implicitly) abstract method
     *
     * @return
     *   a string vector
     */
    def contents: Vector[String]

  // won't compile
  // new Element
