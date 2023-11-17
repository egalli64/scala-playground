/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  6. Objects and Enumeration
   5. Application Objects
 */
package com.horstmann.scala3ed.ch06

/**
 * An object providing a main method accepting an array of strings as argument makes the object
 * executable as a Scala program
 *
 * Compare it to a method annotated as @main
 */
object s5_main:
  def main(args: Array[String]): Unit =
    println(s"Hello, ${args.mkString(" ")}!")
