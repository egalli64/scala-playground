/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Type Parameterization - Functional queues
 */
package com.artima.scala5ed.ch18

@main
def s1_funQueue(): Unit =
  /**
   *   1. Not efficient in enqueueing
   *
   * @param elems
   *   the queue elements
   * @tparam T
   *   the queue parametric type
   */
  class SlowAppendQueue[T](elems: List[T]):
    def head: T = elems.head
    def tail = new SlowAppendQueue(elems.tail)

    /**
     * unsatisfactory O(n) time complexity, being based on a list, it doesn't work efficiently
     *
     * @param x
     *   new element to add
     * @return
     *   a new queue
     */
    def enqueue(x: T): SlowAppendQueue[T] = SlowAppendQueue(elems ::: List(x))

    override def toString: String = elems.toString

  val q1 = SlowAppendQueue(List(1, 2, 3))
  println(s"SlowAppendQueue $q1 has head: ${q1.head}, tail: ${q1.tail}")
  val q1b = q1.enqueue(4)
  println(s"Enqueueing generates $q1b")

  /**
   * 2. Not efficient in head and tail. Reversing the elements enqueue is O(1)
   *
   * @param elems
   *   the queue elements
   * @tparam T
   *   the queue parametric type
   */
  class SlowHeadQueue[T](elems: List[T]):
    def head: T = elems.last
    def tail = new SlowHeadQueue(elems.init)
    def enqueue(x: T): SlowHeadQueue[T] = SlowHeadQueue(x :: elems)
    override def toString: String = elems.toString

  val q2 = SlowHeadQueue(List(3, 2, 1))
  println(s"SlowHeadQueue $q2 has head: ${q2.head}, tail: ${q2.tail}")
  val q2b = q2.enqueue(4)
  println(s"Enqueueing generates $q2b")

  /**
   * 3. constant amortized complexity
   *
   * @param leading
   *   initial part of the queue
   * @param trailing
   *   terminal part of the queue
   * @tparam T
   *   the queue parametric type
   */
  class Queue[T](private val leading: List[T], private val trailing: List[T]):
    private def mirror =
      if leading.isEmpty then new Queue(trailing.reverse, Nil)
      else this

    def head: T = mirror.leading.head

    def tail: Queue[T] =
      val q = mirror
      new Queue(q.leading.tail, q.trailing)

    def enqueue(x: T) = new Queue(leading, x :: trailing)
    override def toString: String = s"$leading $trailing"

  val q3 = Queue(Nil, List(3, 2, 1))
  println(s"Queue $q3 has head: ${q3.head}, tail: ${q3.tail}")
  val q3b = q3.enqueue(4)
  println(s"Enqueueing generates $q3b")
