/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Scala’s Hierarchy - How primitives are implemented
 */
package com.artima.scala5ed.ch17

@main
def s2_primitives(): Unit =
  val x = "a string".substring(2)
  val y = "a string".substring(2)
  if x == y then println("In Scala, operator == works in a natural way")
  if x ne y then println("When reference equality is requires, use eq or ne")
