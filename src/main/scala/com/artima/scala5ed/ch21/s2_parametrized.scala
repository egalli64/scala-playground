/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Givens - Parameterized given types
 */
package com.artima.scala5ed.ch21

import scala.annotation.tailrec

@main
def s2_parametrized(): Unit =
  /*
  def sort[T](xs: List[T]): List[T] = if xs.isEmpty then Nil else insert(xs.head, sort(xs.tail))

  // won't compile: value <= is not a member of T, but could be made available as an extension method
  def insert[T](x: T, xs: List[T]): List[T] =
    if xs.isEmpty || x <= xs.head then x :: xs else xs.head :: insert(x, xs.tail)
   */

  /**
   * In this way, it works!
   *
   * @param xs
   *   the list to be sorted
   * @param lteq
   *   provided sort strategy
   * @tparam T
   *   the template parameter
   * @return
   *   the sorted list
   */
  def sort[T](xs: List[T])(lteq: (T, T) => Boolean): List[T] =
    if xs.isEmpty then Nil else insert(xs.head, sort(xs.tail)(lteq))(lteq)

  def insert[T](x: T, xs: List[T])(lteq: (T, T) => Boolean): List[T] =
    if xs.isEmpty || lteq(x, xs.head) then x :: xs else xs.head :: insert(x, xs.tail)(lteq)

  // for integers
  val x = sort(List(4, -10, 10))(_ <= _)
  println(x)

  // for strings
  val y = sort(List("cherry", "blackberry", "apple", "pear"))(_.compareTo(_) <= 0)
  println(y)

  /**
   * Use a trait as given to improve readability and functionality
   *
   * @tparam T
   *   the template parameter
   */
  trait Ord[T]:
    def compare(x: T, y: T): Int
    def lteq(x: T, y: T): Boolean = compare(x, y) < 1

  def sort2[T](xs: List[T])(using ord: Ord[T]): List[T] =
    if xs.isEmpty then Nil else insert2(xs.head, sort2(xs.tail))

  def insert2[T](x: T, xs: List[T])(using ord: Ord[T]): List[T] =
    if xs.isEmpty || ord.lteq(x, xs.head) then x :: xs else xs.head :: insert2(x, xs.tail)

  object Ord:
    given intOrd: Ord[Int] with
      def compare(x: Int, y: Int): Int = if x == y then 0 else if x > y then 1 else 1
    given stringOrd: Ord[String] with
      def compare(s: String, t: String): Int = s.compareTo(t)

  println(sort2(List(10, 4, -10)))
  println(sort2(List("cherry", "blackberry", "apple", "pear")))
