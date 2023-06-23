/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - Basic operations on lists
 */
package com.artima.scala5ed.ch14

@main
def s04_basic(): Unit =
  val fruits = List("apples", "oranges", "pears")
  println("Fruits: " + fruits)

  println("Fruits head: " + fruits.head)
  println("Fruits tail: " + fruits.tail)
  println("Is fruits empty? " + fruits.isEmpty)

  /**
   * Insertion sort
   *
   * @param xs
   *   a list
   * @return
   *   the sorted list
   */
  def sort(xs: List[Int]): List[Int] =
    if xs.isEmpty then Nil
    else insert(xs.head, sort(xs.tail))

  /**
   * Insert the passed element to the right or recurse in the tail of the list
   *
   * @param x
   *   an element
   * @param xs
   *   its destination list
   * @return
   *   the list after insertion
   */
  def insert(x: Int, xs: List[Int]): List[Int] =
    if xs.isEmpty || x <= xs.head then x :: xs
    else xs.head :: insert(x, xs.tail)

  val numbers = List(5, 2, 3, 1, 4)
  println("Numbers: " + numbers)
  println("Sorted numbers: " + sort(numbers))
