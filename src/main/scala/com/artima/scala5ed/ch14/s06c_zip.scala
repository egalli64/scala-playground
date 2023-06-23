/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - First-order methods on class List
  A first-order method does not take any function as argument

  zip, unzip
 */
package com.artima.scala5ed.ch14

@main
def s06c_zip(): Unit =
  val letters = List('a', 'b', 'c', 'd', 'e')
  println("Letters are: " + letters)
  println("Letters indices are: " + letters.indices)

  // from to lists to a list of pairs
  val indexLetters = letters.indices.zip(letters)
  println("Index / letter: " + indexLetters)

  // more efficiently
  println("Zip with index: " + letters.zipWithIndex)

  // unmatched elements are dropped
  val zipped = letters.zip(List(1, 2, 3))
  println("Letter / three integers zipped: " + zipped)

  println("Unzip: " + zipped.unzip)
