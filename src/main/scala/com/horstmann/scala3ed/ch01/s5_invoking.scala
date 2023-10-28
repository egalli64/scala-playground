/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  1. The Basics 5. More about Calling Methods
 */
package com.horstmann.scala3ed.ch01

@main
def s5_invoking(): Unit =
  println("Intersection between strings: " + "Hello".intersect("World"))
  // a parameterless method not modifying the object is called with no parenthesis
  println("Sorting a string: " + "Bonjour".sorted)

  // similar to Java static import, used here to import method of the singleton object math
  import scala.math.*

  println("Square root 2 is " + sqrt(2))
  println("2 ^ 4 is " + pow(2, 4))
  println("Minimum between 3 and Pi is " + min(3, Pi))

  // You don't have to use an import:
  println("Square root 2 is " + scala.math.sqrt(2))
  // the package scala can be omitted
  println("Square root 2 is " + math.sqrt(2))

  print("A (probably) prime number having 100 bit length ")
  // No static method in Scala - here a method on a companion object is called
  println(BigInt.probablePrime(100, scala.util.Random))
