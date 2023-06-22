/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Pattern Matching - Pattern overlaps
 */
package com.artima.scala5ed.ch13

import scala.annotation.tailrec

@main
def s4overlap(): Unit =
  println()

  trait Expression
  case class Var(name: String) extends Expression
  case class Num(number: Double) extends Expression
  case class UnOp(operator: String, arg: Expression) extends Expression
  case class BinOp(operator: String, left: Expression, right: Expression) extends Expression

  /**
   * Patterns are tried in the order in which they are written!
   *
   * @param expr
   *   an expression
   * @return
   *   the simplified expression
   */
  def simplifyAll(expr: Expression): Expression = expr match
    case UnOp("-", UnOp("-", e)) => simplifyAll(e) // '-' is its own inverse
    case BinOp("+", e, Num(0))   => simplifyAll(e) // ‘0' is a neutral element for ‘+'
    case BinOp("*", e, Num(1))   => simplifyAll(e) // ‘1' is a neutral element for ‘*'
    case UnOp(op, e)             => UnOp(op, simplifyAll(e))
    case BinOp(op, l, r)         => BinOp(op, simplifyAll(l), simplifyAll(r))
    case _                       => expr

  val unOp = UnOp("-", Num(42))
  val binOp = BinOp("*", unOp, Num(1))

  println(s"$binOp is simplified to " + simplifyAll(binOp))
