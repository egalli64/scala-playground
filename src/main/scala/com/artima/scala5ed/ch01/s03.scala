/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  A Scalable Language - Why Scala?
 */
package com.artima.scala5ed.ch01

@main
def s03(): Unit =
  // Concise: class definition with constructor - and toString() override
  class MyClass(index: Int, name: String):
    override def toString: String = s"{$index, $name}"

  val x = MyClass(42, "Tom")
  println(x)

  // High level
  val s = "a string with an Uppercase letter in it"
  println("Is there an uppercase letter in the string? " + s.exists(_.isUpper))
