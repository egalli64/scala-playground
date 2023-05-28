/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Traits - How traits work
  - Kind of Java interface with default methods
  - But
      - it can have fields and a state
      - "super" is dynamically bound, determined when the trait is mixed into a concrete class
 */
package com.artima.scala5ed.ch11

@main
def s1trait(): Unit =
  /**
   * A trait - implicit extension of AnyRef
   */
  trait Philosophical:
    def philosophize = "I consume memory, therefore I am!"

  class Frog extends Philosophical:
    override def toString: String = "green"

  // Philosophical is a trait; it cannot be instantiated
  // val phi = new Philosophical()

  val phi = new Frog
  println(s"$phi: ${phi.philosophize}")

  val ph2 = Frog()
  println(s"$ph2: ${ph2.philosophize}")

  val ph3: Philosophical = phi
  println(ph3.philosophize)

  class Animal
  trait HasLeg

  class Toad extends Animal, HasLeg, Philosophical:
    override def toString = "green"
    override def philosophize = s"It ain't easy being $this!"

  val ph4 = new Toad
  println(ph4.philosophize)
