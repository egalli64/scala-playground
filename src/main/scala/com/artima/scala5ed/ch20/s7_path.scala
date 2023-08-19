/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Abstract Members - Path-dependent types
 */
package com.artima.scala5ed.ch20

@main
def s7_path(): Unit =
  class Food:
    override def toString: String = "food"

  abstract class Animal:
    type SuitableFood <: Food
    def eat(food: SuitableFood): Unit

  class Grass extends Food:
    override def toString: String = "grass"

  class Cow extends Animal:
    type SuitableFood = Grass
    override def eat(food: Grass): Unit = println("Cow eating " + food)

  class DogFood extends Food:
    override def toString: String = "dog food"

  class Dog extends Animal:
    type SuitableFood = DogFood
    override def eat(food: DogFood): Unit = println("Dog eating " + food)

  val bessy = new Cow
  bessy.eat(new bessy.SuitableFood)

  val lassie = new Dog
  // won't compile
//  lassie.eat(new bessy.SuitableFood)

  val booty = new Dog
  // this is fine
  lassie.eat(new booty.SuitableFood)
