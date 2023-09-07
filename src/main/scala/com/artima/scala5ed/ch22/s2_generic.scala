/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Extension Methods - Generic extensions
 */
package com.artima.scala5ed.ch22

@main
def s2_generic(): Unit =
  /**
   * List.head throws a NoSuchElementException when called on empty
   */
  try println(List.empty.head)
  catch case ex: NoSuchElementException => println(ex)

  /**
   * List.headOption return an Option, does not throw exceptions
   */
  println("headOption: " + List.empty.headOption)

  /**
   * List.tail throws an UnsupportedOperationException when called on empty
   */
  try println(List.empty.tail)
  catch case ex: UnsupportedOperationException => println(ex)

  /**
   * There is no List.tailOption, but we can provide it by extension!
   */
  extension [T](xs: List[T])
    def tailOption: Option[List[T]] = if xs.nonEmpty then Some(xs.tail) else None

  println("tailOption (by extension): " + List.empty.tailOption)
