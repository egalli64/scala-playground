/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Built-in Control Structures - Exception handling with try expressions
 */
package com.artima.scala5ed.ch07

import java.io.FileReader

@main
def s4exception(): Unit =
  // 1. throw
  def half(n: Int) =
    if n % 2 == 0 then n / 2
    else
      // "throw" is an expression returning Nothing - no difference between checked/unchecked exceptions
      throw new RuntimeException("n must be even")

  println(half(42))

  // 2. try-catch
  val x = 41
  try
    val result = half(x)
    println(s"Half of $x is $result")
  catch
    // catching in Scala is similar to pattern matching
    case ex: RuntimeException => println(s"Can't halve $x: " + ex.getMessage)

  // 3. try-finally
  val f1 = new FileReader("build.sbt")
  try
    println("Characters read from file: " + f1.read())
  finally
    // whatever happens in the try block, the file has to be closed
    f1.close()

  // 4. try-catch-finally expression
  var f2: FileReader = null // see Using for more robustness
  val result =
    try
      f2 = new FileReader("input.text")
      f2.read()
    catch case _: Exception => 0
    finally
      // do not use finally to yield a result, it would be confusing
      if f2 != null then f2.close()

  println("Byte read: " + result)
