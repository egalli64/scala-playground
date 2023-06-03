/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Traits - Trait parameters
 */
package com.artima.scala5ed.ch11

@main
def s5param(): Unit =
  /**
   * A trait can take parameters - evaluated immediately before trait initialization
   */
  trait Philosophical(message: String):
    def philosophize: String = message

  class Animal:
    override def toString: String = "Animal"

  class Frog extends Animal, Philosophical("I croak, therefore I am!")
  class Duck extends Animal, Philosophical("I quack, therefore I am!")

  println((new Frog).philosophize)
  println((new Duck).philosophize)

  class ProfoundAnimal extends Animal, Philosophical("In the beginning was the deed.")
  println((new ProfoundAnimal).philosophize)

  // Can't initialize Philosophical, the job is taken by ProfoundAnimal
  class Toad extends ProfoundAnimal, Philosophical
  println((new Toad).philosophize)
