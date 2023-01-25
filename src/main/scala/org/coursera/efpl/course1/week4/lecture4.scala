/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 4 - Types and Pattern Matching - Lecture 4.4 - Enums
 */
package org.coursera.efpl.course1.week4

import java.time.DayOfWeek
import java.time.LocalDate

// Plain case class hierarchy improved by companion object
trait Expr1
object Expr1:
  case class Number(n: Int) extends Expr1
  case class Sum(e1: Expr1, e2: Expr1) extends Expr1
  case class Product(e1: Expr1, e2: Expr1) extends Expr1
  case class Var(name: String) extends Expr1

def show(e: Expr1): String = e match
  case Expr1.Number(n)       => n.toString
  case Expr1.Sum(e1, e2)     => s"${show(e1)} + ${show(e2)}"
  case Expr1.Product(e1, e2) => s"${showPar(e1)} * ${showPar(e2)}"
  case Expr1.Var(name)       => name

def showPar(e: Expr1): String = e match
  case e: Expr1.Sum => s"(${show(e)})"
  case _            => show(e)

// Enum for ADT - equivalent to the trait/object above
enum Expr2:
  case Number(n: Int)
  case Sum(e1: Expr2, e2: Expr2)
  case Product(e1: Expr2, e2: Expr2)
  case Var(name: String)

def show(e: Expr2): String = e match
  case Expr2.Number(n)       => n.toString
  case Expr2.Sum(e1, e2)     => s"${show(e1)} + ${show(e2)}"
  case Expr2.Product(e1, e2) => s"${showPar(e1)} * ${showPar(e2)}"
  case Expr2.Var(name)       => name

def showPar(e: Expr2): String = e match
  case e: Expr2.Sum => s"(${show(e)})"
  case _            => show(e)

// Simple enum
enum DayOfWeek:
  case Monday, Tuesday, Wednesday, Thrusday, Friday, Saturday, Sunday

def isWeekend(day: DayOfWeek) = day match
  case DayOfWeek.Saturday | DayOfWeek.Sunday => true
  case _                                     => false

// A richer enum
enum Direction(val dx: Int, val dy: Int):
  case Right extends Direction(0, 1)
  case Up extends Direction(1, 0)
  case Left extends Direction(0, -1)
  case Down extends Direction(-1, 0)

  // "values" is the array of elements associated to a simple enum, "ordinal" is its position
  def turnLeft = Direction.values((ordinal + 1) % 4)

// enum and ADT for Domain Modeling
enum Card:
  case Visa, Mastercard, AmEx

// notice that parametrized and simple cases could live together
enum PaymentMethod:
  case CreditCard(kind: Card, holder: String, number: Long, expire: LocalDate)
  case PayPal(email: String)
  case Cash

@main
def lecture4(): Unit =
  val exp1 = Expr1.Sum(Expr1.Product(Expr1.Number(2), Expr1.Var("x")), Expr1.Var("y"))
  println("Showing expression (1): " + show(exp1))

  val exp2 = Expr2.Sum(Expr2.Product(Expr2.Number(2), Expr2.Var("x")), Expr2.Var("y"))
  println("Showing expression (2): " + show(exp2))

  val day = DayOfWeek.Wednesday
  if (!isWeekend(day))
    println("Not weekend: " + day)

  val right = Direction.Right
  val up = right.turnLeft
  val v = (up.dx, up.dy)
  println(s"Directions: $right, $up, $v")
