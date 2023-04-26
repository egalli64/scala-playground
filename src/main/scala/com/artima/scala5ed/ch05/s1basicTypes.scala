/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Basic Types and Operations - Some basic types
 */
package com.artima.scala5ed.ch05

@main
def s1basicTypes(): Unit =
  // integral types
  println(s"$Byte range is [${Byte.MinValue}, ${Byte.MaxValue}]")
  println(s"$Short range is [${Short.MinValue}, ${Short.MaxValue}]")
  println(s"$Char range is [${Char.MinValue.toInt}, ${Char.MaxValue.toInt}]")
  println(s"$Int range is [${Int.MinValue}, ${Int.MaxValue}]")
  println(s"$Long range is [${Long.MinValue}, ${Long.MaxValue}]")

  // numeric types
  println(s"$Float range is [${Float.MinValue}, ${Float.MaxValue}]")
  println(s"$Double range is [${Double.MinValue}, ${Double.MaxValue}]")

  // Boolean
  println(s"$Boolean range is false or true")

  // String
  println("String is actually java.lang.String")
