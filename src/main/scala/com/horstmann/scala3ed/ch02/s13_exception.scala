/*
Scala for the Impatient Third Edition - Cay S. Horstmann
Source code shown in the book
Download the zip file from: https://horstmann.com/scala/

https://github.com/egalli64/scala-playground

2. Control Structures and Functions
 13. Exceptions

 */
package com.horstmann.scala3ed.ch02

@main
def s13_exception(): Unit =
  /**
   * A function returning Nothing
   *
   * @return
   *   Nothing, an exception is always thrown
   */
  def thrower(): Nothing = throw IllegalStateException("no one should call this function!")

  try thrower()
  catch case ex: IllegalStateException => println(ex.getMessage)

  /**
   * A function that could return Nothing, throwing an exception
   *
   * @param x
   *   a parameter
   * @return
   *   a Double, or Nothing (being a subtype of any class, Nothing is (also) a Double)
   */
  def square(x: Double): Double =
    if x >= 0 then math.sqrt(x)
    else throw IllegalArgumentException("x should not be negative")

  for value <- List(49, -23) do
    try println(square(value))
    catch case ex: IllegalArgumentException => println(ex.getMessage)
    finally println(s"Cleanup after calling square($value)")
