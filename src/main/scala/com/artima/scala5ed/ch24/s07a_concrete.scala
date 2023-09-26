/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Collections in Depth - Concrete immutable collection classes
  List, LazyList, Vector
 */
package com.artima.scala5ed.ch24

@main
def s07a_concrete(): Unit =
  // plain list
  val aList = List(1, 2, 3)
  println("A list: " + aList)

  // lazy list
  val aLazyList = 1 #:: 2 #:: 3 #:: LazyList.empty
  println("A lazy list: " + aLazyList)

  def fibFrom(a: Int, b: Int): LazyList[Int] = a #:: fibFrom(b, a + b)

  val fibonacci7 = fibFrom(1, 1).take(7)
  println("Lazy fibonacci 7: " + fibonacci7)
  println("Fibonacci 7 list: " + fibonacci7.toList)

  // vector
  val vec = scala.collection.immutable.Vector.empty
  println("An empty vector: " + vec)
  val vec2 = vec :+ 1 :+ 2
  println("A two element vector: " + vec2)
  val vec3 = 100 +: vec2
  println("A three element vector: " + vec3)
  println("First element in vec3: " + vec3(0))

  val vector3 = Vector(1, 2, 3)
  val vecUpd = vector3.updated(2, 4)
  println(s"A vector $vector3 and its update $vecUpd")

  val indexedSeq = collection.immutable.IndexedSeq(1, 2, 3)
  println("By default an indexed sequence is a Vector: " + indexedSeq)