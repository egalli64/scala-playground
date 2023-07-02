/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - First-order methods on class List
  A first-order method does not take any function as argument

  Converting lists: iterator, toArray, copyToArray
 */
package com.artima.scala5ed.ch14

@main
def e06e(): Unit =
  // 1. List toArray and Array toList
  val letters = List('a', 'b', 'c', 'd', 'e')
  println(s"The original list: $letters")
  val letArr = letters.toArray
  println(s"Converted to an array sized ${letArr.length}")
  val letLst = letArr.toList
  println(s"Converted back to list: $letLst")

  // 2. Pushing list elements in an array (be careful!)
  val buffer = new Array[Char](10)
  for i <- 0 until 5 do buffer(i) = ('A' + i).toChar
  val x = letters.copyToArray(buffer, 5)
  println(s"$x elements written to buffer")
  println(buffer.mkString)

  // 3. iterating on a list
  val it = letters.iterator
  while it.hasNext do println(it.next)
