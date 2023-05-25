/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Composition and Inheritance - Defining parameterless methods
 */
package com.artima.scala5ed.ch10

@main
def s03parameterlessMethod(): Unit =
  abstract class Element:
    /**
     * parameterless method - preferred for pure field getter (with no parameter)
     *
     * It supports the _uniform access principle_
     *
     * @return
     *   a string vector
     */
    def contents: Vector[String]

    /**
     * It is easy to convert it from method (def) to accessible field (val)
     * @return
     *   the vector length
     */
    def height: Int = contents.length
    def width: Int = if height == 0 then 0 else contents(0).length
