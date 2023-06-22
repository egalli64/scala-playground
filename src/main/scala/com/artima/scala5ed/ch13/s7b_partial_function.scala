/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Pattern Matching - Patterns everywhere - Case sequences as partial functions

  A case sequence is a more general function literal
 */
package com.artima.scala5ed.ch13

@main
def s7b_pf(): Unit =
  /**
   * a case sequence acting as anonymous function
   */
  val withDefault: Option[Int] => Int =
    case Some(x) => x
    case None    => 0

  println(withDefault(Some(10)))
  println(withDefault(None))

  /**
   * Implicit partial function Warning: match may not be exhaustive
   */
  val secondRaw: List[Int] => Int =
    case x :: y :: _ => y

  println("Second is: " + secondRaw(List(5, 6, 7)))

  try secondRaw(List())
  catch case me: MatchError => println("Missing match for " + me.getMessage())

  /**
   * Partial Function
   *
   * isDefinedAt() checks the pattern without running the code
   */
  val second: PartialFunction[List[Int], Int] =
    case x :: y :: _ => y

  val goodList = List(5, 6, 7)
  if (second.isDefinedAt(goodList))
    println("Second is: " + second(goodList))

  val badList = List(5)
  if (!second.isDefinedAt(badList))
    println(s"Can't get second from $badList")
