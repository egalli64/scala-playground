/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - List patterns
 */
package com.artima.scala5ed.ch14

@main
def s05_patterns(): Unit =
  val fruits = List("apples", "oranges", "pears")
  println("Fruits: " + fruits)

  // match a list sized 3
  val List(a, b, c) = fruits
  println(s"a is $a, b is $b, c is $c")

  try
    val List(a0, b0) = fruits
    println(s"a0 is $a0, b0 is $b0")
  catch case me: MatchError => println("Can't extract values, " + me)

  // match a list sized 2+ - the annotation gets rid of warning
  val a1 :: b1 :: rest = fruits: @unchecked
  println(s"a1 is $a1, b1 is $b1, rest is $rest")

  /**
   * Insertion sort, with pattern matching
   *
   * @param xs
   *   list to be sorted
   * @return
   *   the sorted list
   */
  def sort(xs: List[Int]): List[Int] = xs match
    case Nil      => Nil
    case x :: xs1 => insert(x, sort(xs1))

  def insert(x: Int, xs: List[Int]): List[Int] = xs match
    case Nil     => List(x)
    case y :: ys => if x <= y then x :: xs else y :: insert(x, ys)

  val numbers = List(5, 2, 3, 1, 4)
  println("Numbers: " + numbers)
  println("Sorted numbers: " + sort(numbers))
