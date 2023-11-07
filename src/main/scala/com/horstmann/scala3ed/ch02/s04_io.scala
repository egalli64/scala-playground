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

  println(s"Hello $name")
  println(f"Hello $name%5s")

  print("Gimme an integer: ")
  try
    val x = StdIn.readInt()
    println(s"OK, $name, $x is a good value")
  catch case ex: NumberFormatException => println(ex.getMessage + " you get an exception of " + ex.getClass)
