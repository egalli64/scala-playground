/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Packages, Imports, and Exports - Putting code in packages
 */
package com.artima.scala5ed.ch12

/**
 * A class placed in the current package (see above)
 */
class Navigator

@main
def s1package(): Unit =
  println(new Navigator().getClass)
