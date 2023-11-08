/*
Scala for the Impatient Third Edition - Cay S. Horstmann
Source code shown in the book
Download the zip file from: https://horstmann.com/scala/

https://github.com/egalli64/scala-playground

2. Control Structures and Functions
 10. The Main Function
 */
package com.horstmann.scala3ed.ch02

/**
 * the "main" annotation marks the function that starts the program
 */
@main
def s10_main(): Unit =
  println(43)

/**
 * a "main" function could accept a String vararg parameter
 *
 * @param args
 *   the user arguments as strings
 */
@main
def s10_main_2(args: String*): Unit =
  for arg <- args do println(arg)
  println("Done")

/**
 * Exception is thrown if called without matching arguments, the compiler uses parsers to convert
 * strings to commonly used standard types
 *
 * @param repetition
 *   an int parameter
 * @param name
 *   a string parameter
 */
@main
def s10_main_3(repetition: Int, name: String): Unit =
  println("Hello " * repetition + name)
