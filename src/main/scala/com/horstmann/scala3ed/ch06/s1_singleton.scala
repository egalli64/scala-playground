/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  6. Objects and Enumeration
   1. Singletons
 */
package com.horstmann.scala3ed.ch06

@main
def s1_singleton(): Unit =
  /**
   * No static in Scala, use "object" (singleton) instead
   *
   * Its constructor is lazily called on the first access to the object (so, can't accept arguments)
   */
  object Accounts:
    private var lastNumber = 0

    def newUniqueNumber(): Int =
      lastNumber += 1
      lastNumber

  println("A unique number: " + Accounts.newUniqueNumber())
  println("Another unique number: " + Accounts.newUniqueNumber())
