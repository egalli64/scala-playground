/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  8. Inheritance
   5. Anonymous Subclasses
 */
package com.horstmann.scala3ed.ch08

@main
def s05_anon_sub(): Unit =
  class Person(val name: String):
    def greeting = s"Hello, my name is $name"

  /**
   * alien is an instance of an anonymous Person subclass implementing its own override of greeting
   */
  val alien = new Person("Tweel"):
    override def greeting = "Greetings, Earthling!"

  println(alien.greeting)
