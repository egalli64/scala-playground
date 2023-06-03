/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Traits - Why not multiple inheritance?
  Or: Multiple Inheritance vs Linearized Traits
 */
package com.artima.scala5ed.ch11

import scala.collection.mutable.ArrayBuffer

@main
def s4mi(): Unit =
  /**
   * Base class
   */
  abstract class IntQueue:
    def get(): Int
    def put(x: Int): Unit

  /**
   * Concrete class
   */
  class BasicIntQueue extends IntQueue:
    private val buffer = ArrayBuffer.empty[Int]
    def get(): Int = buffer.remove(0)
    def put(x: Int): Unit = buffer += x
    def notEmpty: Boolean = buffer.nonEmpty

    override def toString: String = buffer.mkString("[", ",", "]")

  /**
   * A stackable modification trait
   */
  trait Doubling extends IntQueue:
    abstract override def put(x: Int): Unit = super.put(2 * x)

  /**
   * Another stackable modification trait
   */
  trait Incrementing extends IntQueue:
    abstract override def put(x: Int): Unit = super.put(x + 1)

  /**
   * Using MI instead of mixin here is bugged and unsatisfactory (but legal)
   */
  class MyQueue extends BasicIntQueue, Incrementing, Doubling:
    override def put(x: Int): Unit =
      super[Incrementing].put(x)
      super[Doubling].put(x)

  val dq = new MyQueue
  for i <- -1 to 1 do
    println(s"Put $i")
    dq.put(i)
    println(s"$i: $dq")
  while dq.notEmpty do println(s"Get ${dq.get()}")
  println("---")

  // another hierarchy with stackable modification traits
  class Animal:
    override def toString: String = "Animal"

  trait Furry extends Animal:
    override def toString: String = super.toString + " Furry"
  trait HasLegs extends Animal:
    override def toString: String = super.toString + " HasLegs"
  trait FourLegged extends HasLegs:
    override def toString: String = super.toString + " FourLegged"

  class Cat extends Animal, Furry, FourLegged:
    override def toString: String = super.toString + " Cat"

  // linearized: Cat, FourLegged, HasLegs, Furry, Animal, AnyRef, Any
  val tom = Cat()
  println(tom)
