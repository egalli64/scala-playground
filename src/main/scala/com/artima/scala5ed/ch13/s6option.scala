/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Pattern Matching - Pattern matching Options
 */
package com.artima.scala5ed.ch13

@main
def s6option(): Unit =
  /**
   * Match on option
   *
   * @param x
   *   an option
   * @return
   *   its content, or "?"
   */
  def show(x: Option[String]) = x match
    case Some(s) => s
    case None    => "?"

  val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

  println(show(capitals.get("France")))
  println(show(capitals.get("North Pole")))
