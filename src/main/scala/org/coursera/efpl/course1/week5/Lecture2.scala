/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 5 - Lists - Lecture 5.2 - Tuples and Generic Methods
 */
package org.coursera.efpl.course1.week5

/**
 * Split a list in two
 *
 * @param xs
 *   the input list
 * @param n
 *   the pivot for splitting
 * @tparam T
 *   the parameter type
 * @return
 *   the couple of resulting lists
 */
def splitAt[T](xs: List[T], n: Int) = (xs.take(n), xs.drop(n))

/**
 * Merge two already sorted lists
 *
 * @param xs
 *   first sorted list
 * @param ys
 *   second sorted list
 * @return
 *   the two lists merged
 */
def iMerge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match
  case (Nil, ys) => ys
  case (xs, Nil) => xs
  case (x :: xs1, y :: ys1) =>
    if x < y then x :: iMerge(xs1, ys)
    else y :: iMerge(xs, ys1)

/**
 * Sort a list of Int by merging
 *
 * If the list is empty or a singleton, we are done. Otherwise split it, call recursively mergeSort
 * on them, then merge the result
 *
 * @param xs
 *   a list
 * @return
 *   the sorted list
 */
def mSort(xs: List[Int]): List[Int] =
  val n = xs.size / 2
  if n == 0 then xs
  else
    val (left, right) = splitAt(xs, n)
    iMerge(mSort(left), mSort(right))

/**
 * Parametrized merge sort, require the caller to specify how the element should be ordered
 *
 * @param xs
 *   the input list
 * @param ord
 *   predicate check if the order for the couple is correct
 * @tparam T
 *   parametric type
 * @return
 *   the sorted list
 */
def mergeSort[T](xs: List[T])(ord: (T, T) => Boolean): List[T] =
  def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match
    case (Nil, _) => ys
    case (_, Nil) => xs
    case (x :: xs1, y :: ys1) =>
      if ord(x, y) then x :: merge(xs1, ys)
      else y :: merge(xs, ys1)

  val n = xs.size / 2
  if n == 0 then xs
  else
    val (left, right) = splitAt(xs, n)
    merge(mergeSort(left)(ord), mergeSort(right)(ord))

@main
def lecture2(): Unit =
  // The Pair (or Tuple) type, e.g.: a String - Int pair
  val pair = ("answer", 42)
  println(s"The pair is $pair, its second element is ${pair._2}")

  // Using pair as pattern, to extract values (decomposition)
  val (label, value) = pair
  println(s"The label is $label, the value is $value")

  val l = List(8, 1, 5, 2, 3, 1)
  val split = splitAt(l, 3)
  println(s"$l split at 3 gives $split")

  println("Merge sort: " + mSort(l))
  println("Merge sort ascending: " + mergeSort(l)((x, y) => x > y))
