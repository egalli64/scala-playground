/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Type Parameterization - Information hiding

  Private class
 */
package com.artima.scala5ed.ch18

@main
def s2b_privateClass(): Unit =
  /**
   * Trait exposing just the interface
   *
   * @tparam T
   *   the trait parameter type
   */
  trait Queue[T]:
    def head: T
    def tail: Queue[T]
    def enqueue(x: T): Queue[T]

  object Queue:
    /**
     * Factory, refers to the private Queue Implementation class
     *
     * @param xs
     *   elements for initialize the leading part of the queue
     * @tparam T
     *   the queue template parameter
     * @return
     *   a queue object
     */
    def apply[T](xs: T*): Queue[T] = QImpl[T](xs.toList, Nil)

    /**
     * Concrete Queue
     *
     * @param lead
     *   the leading part of the queue
     * @param trail
     *   the trailing part of the queue
     * @tparam T
     *   the trait parameter type
     */
    private class QImpl[T](private val lead: List[T], private val trail: List[T]) extends Queue[T]:
      def mirror: QImpl[T] = if lead.isEmpty then QImpl(trail.reverse, Nil) else this

      def head: T = mirror.lead.head

      def tail: Queue[T] =
        val q = mirror
        QImpl(q.lead.tail, q.trail)

      def enqueue(x: T): Queue[T] = QImpl(lead, x :: trail)

      override def toString: String = s"$lead $trail"

  val q = Queue(1, 2, 3)
  println("A queue: " + q)
