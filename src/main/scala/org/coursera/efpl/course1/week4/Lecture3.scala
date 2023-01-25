/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 4 - Types and Pattern Matching - Lecture 4.3 - Lists
 */
package org.coursera.efpl.course1.week4

import scala.annotation.tailrec

@main def lecture3(): Unit =
  // the immutable empty list (of Nothing)
  val empty: List[Nothing] = Nil
  println("Empty list: " + empty)

  // a list of strings - immutable and recursive
  val fruits: List[String] = List("apple", "orange", "pear")
  println("Fruit list: " + fruits)

  // using the right-associative cons operator
  val fruits2 = "apple" :: "orange" :: "pear" :: Nil
  println("Fruit list (2): " + fruits2)

  // a list of list of int
  val diagonal3: List[List[Int]] =
    List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
  println("Diagonal list: " + diagonal3)

  // base operations on list: head, tail, isEmpty
  println("Fruits head: " + fruits.head)
  println("Fruits tail: " + fruits.tail)
  println("Fruits is empty? " + fruits.isEmpty)

  // list patterns: Nil, ::, List()
  val ls = "mango" :: fruits
  println("Extra fruit: " + ls)

  def insert(x: Int, xs: List[Int]): List[Int] = xs match
    case Nil     => List(x)
    case y :: ys => if x < y then x :: xs else y :: insert(x, ys)

  val data = List(1, 2, 4)
  println("Inserting a value in a list: " + insert(5, data))

  def insertionSort(xs: List[Int]): List[Int] = xs match
    case Nil     => Nil
    case y :: ys => insert(y, insertionSort(ys))

  val scrambledData = List(7, 3, 9, 2)
  println("Insertion sort: " + insertionSort(scrambledData))
