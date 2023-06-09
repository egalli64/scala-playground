/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Pattern Matching - A simple example
 */
package com.artima.scala5ed.ch13

@main
def s1example(): Unit =
  /*
    A hierarchy based on an empty trait
   */
  trait Expression
  case class Var(name: String) extends Expression
  case class Num(number: Double) extends Expression
  case class UnOp(operator: String, arg: Expression) extends Expression
  case class BinOp(operator: String, left: Expression, right: Expression) extends Expression

  val v = Var("x")
  println(s"$v has name ${v.name}")

  val opPlus = BinOp("+", Num(1), v)
  println(s"$opPlus has left ${opPlus.left}, its right is Var(\"x\")? ${opPlus.right == Var("x")}")

  val opMinus = opPlus.copy(operator = "-")
  println(opMinus)

  /*
    Pattern Matching
   */
  def simplifyTop(expr: Expression): Expression =
    expr match
      case UnOp("-", UnOp("-", e)) => e // Double negation
      case BinOp("+", e, Num(0))   => e // Adding zero
      case BinOp("*", e, Num(1))   => e // Multiplying by one
      case _                       => expr

  val doubleNegation = UnOp("-", UnOp("-", v))
  val simplifiedDoubleNegation = simplifyTop(doubleNegation)
  println(s"$doubleNegation simplified is $simplifiedDoubleNegation")

  val zeroAdded = BinOp("+", v, Num(0))
  val simplifiedZeroAdded = simplifyTop(zeroAdded)
  println(s"$zeroAdded simplified is $simplifiedZeroAdded")

  val multipliedByOne = BinOp("*", v, Num(1))
  val simplifiedMultipliedByOne = simplifyTop(multipliedByOne)
  println(s"$multipliedByOne simplified is $simplifiedMultipliedByOne")
