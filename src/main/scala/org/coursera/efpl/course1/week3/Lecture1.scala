/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 3 - Data and Abstraction - Lecture 3.1 - Class hierarchies
 */
package org.coursera.efpl.course1.week3

/**
 * Persistent Data Structure - the previous DS is left untouched, a new one is created (maybe partially overlapping)
 *
 * Base of a hierarchy, superclass of Empty and NotEmpty
 * Implicitly extends java.lang.Object i.e. Object is its base class
 * */
abstract class IntSet:
  /**
   * A new IntSet is generated, containing the new element
   *
   * @param x a new element to be included
   * @return a new IntSet
   * */
  def include(x: Int): IntSet

  /**
   * Check if the passed value is in the data structure
   *
   * @param x the input
   * @return true if x is in
   * */
  def contains(x: Int): Boolean

  /**
   * Put this structure together with the passed one
   *
   * @param other another IntSet
   * @return the union of this and other
   * */
  def union(other: IntSet): IntSet
end IntSet

/**
 * Subclass of IntSet, a non-empty set
 *
 * @param elem  the root element
 * @param left  left child
 * @param right right child
 * */
class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet:
  // Notice that, being "contains()" abstract in super, the keyword "override" is not mandatory
  def contains(x: Int): Boolean = //
    if x < elem then left.contains(x) //
    else if x > elem then right.contains(x) //
    else true

  def include(x: Int): IntSet = //
    if x < elem then NonEmpty(elem, left.include(x), right) //
    else if x > elem then NonEmpty(elem, left, right.include(x)) //
    else this

  def union(other: IntSet): IntSet = left.union(right).union(other).include(elem)

  override def toString: String = s"{$left $elem $right}"
end NonEmpty

/**
 * An IntSet with nothing in it.
 * Subclass of IntSet, it has as base classes IntSet and Object.
 * It is a singleton, we need just a single instance, so "object" not "class"
 * */
object Empty extends IntSet:
  def contains(x: Int): Boolean = false

  // Create a NonEmpty, having as children two reference to the singleton Empty itself
  def include(x: Int): IntSet = NonEmpty(x, Empty, Empty)

  def union(other: IntSet): IntSet = other

  override def toString: String = "x"
end Empty

/**
 * Companion object - used for what are, in Java, static members (not available in Scala)
 * */
object IntSet:
  /**
   * Factory method for a singleton
   *
   * @param x the value in the set
   * @return the IntSet singleton */
  def singleton(x: Int): IntSet = NonEmpty(x, Empty, Empty)

/**
 * Smoke test for lecture 1
 * */
@main def lecture1(): Unit = //
  val s1 = Empty
  println(s1)

  val s2 = s1.include(4)
  println(s2)

  val s3 = IntSet.singleton(23)
  println(s3)

  val s4 = s3.include(34)
  println(s4)

  val s5 = s4.union(s2)
  println(s5)
