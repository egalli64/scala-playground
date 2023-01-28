/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 5 - Lists - Lecture 5.3 - Higher-order list functions
 */
package org.coursera.efpl.course1.week5

// Mapping: applying a function to every list elements, ex. multiply by a given factor
/**
 * Scaling a list
 *
 * @param xs
 *   the input list
 * @param factor
 *   the scale factor
 * @return
 *   the scaled list
 */
def scale(xs: List[Double], factor: Double): List[Double] = xs match
  case Nil     => Nil
  case y :: ys => y * factor :: scale(ys, factor)

/**
 * Toy implementation for the more generic method map provided with the class List
 *
 * @param xs
 *   the input list
 * @param f
 *   the mapping to be performed on each element
 * @tparam T
 *   list type
 * @tparam U
 *   output type for the mapper
 * @return
 *   the mapped list
 */
def map[T, U](xs: List[T], f: T => U): List[U] = xs match
  case Nil     => Nil
  case y :: ys => f(y) :: map(ys, f)

/**
 * Refactored "scale", using List.map()
 *
 * @param xs
 *   the input list
 * @param factor
 *   the scale factor
 * @return
 *   the scaled list
 */
def scaleList(xs: List[Double], factor: Double): List[Double] =
  xs.map(x => factor * x)

/**
 * Exercise: Square for list, version 1
 *
 * @param xs
 *   the input list
 * @return
 *   the squared list
 */
def squareV1(xs: List[Int]): List[Int] = xs match
  case Nil     => Nil
  case y :: ys => y * y :: squareV1(ys)

/**
 * Exercise: Square for list, version 2
 *
 * @param xs
 *   the input list
 * @return
 *   the squared list
 */
def squareV2(xs: List[Int]): List[Int] = xs.map(x => x * x)

// Filtering: keeping only values satisfying a given predicate
/**
 * Filter to keep only positive elements
 *
 * @param xs
 *   the input list
 * @return
 *   the filtered list
 */
def positiveElements(xs: List[Int]): List[Int] = xs match
  case Nil     => Nil
  case y :: ys => if y > 0 then y :: positiveElements(ys) else positiveElements(ys)

/**
 * Toy sample of filter as implemented for List
 *
 * @param xs
 *   the input list
 * @param p
 *   the predicate determining which element keep
 * @tparam T
 *   parametric type
 * @return
 *   the filtered list
 */
def filter[T](xs: List[T], p: T => Boolean): List[T] = xs match
  case Nil     => Nil
  case y :: ys => if p(y) then y :: filter(ys, p) else filter(ys, p)

/**
 * Refactoring of positiveElements()
 *
 * @param xs
 *   input list
 * @return
 *   filtered list
 */
def posElems(xs: List[Int]): List[Int] = xs.filter(x => x > 0)

/**
 * Exercise: Convert a list in a list of list, where each list contains all the consecutive
 * duplicates of elements in the original list
 *
 * @param xs
 *   input list
 * @tparam T
 *   parametric type
 * @return
 *   the packed list
 */
def pack[T](xs: List[T]): List[List[T]] = xs match
  case Nil => Nil
  case y :: ys =>
    val (left, right) = ys.span(x => x == y)
    (y :: left) :: pack(right)

/**
 * Exercise: using pack, generate the run-length encoding of a list
 *
 * @param xs
 *   a list
 * @tparam T
 *   the parametrized type
 * @return
 *   a list of couples (element, number of consecutive copies)
 */
def encode[T](xs: List[T]): List[(T, Int)] =
  pack(xs).map(x => (x.head, x.size))

@main
def lecture3(): Unit =
  val l = List(1.2, 3.4, 5.2, 2.0)
  println(s"Original $l\nScaled: " + scale(l, 2))
  println("Mapped: " + map(l, x => 2 * x))
  println("Scale/mapped: " + scaleList(l, 2))

  val l2 = List(1, -2, 3, -4, 5)
  println("An int list: " + l2)
  println("Squared v1: " + squareV1(l2))
  println("Squared v2: " + squareV2(l2))

  println("Filtering to keep positive: " + positiveElements(l2))
  println("Filtering by custom filter: " + filter(l2, x => x > 0))
  println("Filtering by list filter: " + posElems(l2))

  val l3 = List(1, 2, 3, 4, 5, 6)
  println("Another int list: " + l3)
  println("Partition odd/even: " + l3.partition(x => x % 2 != 0))
  println("Span odd: " + l3.span(x => x % 2 != 0))
