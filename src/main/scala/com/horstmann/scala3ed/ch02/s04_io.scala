/*
Scala for the Impatient Third Edition - Cay S. Horstmann
Source code shown in the book
Download the zip file from: https://horstmann.com/scala/

https://github.com/egalli64/scala-playground

2. Control Structures and Functions
 4. Input and Output
 */
package com.horstmann.scala3ed.ch02

import scala.io.StdIn

@main
def s04_io() : Unit =
  val name = "Tom"

  // s-string
  println(s"Hello $name")
  // formatting in a f-string
  println(f"Formatting the name: <$name%5s>")

  print("Gimme an integer: ")
  try
    val x = StdIn.readInt()
    println(s"OK, $name, $x is a good value")
  catch case ex: NumberFormatException => println(ex.getClass.getName + " with message: " + ex.getMessage)
