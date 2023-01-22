/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 2 - Functions & Evaluations - Practice Programming Assignment: Functional Sets
 */
package org.coursera.efpl.course1.week2.assignment

import scala.annotation.tailrec

trait FunSets:
  /**
   * Alias for a function taking an Int and giving back a Boolean
   *
   * Describe a set, returning true if the element passed is part of it
   * */
  type FunSet = Int => Boolean

  /**
   * Toy implementation, elements are expected to be in [-1000, +1000] */
  private val bound = 1_000

  /**
   * Factory method for a single-element set
   *
   * The resulting FunSet returns true only when x is the same of the originator element
   *
   * @param elem the element that is in the set
   * @return the new set, expressed as function
   * */
  def singletonSet(elem: Int): FunSet = x => x == elem

  /**
   * Check if an element is in the passed set
   *
   * @param s    a functional set
   * @param elem the element to be checked
   * @return true, if the element is part of the functional set
   * */
  def contains(s: FunSet, elem: Int): Boolean = s(elem)

  /**
   * Factory method for union of the two passed ones
   *
   * The resulting function returns true when x is in s OR in t
   *
   * @param s a functional set
   * @param t another functional set
   * @return the new set
   * */
  def union(s: FunSet, t: FunSet): FunSet = x => s(x) || t(x)

  /**
   * Factory method for intersection of the two passed ones
   *
   * The resulting function returns true when x is in s AND in t
   *
   * @param s a functional set
   * @param t another functional set
   * @return the new set
   * */
  def intersect(s: FunSet, t: FunSet): FunSet = x => s(x) && t(x)

  /**
   * Factory method for difference of the first against the second passed one
   *
   * The resulting function returns true when x is in s AND NOT in t
   *
   * @param s a functional set
   * @param t another functional set
   * @return the new set
   * */
  def diff(s: FunSet, t: FunSet): FunSet = x => s(x) && !t(x)

  /**
   * Factory method for limiting the FunSet with a predicate
   *
   * Being FunSet a predicate, it is just an alias for intersect
   *
   * @param s a functional set
   * @param p a predicate
   * @return the new set, intersection of s and p
   * */
  def filter(s: FunSet, p: Int => Boolean): FunSet = intersect(s, p)

  /**
   * Check if predicate is true for each element in FunSet - limited by -/+ bound
   *
   * Each element x in s should also be in p meaning, x should not be in s - p
   *
   * @param s a FunSet
   * @param p a Predicate
   * @return true for success
   * */
  def forall(s: FunSet, p: Int => Boolean): Boolean = //

    @tailrec def iter(x: Int): Boolean = //
      if contains(diff(s, p), x) then false //
      else if x == bound then true //
      else iter(x + 1)

    iter(-bound)

  /**
   * Check if exists at least an element in a FunSet where a predicate is true
   *
   * It is the same that asking if for all the element is s in _not_ valid the predicate, then negate the result
   *
   * @param s a FunSet
   * @param p a Predicate
   * @return true for success
   * */
  def exists(s: FunSet, p: Int => Boolean): Boolean = !forall(s, x => !p(x))

  /**
   * Factory method by changing the original rule with a function
   *
   * The generated FunSet for an Int returns the Boolean given by exists() for the original FunSet
   * <li>with the predicate that checks if the passed value matches against an element in the set
   *
   * y is in the new set if exists in the original set an element modified by the predicate that matches
   *
   * @param s a functional set
   * @param f a function mapping an original set element to an element of the new set
   * @return the new set
   * */
  def map(s: FunSet, f: Int => Int): FunSet = y => exists(s, x => y == f(x))

  /**
   * Mimic of the standard toString() method
   *
   * @param s a functional set
   * @return the element in the functional set (bounded)
   */
  def toString(s: FunSet): String = (for i <- -bound to bound if contains(s, i) yield i).mkString("{", ",", "}")
end FunSets

object FunSets extends FunSets

/**
 * Smoke test for assignment
 * */
@main def assignment(): Unit = //
  import FunSets.* //

  val s = singletonSet(42)
  println("A singleton set: " + toString(s))