/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - Higher-order methods on class List
  A higher-order method takes one or more functions as arguments

  Folding lists: foldLeft and foldRight
 */
package com.artima.scala5ed.ch14

@main
def s07d(): Unit =
  val numbers = List(2, 4, 6, 8)
  val words = List("the", "quick", "brown", "fox")

  /*
    1. foldLeft
    the first parameter and the first element of the collection are applied to the binary operator
    then is the turn of the partial result and the next element, until the collection is consumed
   */
  def sumTo1K(xs: List[Int]): Int = xs.foldLeft(1_000)(_ + _)
  println("Adding the content of list to 1_000: " + sumTo1K(numbers))

  def multiplyTo1K(xs: List[Int]): Int = xs.foldLeft(1_000)(_ * _)
  println("Multiply 1_000 to each element of list: " + multiplyTo1K(numbers))

  def concat(xs: List[String]): String = xs.foldLeft("->")(_ + " " + _)
  println("Concatenating words " + concat(words))

  def concat2(xs: List[String]): String = xs.tail.foldLeft(xs.head)(_ + " " + _)
  println("Concatenating words: " + concat2(words))

  /*
    2. foldRight
    the first and second element of the collection are applied to the binary operator,
    until there is no next element, so the first parameter is used
   */
  def concatRight(xs: List[String]): String = xs.foldRight("<-")(_ + " " + _)
  println("Concatenating words: " + concatRight(words))

  println("Folding works fine also on empty collections: " + sumTo1K(Nil))
