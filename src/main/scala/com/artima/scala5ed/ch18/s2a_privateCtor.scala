/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Type Parameterization - Information hiding

  Private primary construction
 */
package com.artima.scala5ed.ch18

@main
def s2a_privateConstructor(): Unit =
  /**
   * Hide the primary constructor making it private
   *
   * @param leading
   *   first part of queue
   * @param trailing
   *   second part of queue
   * @tparam T
   *   the queue type parameter
   */
  class Queue1[T] private (private val leading: List[T], private val trailing: List[T])

  // won't compile
  // val q1 = Queue1(List(1), List(3))

  /**
   * Primary constructor hidden, auxiliary constructor provided
   *
   * @param leading
   *   first part of queue
   * @param trailing
   *   second part of queue
   * @tparam T
   *   the queue type parameter
   */
  class Queue2[T] private (private val leading: List[T], private val trailing: List[T]):
    def this() = this(Nil, Nil)
    def this(elems: T*) = this(elems.toList, Nil)
    override def toString: String = s"$leading $trailing"

  val q2 = Queue2()
  println("An empty q2: " + q2)

  val q2b = Queue2(1, 2, 3)
  println("A q2 with some elements in it: " + q2b)

  /**
   * Hide the primary constructor making it private, delegate the companion object to provide
   * factory methods
   *
   * @param leading
   *   first part of queue
   * @param trailing
   *   second part of queue
   * @tparam T
   *   the queue type parameter
   */
  class Queue3[T] private (private val leading: List[T], private val trailing: List[T]):
    override def toString: String = s"$leading $trailing"

  /**
   * Companion object with factory methods
   */
  object Queue3:
    def apply[T]() = new Queue3[T](Nil, Nil)
    def apply[T](xs: T*) = new Queue3[T](xs.toList, Nil)

  val q3a = Queue3()
  println("An empty q3: " + q3a)

  val q3 = Queue3(1, 2, 3)
  println("A q3 with some elements in it: " + q3)
