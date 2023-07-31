/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Scala’s Hierarchy - Bottom types
 */
package com.artima.scala5ed.ch17

@main
def s3_bottom(): Unit =
  // Class Null is the type of the null reference

  // won't compile
  // val i: Int = null

  val s: String = null
  println("Object of class derived by AnyRef could be null: " + s)

  // Nothing is at the very bottom of the class hierarchy - it is for abnormal terminations

  /**
   * This function will not return normally
   *
   * @param message
   *   a message
   * @return
   *   nothing!
   */
  def error(message: String): Nothing =
    throw new RuntimeException(message)

  try error("Hello")
  catch case ex: RuntimeException => println("The call to error() failed with ... " + ex)

  /**
   * Being Nothing a subtype of every class in the hierarchy, it could be returned also here
   *
   * @param x
   *   a value
   * @param y
   *   another value
   * @return
   *   the division of x by y, or nothing!
   */
  def divide(x: Int, y: Int): Int =
    if y != 0 then x / y
    else sys.error("can't divide by zero")

  println("A good division: " + divide(7, 3))
  try println(divide(7, 0))
  catch case ex: RuntimeException => println("The call to divide() failed with ... " + ex)
