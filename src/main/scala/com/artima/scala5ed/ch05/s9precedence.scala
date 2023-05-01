/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Basic Types and Operations - Operator precedence and associativity
 */
package com.artima.scala5ed.ch05

@main
def s9precedence(): Unit =
  // * has a higher precedence than +
  println(s"2 + 2 * 7 is 16? ${2 + 2 * 7 == 16}")
  // parentheses to change the default order
  println(s"(2 + 2) * 7 is 28? ${(2 + 2) * 7 == 28}")

  // Precedence is based on the first character of the methods used in as operator
  // Exception: assignment operators (ending with "=" and not being <=, >=, ==, !=) have same priority of "="
  var x = 10
  val y = 2
  x *= y + 1 // same as x *= (y + 1)
  println(s"x is 10, y is 2, x *= y + 1 is $x")

  // The associativity of an operator in Scala is determined by its last character
  // Any method ending in ":" is invoked on its right operand, passing in the left operand
  // All the other ones are invoked on their left operand, passing in the right operand
  val a = 3
  val b = 2
  println(s"a * b is a.*(b) - left to right: ${a * b}")
  val l1 = List(1, 2)
  val l2 = List(3, 4)
  val l3 = l1 ::: l2
  println("l1:::l2 is l2.::: l1 - right to left: " + l3)
