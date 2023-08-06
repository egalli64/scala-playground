/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Scala’s Hierarchy - Union types
 */
package com.artima.scala5ed.ch17

@main
def s6_union(): Unit =
  /**
   * Flexibility from union type
   *
   * @param msg
   *   union type, could be Int or String
   * @return
   *   an error message
   */
  def errorMessage(msg: Int | String): String =
    msg match
      case n: Int    => s"Error number: ${n.abs}"
      case s: String => s + "!"

  println(errorMessage(42))
  println(errorMessage("Something unexpected"))
