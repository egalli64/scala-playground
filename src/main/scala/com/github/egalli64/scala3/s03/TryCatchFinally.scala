/*
  https://docs.scala-lang.org/scala3/book/taste-control-structures.html
  https://github.com/egalli64/scala-playground

  Control structures: try catch finally
 */
package com.github.egalli64.scala3.s03

@main def tryCatchFinally(input: String): Unit =
  try
    val i: Int = input.toInt
    println(s"Value is $i")
  catch
    case nfe: NumberFormatException => println("Can't get Int. " + nfe.getMessage)
  finally
    println("done")