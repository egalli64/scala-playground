/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Abstract Members - Refinement types

  Nominal subtyping is the "normal" one (by extension)
  Structural subtyping is by compatible member, achieved in Scala by refinement types
    example: Animal { type SuitableFood = Grass }
 */
package com.artima.scala5ed.ch20

@main
def s8_refinement(): Unit =
  class Food:
    override def toString: String = "food"

  abstract class Animal:
    type SuitableFood <: Food

  class Grass extends Food:
    override def toString: String = "grass"

  class Cow extends Animal:
    type SuitableFood = Grass
    override def toString: String = "a cow"

  class Sheep extends Animal:
    type SuitableFood = Grass
    override def toString: String = "a sheep"

  class DogFood extends Food:
    override def toString: String = "dog food"

  class Dog extends Animal:
    type SuitableFood = DogFood
    override def toString: String = "a dog"

  class Pasture:
    var animals: List[Animal { type SuitableFood = Grass }] = Nil

  val pasture = new Pasture
  pasture.animals ::= new Cow
  pasture.animals ::= new Sheep
  // won't compile
  // pasture.animals ::= new Dog
  println(pasture.animals)
