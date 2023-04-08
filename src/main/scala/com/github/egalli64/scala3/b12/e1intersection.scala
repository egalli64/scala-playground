/*
  https://docs.scala-lang.org/scala3/book/types-intersection.html
  https://github.com/egalli64/scala-playground

  Types and the Type System - Intersection Types
 */
package com.github.egalli64.scala3.b12

trait Resettable:
  def reset(): Unit

trait Growable[A]:
  def add(a: A): Unit

/**
 * The type A & B represents values that are both of the type A and of the type B at the same time
 *
 * @param x
 *   should be of a type both Resettable and Growable[String]
 */
def f(x: Resettable & Growable[String]): Unit =
  x.reset()
  x.add("First")

@main
def e1intersection(): Unit =
  class Info() extends Resettable, Growable[String]:
    private var data: List[String] = Nil

    override def reset(): Unit =
      this.data = Nil

    override def add(a: String): Unit =
      data = data :+ a

    override def toString: String =
      data.mkString("[", ", ", "]")

  val info: Info = Info()
  info.add("Tom")
  info.add("Kim")
  println(info)

  f(info)
  info.add("Bob")
  println(info)
