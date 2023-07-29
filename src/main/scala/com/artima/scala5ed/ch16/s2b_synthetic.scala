/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Mutable Objects - Reassignable variables and properties

  getter and a setter without an associated field
 */
package com.artima.scala5ed.ch16

import scala.compiletime.uninitialized

@main
def s2b_synthetic(): Unit =
  class Thermometer:
    // the right zero value for its actual type is assigned to the field
    var celsius: Float = uninitialized

    // getter and setter for a non-existing field!
    def fahrenheit: Float = celsius * 9 / 5 + 32
    def fahrenheit_=(f: Float): Unit = celsius = (f - 32) * 5 / 9
    override def toString = s"$fahrenheit°F is $celsius°C"

  val t = Thermometer()
  t.celsius = 100
  println(t)
  t.fahrenheit = -40
  println(t)
