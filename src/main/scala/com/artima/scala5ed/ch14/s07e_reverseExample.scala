/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - Higher-order methods on class List
  A higher-order method takes one or more functions as arguments

  Example: List reversal using fold
 */
package com.artima.scala5ed.ch14

@main
def s07e_reverseExample(): Unit =
  val numbers = List(2, 4, 6, 8)
  println("A list: " + numbers)

  def reverseQuadratic[T](xs: List[T]): List[T] = xs match
    case Nil      => xs
    case x :: xs1 => reverseQuadratic(xs1) ::: List(x)

  println("Reversed (quadratic): " + reverseQuadratic(numbers))

  def reverseLeft[T](xs: List[T]) = xs.foldLeft(List[T]()) { (ys, y) => y :: ys }
  println("Reversed (foldLeft - linear): " + reverseQuadratic(numbers))
