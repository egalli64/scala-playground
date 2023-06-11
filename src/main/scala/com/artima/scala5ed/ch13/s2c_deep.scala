/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Pattern Matching - Kinds of patterns - Deep matches
 */
package com.artima.scala5ed.ch13

@main
def s2c(): Unit =
  trait Expression
  case class Var(name: String) extends Expression
  case class Num(number: Double) extends Expression
  case class UnOp(operator: String, arg: Expression) extends Expression
  case class BinOp(operator: String, left: Expression, right: Expression) extends Expression

  /**
   * Deep match (three levels) on a constructor pattern
   *
   * Match the expression type - if a BinOp is detected, check its operator, that should be a +, and
   * its right expression, that should be a Num - if right is actually a Num, its value is checked,
   * and it should be zero.
   *
   * @param expression
   *   an expression
   * @return
   *   the expression description
   */
  def check(expression: Expression) = expression match
    case BinOp("+", e, Num(0)) => s"a deep match for $e"
    case _                     => "something else"

  assert(check(BinOp("+", Num(1), Num(0))) == "a deep match for Num(1.0)")

  /**
   * Deep match on a sequence
   *
   * It should be sized three, and its first element should be a zero
   *
   * @param seq
   *   a Int sequence
   * @return
   *   the sequence description
   */
  def checkIntSeqSizedThreeFirstZero(seq: Seq[Int]) = seq match
    case List(0, _, _) => "found it"
    case _             => "something else"

  assert(checkIntSeqSizedThreeFirstZero(List(0)) == "something else")
  assert(checkIntSeqSizedThreeFirstZero(List(0, 42, 12)) == "found it")

  /**
   * Deep match on a sequence, no requirement on its size
   *
   * @param seq
   *   a Int sequence
   * @return
   *   the sequence description
   * @return
   */
  def checkIntSeqFirstZero(seq: Seq[Int]) = seq match
    case List(0, _*) => "found it"
    case _           => "something else"

  assert(checkIntSeqFirstZero(List(0)) == "found it")
  assert(checkIntSeqFirstZero(List(0, 42, 12)) == "found it")

  /**
   * Deep match on a tuple
   *
   * @param obj
   *   anything will do
   * @return
   *   the object description
   */
  def checkSizedThreeTuple(obj: Any) = obj match
    case List(_*)  => "a list"
    case (a, b, c) => s"matched $a$b$c"
    case _         => "something else"

  assert(checkSizedThreeTuple(List(1, 2, 3)) == "a list")
  assert(checkSizedThreeTuple((1, 2, 3)) == "matched 123")
