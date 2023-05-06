/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Built-in Control Structures - If expressions
 */
package com.artima.scala5ed.ch07

@main
def s1if(args: String*): Unit =
  // decision, imperative style
  // 1: default value
  var filename = "default.txt"
  // 2: branching, correct the chosen value when required
  if args.nonEmpty then filename = args(0)
  // 3: use the variable
  println(filename)

  // same but using if-expression (same as the ternary operator ?:)
  // compact and we can use val instead of var
  val filename2 = if args.nonEmpty then args(0) else "default.txt"
  println(filename2)

  // if the filename is used just once, we can get rid of the variable
  println(if args.nonEmpty then args(0) else "default.txt")
