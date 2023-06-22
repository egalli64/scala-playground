/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Pattern Matching - Sealed classes
 */
package com.artima.scala5ed.ch13

@main
def s5sealed(): Unit =
  /**
   * Sealed class: only subclass in the current file are accepted
   */
  sealed trait Expr
  case class Var(name: String) extends Expr
  case class Num(number: Double) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

  /**
   * Warning: match may not be exhaustive
   *
   * @param e
   *   an expression
   * @return
   *   its description
   */
  def describe(e: Expr): String = e match
    case Num(_) => "a number"
    case Var(_) => "a variable"

  val x = Var("x")
  println(describe(x))
  try
    val unOp = UnOp("-", x)
    println(describe(unOp))
  catch case me: MatchError => println("Buggy matcher, no case for " + me.getMessage())

  /**
   * Use the unchecked annotation to turn down the warning
   *
   * @param e
   *   an expression
   * @return
   *   its description
   */
  def uncheckedDescribe(e: Expr): String = (e: @unchecked) match
    case Num(_) => "a number"
    case Var(_) => "a variable"

  println(uncheckedDescribe(x))
  try
    val unOp = UnOp("-", x)
    println(uncheckedDescribe(unOp))
  catch case me: MatchError => println("No warning, but the exception is still here for " + me.getMessage())
