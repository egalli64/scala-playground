/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Collections in Depth - Trait Iterable

  Top of the collection hierarchy
  All methods are defined in terms of the abstract method iterator
  The derived class  need to define only this method
 */
package com.artima.scala5ed.ch24

@main
def s03_iterable(): Unit =
  val xs = List(1, 2, 3, 4, 5)
  println("An iterable: " + xs)

  /*
    Iteration operations
   */
  println("\nFor each element println it:")
  xs.foreach(println(_))

  println("\nGroup the elements three by three")
  val git = xs.grouped(3)
  while git.hasNext do println("Next group: " + git.next())

  println("\nSliding group the elements three by three")
  val sit = xs.sliding(3)
  while sit.hasNext do println("Next sliding group: " + sit.next())

  /*
    Addition (aka concat)
   */
  val ys = List(6, 7, 8, 9, 0)
  println("Another iterable: " + ys)
  println(s"Concat xs and ys: ${xs ++ ys}")

  println("...")