/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Basic Types and Operations - Relational and logical operations
 */
package com.artima.scala5ed.ch05

@main
def s6relationalLogic(): Unit =
  println(s"Greater than: ${1 > 2}")
  println(s"Less than: ${1 < 2}")
  println(s"Less or equal: ${1.0 <= 1.0}")
  println(s"Greater of equal: ${3.5f >= 3.6f}")
  println(s"Greater of equal (on chars): ${'a' >= 'A'}")

  val toBe = true
  println(s"to be: $toBe")
  println(s"not to be: ${!toBe}")
  println(s"to be || not to be: ${toBe || !toBe}")
  println(s"to be && not to be: ${toBe && !toBe}")

  // short circuit
  def salt() = { println("salt"); false }
  def pepper() = { println("pepper"); true }

  println("Pepper is true, so also salt is called")
  pepper() && salt()
  println("Shortcut: salt is false, so pepper is not called")
  salt() && pepper()
  println("No shortcut: salt is false, but pepper is called nonetheless")
  salt() & pepper()
