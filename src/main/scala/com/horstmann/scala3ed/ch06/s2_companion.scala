/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  6. Objects and Enumeration
   2. Companion Objects
    A class and its companion object can access each other's private members
    They should be in the same source file
 */
package com.horstmann.scala3ed.ch06

@main
def s2_companion(): Unit =
  class Account:
    val id: Int = Account.newUniqueNumber()
    private var balance = 0.0

    def deposit(amount: Double): Unit =
      balance += amount

  object Account: // The companion object
    private var lastNumber = 0

    private def newUniqueNumber() =
      lastNumber += 1
      lastNumber

  val acc = Account()
  println("The generated account has id " + acc.id)
