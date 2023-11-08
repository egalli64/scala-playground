/*
Scala for the Impatient Third Edition - Cay S. Horstmann
Source code shown in the book
Download the zip file from: https://horstmann.com/scala/

https://github.com/egalli64/scala-playground

2. Control Structures and Functions
 11. Functions without Parameters
 12. Lazy Values
 */
package com.horstmann.scala3ed.ch02

@main
def s11_no_arg(): Unit =
  val data = List("a", "b", "c")

  /**
   * A function with no parameters - no parentheses, suggesting idempotence
   *
   * @return
   *   the result
   */
  def myWords = data.mkString(",")
  println("Calling idempotent function: " + myWords)
  // won't compile with parentheses
  // println(myWords())

  // The call to mkString is eager, done at variable definition
  val myWords2 = data.mkString(",")
  println("Using a val: " + myWords2)

  /**
   * Another function with no parameters - with parentheses, suggesting no idempotence
   *
   * @return
   *   the result
   */
  def myWords3() = data.mkString(",")
  println("Calling (non-idempotent) function: " + myWords3())
  // won't compile without parentheses
  // println(words2)

  // the assignment is done the first time the variable is accessed
  lazy val myWords4 = data.mkString(",")
  println("Using (for the first time) a lazy val: " + myWords4)
