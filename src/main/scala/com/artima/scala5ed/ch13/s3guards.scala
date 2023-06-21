/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Pattern Matching - Pattern guards
 */
package com.artima.scala5ed.ch13

@main
def s3guards(): Unit =
  trait Expression
  case class Var(name: String) extends Expression
  case class Num(number: Double) extends Expression
  case class UnOp(operator: String, arg: Expression) extends Expression
  case class BinOp(operator: String, left: Expression, right: Expression) extends Expression

  /**
   * Sum of same operand is the operand multiplied by 2
   *
   * @param e an expression
   * @return the simplified expression - when possible
   */
  def simplifyAdd(e: Expression) = e match
      // a match could be better specified by "pattern guard"
      // here, match BinOp + only if the two operands are same
      case BinOp("+", x, y) if x == y => BinOp("*", x, Num(2))
      case _ => e

  val op = BinOp("+", Var("x"), Var("x"))
  println(s"$op simplified is " + simplifyAdd(op))
