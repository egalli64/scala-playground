/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Abstract Members - A quick tour
 */
package com.artima.scala5ed.ch20

@main
def s1_intro(): Unit =
  /**
   * A trait with abstract an type, method, val, and var
   */
  trait Abstract:
    type T
    def transform(x: T): T
    val initial: T
    var current: T

  /**
   * To be concrete a derived class must specify all the abstract members
   */
  class Concrete extends Abstract:
    type T = String
    def transform(x: String): String = x + x
    val initial = "hi"
    var current: String = initial

  val x = Concrete()
  x.current = x.transform(x.current)
  println(x.current)
