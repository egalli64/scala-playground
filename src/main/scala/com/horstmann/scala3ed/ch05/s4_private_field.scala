/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  5. Classes
   4. Private Fields
 */
package com.horstmann.scala3ed.ch05

@main
def s4_private_field(): Unit =
  class Counter:
    /**
     * Getter and setter are _not_ accessible outside the current class
     */
    private var value = 0

    /**
     * private field accessible from a method in the current object
     */
    def increment(): Unit = value += 1

    /**
     * private field accessible from a method in an object of the same class
     *
     * @param other
     *   another Counter
     * @return
     *   true if the current counter is less than the other one
     */
    def isLess(other: Counter): Boolean = value < other.value

  val c1 = Counter()
  val c2 = Counter()
  c2.increment()

  println("Is c1 less than c2? " + c1.isLess(c2))
