/*
  https://docs.scala-lang.org/scala3/book/domain-modeling-tools.html
  https://github.com/egalli64/scala-playground

  Domain Modeling - Tools - Case class / object
 */
package com.github.egalli64.scala3.b04

import scala.util.Random

@main
def casing(): Unit =
  /**
   * 1: case class, similar to Java record - public and immutable fields as default
   *
   * @param name
   *   the person name
   * @param relation
   *   the person relation
   */
  case class Person(name: String, relation: String)

  val tom = Person("Tom", "Uncle")
  println("Tom: " + tom)

  // tom.name = "Tommy" // won't compile

  /**
   * 2: For case class the compiler generates toString() and a few other methods.
   *
   * 2a: unapply(), used for pattern matching
   */
  tom match
    case Person(n, r) => println(s"Name is $n, relation is $r")

  /**
   * 2b: equals() and hashCode()
   */
  val hannah = Person("Hannah", "niece")
  println(s"$tom is equals to $hannah? ${tom == hannah}")
  println("Tom hashcode is " + tom.hashCode())

  /**
   * 2c: copy() - used with by-name parameters for "update as you copy"
   */
  val tomJr = tom.copy(relation = "Son")
  println("Tom Jr: " + tomJr)

  /**
   * 3: case object - immutable object, useful for instance to define an immutable message like:
   */
  sealed trait Message
  case class PlaySong(name: String) extends Message
  case class IncreaseVolume(amount: Int) extends Message
  case class DecreaseVolume(amount: Int) extends Message
  case object StopPlaying extends Message

  val aMessage = Random.nextInt(4) match
    case 0 => PlaySong("Yellow")
    case 1 => IncreaseVolume(10)
    case 2 => DecreaseVolume(5)
    case _ => StopPlaying

  def handleMessages(message: Message): Unit = message match
    case PlaySong(name)         => println(s"Playing $name")
    case IncreaseVolume(amount) => println(s"Increasing volume by $amount")
    case DecreaseVolume(amount) => println(s"Decreasing volume by $amount")
    case StopPlaying            => println("Stop the music")

  handleMessages(aMessage)
