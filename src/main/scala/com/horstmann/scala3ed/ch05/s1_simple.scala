/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  5. Classes
   1. Simple Classes and Parameterless Methods
 */
package com.horstmann.scala3ed.ch05

@main
def s1_simple(): Unit =
  /**
   * Classes are public by default
   */
  class Counter:
    // field must be initialized
    private var value = 0

    // methods are public by default
    def increment(): Unit = value += 1
    def current: Int = value

  val counter = Counter()
  counter.increment()
  println("Current counter is " + counter.current)
