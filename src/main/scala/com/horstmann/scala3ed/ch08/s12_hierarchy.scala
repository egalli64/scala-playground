/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  8. Inheritance
   12. The Scala Inheritance Hierarchy
 */
package com.horstmann.scala3ed.ch08

@main
def s12_hierarchy(): Unit =
  class Account(var balance: Double)

  class Person(val name: String):
    // a NotImplementedError will be thrown (and a warning issued)
    def description: String = ???

  val account = new Account(1000.0)
  val amount = 100.0

  // a synchronized block on the account object
  account.synchronized {
    account.balance += amount
  }
  println(account.balance)

  val p = Person("Wilma")

  try println(p.description)
  catch case ex: NotImplementedError => println("Can't call description, " + ex)

  def showAny(o: Any): Unit = println(s"${o.getClass.getName}: $o")

  def showUnit(o: Unit): Unit = println(s"${o.getClass.getName}: $o")

  println("Calling showAny the passed String is upcasted to Any")
  showAny("Hello")

  // "Hello" is replaced with () (with a warning)
  println("A Unit can also be (), other assignment are discarded with a warning")
  showUnit("Hello")
