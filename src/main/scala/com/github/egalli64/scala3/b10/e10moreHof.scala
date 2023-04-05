/*
  https://docs.scala-lang.org/scala3/book/collections-methods.html
  https://github.com/egalli64/scala-playground

  Collections Methods - foreach(), head, tail, ...
 */
package com.github.egalli64.scala3.b10

import scala.annotation.tailrec

@main
def e10moreHof(): Unit =
  val oneToTen = (1 to 10).toList
  println("An int list: " + oneToTen)

  val names = List("adam", "brandy", "chris", "david")
  println("A string list: " + names)

  println("For each name, println it")
  names.foreach(println)

  println("The head of names is " + names.head)
  println("A string is a sequence, head of head of names is: " + names.head.head)

  try println(Nil.head)
  catch case ex: NoSuchElementException => println("Beware of " + ex)
  println("The headOption of an empty sequence is " + Nil.headOption)


  println("The elements but the head, is called tail: " + names.tail)
  println("The tail of head of names is: " + names.head.tail)

  val x :: xs = names: @unchecked
  println(s"Matching a list by cons: $x, $xs")

  println("Pattern matching on a numeric sequence to calculate its sum")
  def sum(values: List[Int]): Int = values match
    case Nil => 0
    case x :: xs => x + sum(xs)
  println(s"$oneToTen: " + sum(oneToTen))
