/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 6 - Collections - Lecture 6.3 - Combinatorial Search Example
 */
package org.coursera.efpl.course1.week6

import scala.annotation.tailrec

@main
def lecture3(): Unit =
  // Set - no order, no duplicated
  val fruits = Set("apple", "banana", "pear")
  println(fruits)

  val numbers = (1 to 6).toSet
  println(numbers)

  // Set is an iterable, many common operations are available
  println("Mapped set to increase: " + numbers.map(_ + 1))
  println("Filtered set: " + fruits.filter(_.startsWith("app")))
  println("Is fruits non empty? " + fruits.nonEmpty)

  // fundamental operation on set is contains()
  println("Is banana in fruits? " + fruits.contains("banana"))

  // N-Queens problem - place queens on a board so that they don't threaten each other
  def queens(n: Int) =
    @tailrec
    def checks(col: Int, delta: Int, queens: List[Int]): Boolean = queens match
      case Nil => false
      case qCol :: others =>
        qCol == col // same column
        || (qCol - col).abs == delta // same diagonal
        || checks(col, delta + 1, others) // conflict with others

    def isSafe(col: Int, queens: List[Int]): Boolean = !checks(col, 1, queens)

    def placeQueens(k: Int): Set[List[Int]] =
      if k == 0 then Set(List())
      else
        for
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        yield col :: queens
    placeQueens(n)

  println("Queens 4: " + queens(4))
