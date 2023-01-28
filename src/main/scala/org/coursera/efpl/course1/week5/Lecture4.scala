/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 5 - Lists - Lecture 5.4 - Reduction of Lists
 */
package org.coursera.efpl.course1.week5

/**
 * Folding a list to get its sum
 *
 * @param xs
 *   a list
 * @return
 *   its sum
 */
def sumPlain(xs: List[Int]): Int = xs match
  case Nil     => 0
  case y :: ys => y + sumPlain(ys)

/**
 * Folding a list to get its product
 *
 * @param xs
 *   a list
 * @return
 *   its product
 */
def prodPlain(xs: List[Int]): Int = xs match
  case Nil     => 1
  case y :: ys => y * prodPlain(ys)

// Refactoring using reduceLeft() - compact notation for lambda
def sumRL(xs: List[Int]): Int = (0 :: xs).reduceLeft(_ + _)
def prodRL(xs: List[Int]): Int = (1 :: xs).reduceLeft(_ * _)

// Refactoring using foldLeft()
def sumFL(xs: List[Int]): Int = xs.foldLeft(0)(_ + _)
def prodFL(xs: List[Int]): Int = xs.foldLeft(1)(_ * _)

// Refactoring reverse to get O(n) performance
def reverse[T](xs: List[T]): List[T] =
  xs.foldLeft(List[T]())((xs, x) => x :: xs)

// Exercise: map and length implemented in term of foldRight
def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  xs.foldRight(List[U]())((y, ys) => f(y) :: ys)
def lengthFun[T](xs: List[T]): Int =
  xs.foldRight(0)((_, n) => n + 1)

@main
def lecture4(): Unit =
  val l = List(3, 6, 1, 5)
  println("List is " + l)
  println("Sum (plain): " + sumPlain(l))
  println("Product (plain): " + prodPlain(l))

  println("Sum (reduceLeft): " + sumRL(l))
  println("Product (reduceLeft): " + prodRL(l))

  println("Sum (foldLeft): " + sumFL(l))
  println("Product (foldLeft): " + prodFL(l))

  println("Reversed (foldLeft)" + reverse(l))

  println("Map (foldRight) to negate: " + mapFun(l, x => -x))
  println("Length (foldRight): " + lengthFun(l))
