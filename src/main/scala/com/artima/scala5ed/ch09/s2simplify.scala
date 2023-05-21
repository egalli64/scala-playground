/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Control Abstraction - Simplifying client code
 */
package com.artima.scala5ed.ch09

import scala.annotation.tailrec

@main
def s2simplify(): Unit =

  def containsNeg(numbers: List[Int]): Boolean =
    var found = false
    for num <- numbers do if num < 0 then found = true
    found

  print("Contains negative: ")
  print(containsNeg(List(1, 2, 3, 4)))
  println(", " + containsNeg(List(1, 2, -3, 4)))

  // more concise, using the HOF Iterable exists()
  def containsNeg2(numbers: List[Int]) = numbers.exists(_ < 0)
  print("Contains negative (HOF): ")
  print(containsNeg2(List(1, 2, 3, 4)))
  println(", " + containsNeg2(List(1, 2, -3, 4)))

  // exists() makes the _client_ code simpler

  // without exists()
  def containsOdd(numbers: List[Int]): Boolean =
    var found = false
    for num <- numbers do if num % 2 == 1 then found = true
    found

  print("Contains odd: ")
  print(containsOdd(List(2, 4, 6)))
  println(", " + containsOdd(List(1, 2, 4)))

  // just for fun: recursive version
  @tailrec
  def containsOddRec(numbers: List[Int]): Boolean = numbers match
    case Nil          => false
    case head :: tail => if head % 2 == 1 then true else containsOddRec(tail)

  print("Contains odd (recursive): ")
  print(containsOddRec(List(2, 3, 4)))
  println(", " + containsOddRec(List(0, 2, 4)))

  // with exists()
  def containsOdd2(numbers: List[Int]) = numbers.exists(_ % 2 == 1)
  print("Contains odd (HOF): ")
  print(containsOdd2(List(2, 3, 4)))
  println(", " + containsOdd2(List(0, 2, 4)))
