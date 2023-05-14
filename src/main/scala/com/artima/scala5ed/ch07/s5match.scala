/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Built-in Control Structures - Match expressions
 */
package com.artima.scala5ed.ch07

@main
def s5match(args: String*): Unit =
  // use match to select an alternative by patterns
  val firstArg = if args.nonEmpty then args(0) else ""

  // 1. a simple match (on String)
  firstArg match
    case "salt"  => println("pepper")
    case "chips" => println("salsa")
    case "eggs"  => println("bacon")
    // underscore is a placeholder for unknown values
    case _ => println("huh?")

  // 2. match expression
  val friend = firstArg match
    case "salt"  => "pepper"
    case "chips" => "salsa"
    case "eggs"  => "bacon"
    case _       => "huh?"
  println(friend)
