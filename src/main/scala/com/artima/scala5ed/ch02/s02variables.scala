/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  First Steps in Scala - Define some variables
 */
package com.artima.scala5ed.ch02

@main
def s02variables(): Unit =
  // val is like a Java final variable
  // a string in Scala is a java.lang.String
  val msg = "Hello, world!"
  println(msg)

  // Type annotation follows the variable name and is normally inferred
  val msg2: java.lang.String = "Hello again, world!"
  println(msg2)

  // the package java.lang is automatically imported
  val msg3: String = "Hello yet again, world!"
  println(msg3)

  // won't compile: Reassignment to val
  // msg = "Goodbye cruel world!"

  // var is like the same in Java, the variable is not final
  var greeting = "Hello, world!"
  println(greeting)

  // a var can be reassigned
  greeting = "Leave me alone, world!"
  println(greeting)
