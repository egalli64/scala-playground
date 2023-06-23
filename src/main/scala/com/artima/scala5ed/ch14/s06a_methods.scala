/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - First-order methods on class List
  A first-order method does not take any function as argument

  :::, length, init, last
 */
package com.artima.scala5ed.ch14

@main
def s06_1st(): Unit =
  // ::: list concatenation, ending with ':' is right associative, like cons
  println(s"Concatenating two lists: ${List(1, 2) ::: List(3, 4, 5)}")
  println(s"Concatenating to Nil is a nop: ${List(1, 2) ::: Nil}")

  /**
   * As example, implementing list concatenation
   *
   * @param xs
   *   a list
   * @param ys
   *   another list
   * @tparam T
   *   lists parametric type
   * @return
   *   the concatenated list
   */
  def append[T](xs: List[T], ys: List[T]): List[T] = xs match
    case List()   => ys
    case x :: xs1 => x :: append(xs1, ys)

  val lex1 = append(List(1, 2), List(3, 4, 5))
  println("Ex 1: " + lex1)

  val lex2 = append(List(1, 2), Nil)
  println("Ex 2: " + lex2)

  // List length has an O(n) cost!
  println("Length of lex1 is " + lex1.length)

  val letters = List('a', 'b', 'c', 'd', 'e')
  println("Letters are: " + letters)

  // init is like tail, but it is O(n)!
  println("Letters init: " + letters.init)

  try println(Nil.init)
  catch case uoe: UnsupportedOperationException => println("Won't work, " + uoe)

  // last is like head, but it is O(n)!
  println("Letters last: " + letters.last)
  try println(Nil.last)
  catch case uoe: NoSuchElementException => println("Won't work, " + uoe)
