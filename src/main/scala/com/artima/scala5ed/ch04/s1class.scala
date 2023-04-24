/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Classes and Objects - Classes, fields, and methods
 */
package com.artima.scala5ed.ch04

@main
def s1class(): Unit =
  // class as blueprint for objects

  /**
   * A placeholder class
   */
  class ChecksumAccumulator:
    // class definition goes here, indented

    // A field - it is a var, imperative approach
    // Each object has its own copy - so it is also known as _instance variable_
    // if not specified otherwise, class members have _public_ access level - NOT GOOD for fields (see below)
    var sum = 0

    // An overridden method
    override def toString: String = s"{$sum}"

  // Explicit creation of objects
  val a = new ChecksumAccumulator
  val b = new ChecksumAccumulator

  // val: the objects are mutable - sum is a var - but the reference is constant, can't be reassigned
  // a = new ChecksumAccumulator

  // Each object has its own state - a memory image
  b.sum = 42

  // Accessing the new objects
  println(s"$a and $b")

  /**
   * ChecksumAccumulator version 2
   */
  class ChecksumAccumulator2:
    // Robustness: prevent direct access from outside
    private var sum = 0

    /**
     * A method that mutates the state of the object
     *
     * Return type Unit means side effect - mutator (as here) or I/O action - it is a procedure
     *
     * @param b
     *   all parameters are val
     */
    def add(b: Byte): Unit =
      // b = 42 // won't compile
      sum += b

    /**
     * A method that grants access (in some way) the the object state
     *
     * Implicit "return" for last computed value: a method is an expression yielding a value
     *
     * Prefer one-liner, when applicable
     *
     * @return
     *   the object checksum - prefer explicit return type, the user will be grateful
     */
    def checksum(): Int = ~(sum & 0xff) + 1

    override def toString: String = s"{$sum}"

  // Explicit creation of a new object
  val c = new ChecksumAccumulator2

  // Change object status by mutator
  for _ <- 1 to 3 do c.add(120)

  // Check result by accessors
  println(s"$c: " + c.checksum())
