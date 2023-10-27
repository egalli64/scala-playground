/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Assertions and Tests - Assertions
 */
package com.artima.scala5ed.ch25

import scala.util.Random

@main
def s1_assertion(): Unit =
  val check = Random().nextInt(2)

  try
    assert(check == 0)
    println("It is zero!")
  catch case ex: AssertionError => println("Expected zero, " + ex)
