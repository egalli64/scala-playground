/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - Constructing lists

  Lists are built from Nil, the empty list, and :: ("cons" - list extension at the front)
 */
package com.artima.scala5ed.ch14

@main
def s03_cons(): Unit =
  // operators ending with ':' are right associative
  val fruits = "apples" :: "oranges" :: "pears" :: Nil
  println("Fruits: " + fruits)

  val numbers = 1 :: 2 :: 3 :: 4 :: Nil
  println("Numbers: " + numbers)

  val diagonal3 = 1 :: 0 :: 0 :: Nil ::
    0 :: 1 :: 0 :: Nil ::
    0 :: 0 :: 1 :: Nil :: Nil
  println("Diagonal 3: " + diagonal3)

  val empty = Nil
  println("Empty: " + empty)
