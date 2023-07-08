/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - First-order methods on class List
  A first-order method does not take any function as argument

  Example: Merge sort
 */
package com.artima.scala5ed.ch14

@main
def s06f(): Unit =
  /**
   * Mergesort
   *
   * @param ord
   *   the ordering function, true if two parameters are ordered
   * @param xs
   *   the list to sort
   * @tparam T
   *   type of list element
   * @return
   *   a sorted copy of the original list
   */
  def mergesort[T](ord: (T, T) => Boolean)(xs: List[T]): List[T] =
    /**
     * Merge two lists, assumed to be ordered
     *
     * @param xs
     *   a list
     * @param ys
     *   another list
     * @return
     *   the merge
     */
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match
      case (Nil, _)             => ys
      case (_, Nil)             => xs
      case (x :: xs1, y :: ys1) => if ord(x, y) then x :: merge(xs1, ys) else y :: merge(xs, ys1)

    val n = xs.length / 2
    if n == 0 then xs
    else
      val (ys, zs) = xs.splitAt(n)
      merge(mergesort(ord)(ys), mergesort(ord)(zs))

  // smoke test
  val originalValues = List(5, 7, 1, 3)
  val sortedValues = mergesort((x: Int, y: Int) => x < y)(originalValues)
  println(s"From $originalValues to $sortedValues")

  // currying: intSort has type List[Int] => List[Int]
  val intSort = mergesort((x: Int, y: Int) => x < y)

  val mixedIntegers = List(4, 1, 9, 0, 5, 8, 3, 6, 2, 7)
  val result = intSort(mixedIntegers)
  println(s"From $mixedIntegers to $result")
