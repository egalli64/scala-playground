/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Classes and Objects - Singleton objects
 */
package com.artima.scala5ed.ch04

import scala.collection.mutable

@main
def s3singleton(): Unit =
  // No static members in Scala - the singleton object is used instead
  // We can have class and object companions - they should be defined in the same file
  class ChecksumAccumulator:
    private var sum = 0

    def add(b: Byte): Unit = sum += b

    def checksum(): Int = ~(sum & 0xff) + 1

    /**
     * Companions can access each other's private members
     */
    def f(): Unit = println(
      "Accessing private member from the companion class: " + ChecksumAccumulator.cache
    )

  // a singleton object is initialized the first time some code accesses it - no parameter could be passed
  object ChecksumAccumulator:
    private val cache = mutable.Map.empty[String, Int]

    def calculate(s: String): Int =
      if cache.contains(s) then cache(s)
      else
        // "new" instantiate object of a _class_, no ambiguity here (no "new" for singleton object)
        val acc = new ChecksumAccumulator
        // Strings are iterable in Scala, here we loop on each char of the input string
        for c <- s do
          acc.add((c >> 8).toByte)
          acc.add(c.toByte)

        println("Accessing private member from the companion object: " + acc.sum)
        val cs = acc.checksum()
        cache += s -> cs
        cs

  println("Checksum for hello is: " + ChecksumAccumulator.calculate("hello"))
  val x = ChecksumAccumulator()
  x.f()
