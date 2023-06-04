/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Packages, Imports, and Exports - Implicit imports
 */
package com.artima.scala5ed.ch12

@main
def s4implicit(): Unit =
  // implicit import java.lang.*
  println(new String().getClass)
  // implicit import scala.*
  println(Int.getClass)
  // implicit import Predef.*
  try assert(false)
  catch case ex: AssertionError => println("Predef.assert() invoked: " + ex.getMessage)

  // Scala StringBuilder overshadow the Java one
  println(StringBuilder.getClass)
