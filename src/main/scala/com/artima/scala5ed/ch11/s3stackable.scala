/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Traits - Traits as stackable modifications
 */
package com.artima.scala5ed.ch11

import scala.collection.mutable.ArrayBuffer

@main
def s3stackable(): Unit =
  abstract class IntQueue:
    def get(): Int
    def put(x: Int): Unit

  /**
   * Has an ArrayBuffer, implements the methods declared in IntQueue
   */
  class BasicIntQueue extends IntQueue:
    private val buffer = ArrayBuffer.empty[Int]

    /**
     * Remove and return the first element in the buffer
     *
     * @return
     *   the (ex)first element
     */
    def get(): Int = buffer.remove(0)

    /**
     * Append the passed item to the buffer
     *
     * @param x
     *   an item
     */
    def put(x: Int): Unit = buffer += x

    def notEmpty: Boolean = buffer.nonEmpty
  end BasicIntQueue

  val bq = new BasicIntQueue
  for i <- 10 to 20 by 10 do
    println(s"Put $i")
    bq.put(i)
  while bq.notEmpty do println(s"Get ${bq.get()}")
  println("---")

  /**
   * Extending IntQueue Doubling could be mixed in a class that implements it too
   */
  trait Doubling extends IntQueue:
    /**
     * Call its "super", an abstract method! However, in a trait "super" is dynamically bounded, so
     * it works fine, given that is mixed in _after_ the method definition is provided
     *
     * The modifiers "abstract override" signal the compiler that this behavior is intentional
     *
     * @param x
     *   an item
     */
    abstract override def put(x: Int): Unit = super.put(2 * x)

  // a mixin class
  class DoublingQueue extends BasicIntQueue, Doubling

  val dq = new DoublingQueue
  for i <- 10 to 20 by 10 do
    println(s"Put $i")
    dq.put(i)
  while dq.notEmpty do println(s"Get ${dq.get()}")
  println("---")

  // a handy way of defining a mixin
  val dbq = new BasicIntQueue with Doubling
  for i <- 10 to 20 by 10 do
    println(s"Put $i")
    dbq.put(i)
  while dbq.notEmpty do println(s"Get ${dbq.get()}")
  println("---")

  /**
   * A modification trait that increase the passed value
   */
  trait Incrementing extends IntQueue:
    abstract override def put(x: Int): Unit = super.put(x + 1)

  /**
   * A modification trait that filter input
   */
  trait Filtering extends IntQueue:
    abstract override def put(x: Int): Unit = if x >= 0 then super.put(x)

  // mixin on BasicIntQueue, first Filtering is applied then Incrementing
  val bif = new BasicIntQueue with Incrementing with Filtering
  for i <- -1 to 1 do
    println(s"Put $i")
    bif.put(i)

  while bif.notEmpty do println(s"Get ${bif.get()}")
  println("---")

  // mixin on BasicIntQueue, first Incrementing is applied then Filtering
  val bfi = new BasicIntQueue with Filtering with Incrementing
  for i <- -1 to 1 do
    println(s"Put $i")
    bfi.put(i)

  while bfi.notEmpty do println(s"Get ${bfi.get()}")
  println("---")
