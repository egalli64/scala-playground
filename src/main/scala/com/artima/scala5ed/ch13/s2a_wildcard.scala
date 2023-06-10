/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Pattern Matching - Kinds of patterns - Wildcard
 */
package com.artima.scala5ed.ch13

@main
def s2a(): Unit =
  trait Expression
  case class Var(name: String) extends Expression
  case class Num(number: Double) extends Expression
  case class UnOp(operator: String, arg: Expression) extends Expression
  case class BinOp(operator: String, left: Expression, right: Expression) extends Expression

  /*
    The wildcard pattern _ matches anything, used also as "don't care"
   */
  def check(expr: Expression): Unit = expr match
    case BinOp(op, left, right) => println(s"Binary operator $op on $left and $right")
    case UnOp(_, _)             => println(s"$expr is an unary operator")
    case _                      => println(s"$expr is an expression")

  check(Num(42))
  check(UnOp("-", Num(12)))
  check(BinOp("+", Num(21), Num(12)))
