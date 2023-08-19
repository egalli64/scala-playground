/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Abstract Members - Abstract types
 */
package com.artima.scala5ed.ch20

@main
def s6_type(): Unit =
  class Food:
    override def toString: String = "food"

  abstract class ImpreciseAnimal:
    def eat(food: Food): Unit

  class Grass extends Food:
    override def toString: String = "grass"

  // won't compile eat should expect a Food parameter, Grass would not do!
//  class Cow extends ImpreciseAnimal:
//    override def eat(food: Grass) = {}

  /**
   * An animal object eats suitable food
   */
  abstract class Animal:
    /**
     * A subclass of Food
     */
    type SuitableFood <: Food
    def eat(food: SuitableFood): Unit

  /**
   * An animal having Grass as SuitableFood
   */
  class Cow extends Animal:
    type SuitableFood = Grass
    override def eat(food: Grass): Unit = println("Eating " + food)

  class Fish extends Food:
    override def toString: String = "fish"

  val bessy = new Cow

  // won't compile, Fish is not SuitableFood for a Cow
  // bessy.eat(new Fish)

  // Grass is SuitableFood for a Cow
  bessy.eat(new Grass)
