/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 3 - Data and Abstraction - Practice Programming Assignment: Object-Oriented Sets
 */
package org.coursera.efpl.course1.week3.assignment

import scala.annotation.tailrec

/**
 * List of tweets */
trait TweetList:
  /**
   * Getter
   *
   * @return Head of list
   * */
  def head: Tweet

  /**
   * Getter
   *
   * @return others than head as list
   * */
  def tail: TweetList

  /**
   * Check the status for the current element
   *
   * @return false for terminator
   * */
  def isEmpty: Boolean

  /**
   * Apply the passed function on all the elements in list
   *
   * @param f the function that has to be applied
   * */
  @tailrec final def foreach(f: Tweet => Unit): Unit = //
    if !isEmpty then //
      f(head)
      tail.foreach(f)

/**
 * Singleton terminator */
object Nil extends TweetList:
  def head = throw java.util.NoSuchElementException("head of EmptyList")

  def tail = throw java.util.NoSuchElementException("tail of EmptyList")

  def isEmpty = true

/**
 * Cell for an actual element in list
 *
 * @param head the current tweet
 * @param tail the other tweet as a list
 * */
class Cons(val head: Tweet, val tail: TweetList) extends TweetList:
  def isEmpty = false

/**
 * Smoke test on list
 * */
@main def listSmoke(): Unit = //
  val tA: Tweet = Tweet("a", "a body", 20)
  val tB: Tweet = Tweet("b", "b body", 20)
  val tC: Tweet = Tweet("c", "c body", 7)
  val tD: Tweet = Tweet("d", "d body", 9)
  val s = Empty().incl(tA).incl(tB).incl(tC).incl(tD)
  s.foreach(println)
  println("---")
  s.descendingByRetweet.foreach(println)