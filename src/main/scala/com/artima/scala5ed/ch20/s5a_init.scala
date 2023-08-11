/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Abstract Members - Initializing abstract val's
 */
package com.artima.scala5ed.ch20

@main
def s5a_init(): Unit =
  /**
   * defining a rational number as a trait with abstract val's
   */
  trait RationalTrait:
    val numerator: Int
    val denominator: Int

    // The initialization from the derived class is _not_ seen here!
    println(s"In trait initialization: $numerator / $denominator")

    // But after the object instantiation the things goes as expected
    override def toString: String = s"$numerator / $denominator"

  /**
   * r is instance of an anonymous class that mixes in the trait
   */
  val r = new RationalTrait:
    override val numerator: Int = 1
    override val denominator: Int = 2

  println("The object is fully constructed: " + r)
