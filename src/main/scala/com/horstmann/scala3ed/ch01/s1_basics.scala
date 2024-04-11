/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  1. The Basics
 */
package com.horstmann.scala3ed.ch01

@main
def s1_basics(): Unit =
  // "answer" is implicitly an integer (Int) and explicitly a constant (val)
  val answer = 8 * 5 + 2
  println("The answer is " + answer)

  // Won't compile - a val can't be reassigned
  // answer = 0

  // "answer" is implicitly an integer (Int) and explicitly a variable (var)
  var counter = 0
  println("The counter is " + counter)
  // OK, a var can change
  counter = 1
  println("Now the counter is " + counter)

  // "message" is explicitly a constant string
  val message: String = null
  println("A disappointing message: " + message)

  // "greeting" is explicitly a constant "any" - actually a string
  var greeting: Any = "Hello"
  println("A nicer 'any' (implicitly converted to string): " + greeting)

  greeting = 42
  println("A variable 'any' (implicitly converted to Int): " + greeting)

  // _Defining_ multiple variables
  val xMax, yMax = 100
  println(s"xMax is $xMax and yMax is $yMax, too!")
  // prefix and suffix are both strings, initialized with null
  val prefix, suffix: String = null
  println(s"prefix is $prefix and suffix is $suffix, too!")
