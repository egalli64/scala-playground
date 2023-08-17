/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Abstract Members - Initializing abstract val's

  Lazy val's: the right-hand side will be evaluated the first time the val is used
 */
package com.artima.scala5ed.ch20

import scala.annotation.tailrec

@main
def s5c_lazy(): Unit =
  object Demo:
    val x: String = { println("initializing x"); "done" }

  println("As soon as the object is accesses, its data member is initialized")
  println("Access Demo: " + Demo)
  println("Access Demo.x: " + Demo.x)
  println()

  object LazyDemo:
    lazy val x: String = { println("initializing x"); "done" }

  println("Access LazyDemo: " + LazyDemo)
  println("The data member is initialized the first time it is accessed")
  println("Access LazyDemo.x: " + LazyDemo.x)

  /*
    A trait with lazy val's
   */
  trait LazyRationalTrait:
    val numeratorArg: Int
    val denominatorArg: Int

    lazy val numerator: Int = numeratorArg / g
    lazy val denominator: Int = denominatorArg / g

    override def toString = s"$numerator/$denominator"

    private lazy val g =
      require(denominatorArg != 0)
      gcd(numeratorArg, denominatorArg)

    @tailrec
    private def gcd(a: Int, b: Int): Int = if b == 0 then a else gcd(b, a % b)

  val x = 42
  val lr = new LazyRationalTrait:
    override val numeratorArg: Int = 1 * x
    override val denominatorArg: Int = 2 * x

  println(lr)
