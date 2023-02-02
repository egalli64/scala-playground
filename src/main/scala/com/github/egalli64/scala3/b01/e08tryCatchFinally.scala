/*
  https://docs.scala-lang.org/scala3/book/taste-control-structures.html
  https://github.com/egalli64/scala-playground

  Control structures: try catch finally
 */
package com.github.egalli64.scala3.b01

@main def tryCatchFinally(input: String): Unit =
  try
    val i: Int = input.toInt
    println(s"Value is $i")
  catch case exc: NumberFormatException => println("Can't get Int. " + exc.getMessage)
  finally println("done")
