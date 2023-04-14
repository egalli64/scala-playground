/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  First Steps in Scala - Learn to use the Scala REPL
 */
package com.artima.scala5ed.ch02

@main
def s01repl(): Unit =
  def repl0() =
    // entering a line in the REPL, is like running a function
    // the result is assigned to a variable and printed
    println("Enter in Scala REPL: 1 + 2")
    1 + 2

  val res0: Int = repl0()
  println("Scala REPL answers: val res0: Int = " + res0)

  def repl1() =
    println("Enter: res0 * 3")
    res0 * 3

  val res1 = repl1()
  println("Output: val res1: Int = " + res1)
