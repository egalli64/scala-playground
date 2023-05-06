/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Built-in Control Structures - While loops
 */
package com.artima.scala5ed.ch07

import scala.io.StdIn.readLine

@main
def s2while(): Unit =
  /**
   * An imperative GCD calculator
   *
   * @param x
   *   a value
   * @param y
   *   another value
   * @return
   *   their GCD
   */
  def gcdLoop(x: Int, y: Int): Int =
    var a = x
    var b = y
    // "while" is _not_ an expression, is more an imperative programming tool
    while a != 0 do
      val temp = a
      a = b % a
      b = temp
    b

  val left = 42
  val right = 35
  println(s"GCD of $left and $right is " + gcdLoop(left, right))

  var i = 3
  var useless: Unit = while i > 0 do i -= 1
  println("'While' is a statement, it returns a Unit: " + useless)

  // do-while: execute the body then test if the last statement in it is true
  while
    print("Your input: ")
    val line = readLine()
    println(s"I have read: $line")
    line != ""
  do ()

  // reassignment of var returns a Unit! So, it is not transitive
  var x = 42
  useless = x = 12
  println(s"x is $x, a reassignment returns a Unit: $useless")
