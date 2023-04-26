/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Classes and Objects - A Scala application
 */
package com.artima.scala5ed.ch04

// Any standalone object with a main method of the proper signature is an entry point into an application
object s5app:
  def main(args: Array[String]): Unit =
    for i <- args.indices do println(i + ": " + args(i))
