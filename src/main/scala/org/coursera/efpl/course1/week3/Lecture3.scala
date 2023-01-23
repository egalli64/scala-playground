/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 3 - Data and Abstraction - Lecture 3.3 - Polymorphism
 */
package org.coursera.efpl.course1.week3

import scala.annotation.tailrec

/**
 * Immutable list of T (generic type), based on two blocks, usually referred to as Cons-List
 * <li>Nil: the empty list
 * <li>Cons: a cell with an element and the rest of the list
 * <p>
 * Two main forms of polymorphism
 * <li>Generics: by type parameterization
 * <li>Subtyping: by inheritance
 * <p>
 * The type parameter is used at compile time only: type erasure
 *
 * @tparam T : the type parameter
 * */
trait MyList[T]:
  /**
   * Is it a Nil?
   *
   * @return true if the list is empty
   * */
  def isEmpty: Boolean

  /**
   * Getter for the current value
   *
   * @return the current value
   * */
  def head: T

  /**
   * Getter for the rest of the list
   *
   * @return the rest of the list
   * */
  def tail: MyList[T]

/**
 * Value parameter: define both a constructor parameter a and class field with the same name
 *
 * @param head value in the cons, implicitly associated to the head field
 * @param tail the rest of the list, implicitly associated to the tail field
 * @tparam T : the type parameter
 * */
class MyCons[T](val head: T, val tail: MyList[T]) extends MyList[T]:
  def isEmpty = false

  override def toString: String = s"{$head $tail}"
end MyCons

class MyNil[T] extends MyList[T]:
  def isEmpty = true

  def head = throw new NoSuchElementException("Nil.head")

  def tail = throw new NoSuchElementException("Nil.tail")

  override def toString: String = "{}"
end MyNil

/**
 * Factory function for a singleton list
 *
 * @param elem the unique element in this list
 * @tparam T function could have type parameter, too
 * @return the new list
 * */
def singleton[T](elem: T) = MyCons[T](elem, MyNil[T])

/**
 * Exercise: get the n'th element in a list
 *
 * @param xs a list
 * @param n  the index for the requested element
 * @tparam T the parameter type
 * @return the found element
 * */
@tailrec //
def nth[T](xs: MyList[T], n: Int): T = //
  if xs.isEmpty then throw IndexOutOfBoundsException()
  if n == 0 then xs.head else nth(xs.tail, n - 1)

@main def lecture3(): Unit = //
  val s1 = singleton(42)
  println("s1: " + s1)

  val s2 = singleton(true)
  println("s2: " + s2)

  val s3 = MyCons(1, MyCons(2, MyCons(3, MyNil())))
  println("First element in s3: " + nth(s3, 0))
  println("Third element in s3: " + nth(s3, 2))

  try //
    nth(s3, 6) //
  catch //
    case _: IndexOutOfBoundsException => println("As expected, no sixth element in s3")
