/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 4 - Types and Pattern Matching - Lecture 4.2 - Pattern Matching
 */
package org.coursera.efpl.course1.week4

// A case class hierarchy
trait Expression
case class Number(n: Int) extends Expression
case class Sum(e1: Expression, e2: Expression) extends Expression
case class Product(e1: Expression, e2: Expression) extends Expression
case class Var(name: String) extends Expression

def eval(e: Expression): Int = e match
  case Number(n)       => n
  case Sum(e1, e2)     => eval(e1) + eval(e2)
  case Product(e1, e2) => eval(e1) * eval(e2)

def show(e: Expression): String = e match
  case Number(n)       => n.toString
  case Sum(e1, e2)     => s"${show(e1)} + ${show(e2)}"
  case Product(e1, e2) => s"${showPar(e1)} * ${showPar(e2)}"
  case Var(name)       => name

def showPar(e: Expression): String = e match
  case e: Sum => s"(${show(e)})"
  case _      => show(e)

@main
def lecture2(): Unit =
  val e1 = Sum(Number(1), Number(1))
  println("Expression evaluated to: " + eval(e1))
  println("Showing expression: " + show(e1))

  val e2 = Sum(Product(Number(2), Var("x")), Var("y"))
  println("Showing expression: " + show(e2))

  val e3 = Product(Sum(Number(2), Var("x")), Var("y"))
  println("Showing expression: " + show(e3))
