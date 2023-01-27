/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 5 - Lists - Lecture 5.1 - A Closer Look at Lists
 */
package org.coursera.efpl.course1.week5

import java.util.NoSuchElementException
import scala.annotation.tailrec

/**
 * Sample implementation for "last" on a list
 *
 * O(n) - eat each element in the list till the last one
 *
 * @param xs
 *   a list
 * @tparam T
 *   the parameter type for the list
 * @return
 *   the last element in list
 */
@tailrec
def last[T](xs: List[T]): T = xs match
  case Nil      => throw NoSuchElementException("Empty list")
  case x :: Nil => x
  case _ :: ys  => last(ys)

/**
 * Sample implementation for "init" on a list
 *
 * O(n) - cons each element but the last one
 *
 * @param xs
 *   a list
 * @tparam T
 *   the parameter type for the list
 * @return
 *   a list with all the input elements but its last one
 */
def init[T](xs: List[T]): List[T] = xs match
  case Nil     => throw UnsupportedOperationException("Empty list")
  case List(_) => Nil
  case y :: ys => y :: init(ys)

/**
 * Sample implementation for "++" for two lists - O(n) on the first one
 *
 * Cons each element of the first list, then the second list
 *
 * @param xs
 *   first list
 * @param ys
 *   second list
 * @tparam T
 *   the parameter type for the two lists
 * @return
 *   the concatenation of the two lists
 */
def concatenate[T](xs: List[T], ys: List[T]): List[T] = xs match
  case Nil      => ys
  case x :: xs1 => x :: concatenate(xs1, ys)

/**
 * Sample implementation for reverse (simple but too expensive)
 *
 * O(n**2) - each element is converted to List and concatenated with the reverse of the rest.
 *
 * @param xs
 *   the input list
 * @tparam T
 *   the parameter type for the list
 * @return
 *   the reverted list
 */
def reverse[T](xs: List[T]): List[T] = xs match
  case Nil     => Nil
  case y :: ys => reverse(ys) ++ List(y)

/**
 * Remove the element with index n from a list, if inbound
 *
 * @param n
 *   position
 * @param xs
 *   the list
 * @tparam T
 *   the parameter type for the list
 * @return
 *   the new list
 */
def removeAt[T](n: Int, xs: List[T]): List[T] = xs match
  case Nil     => Nil
  case y :: ys => if n == 0 then ys else y :: removeAt(n - 1, ys)

def flatten(xs: Any): List[Any] = xs match
  case Nil     => Nil
  case y :: ys => flatten(y) ++ flatten(ys)
  case _       => xs :: Nil

/** writing code following the lecture ... */
@main
def lecture1(): Unit =
  // List is parametric, es: List[Dog], parametric type is usually inferred by the compiler

  // Creation by constructor ...
  val fruits = List("Apple", "Orange", "Banana")
  // ... or by sequence of cons operations (right associative)
  val numbers = 1 :: 2 :: 3 :: Nil

  // Decomposition by basic operations - head, tail, isEmpty ...
  println("First fruit: " + fruits.head)
  println("Other than first fruit: " + fruits.tail)
  println("Is the list empty? " + fruits.isEmpty)
  // ... or by pattern matching
  numbers match
    case x :: y :: _ => println(s"First two elements in numbers are $x and $y")
    case _           => println("Unexpected")

  // Some commonly used list methods
  println(s"List length is ${fruits.length}, same, size is ${fruits.size}")
  println(s"Last element is ${fruits.last} (exception if empty)")
  println(s"All elements but last are ${fruits.init} (exception if empty)")
  println(s"First n (here 2) elements are ${fruits.take(2)} (or full list)")
  println(s"Other after first n (here 2) elements are ${fruits.drop(2)} (or empty list)")
  println(
    s"Element in position n (here 1) is ${fruits(1)}, same (apply) is ${fruits.apply(1)} (or exception)"
  )

  // Factory methods
  println(s"Concatenation $fruits ++ $numbers = " + (fruits ++ numbers))
  println("Reverse: " + fruits.reverse)
  println("Update nth (here 1) with x: " + fruits.updated(1, "x"))

  // Finding elements
  println("Index of x (or -1): " + fruits.indexOf("Banana"))
  println("List contains x? " + fruits.contains("Banana"))
