/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Next Steps in Scala - Use lists
 */
package com.artima.scala5ed.ch03

@main
def s08(): Unit =
  /*
    Think functionally: methods should not have side effects, so objects should be immutable

    The Array class is not in this line of thinking. Its size is fix, but its content could change

    When possible, immutable List is preferred to work functionally in Scala
   */

  // A List[Int] generated by the apply() factory method
  val oneTwoThree = List(1, 2, 3)
  println(oneTwoThree)

  // Two other lists
  val oneTwo = List(1, 2)
  val threeFour = List(3, 4)

  // Another list, created by _concatenating_ ::: two lists
  val oneToFour = oneTwo ::: threeFour
  println("Using ::: to get " + oneToFour)

  /*
    The "cons" operator :: create a new list adding prepending a single element to a list

    Even though they are commonly called operators, ::, :::, ... are _methods_

    Usually the "operators" are left associative, but the ones with names ending with ":" are right associative
   */
  val zeroToTwo = 0 :: oneTwo
  println("Using :: to get " + zeroToTwo)

  // calling the operator :: following the method invocation style
  val minusOneToTwo = zeroToTwo.::(-1)
  println("Invoking :: as a method to get " + minusOneToTwo)

  // The empty list has a shorthand name, Nil
  println("The empty list: " + Nil)

  // Another way to build a list up
  val byCons = 1 :: 2 :: 3 :: Nil
  println("Building a list by cons: " + byCons)

  // Appending to a list is expensive!
  val uncommon = byCons :+ 4
  println("Appending to a list by :+ to get " + uncommon)
