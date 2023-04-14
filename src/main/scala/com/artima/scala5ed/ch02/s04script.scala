/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  First Steps in Scala - Write some Scala scripts
 */
package com.artima.scala5ed.ch02

/**
 * The function annotated as main is executed when the file is run by Scala
 */
// @main def m(): Unit = println("Hello, world, from a script!")

/**
 * More similar to Java main method
 *
 * @param args is called a repeated parameter
 */
@main def m(args: String*): Unit =
  // Say hello to the first argument - if no arg is passed, this script crashes!
  println("Hello, " + args(0) + "!")
