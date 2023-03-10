/*
  https://docs.scala-lang.org/scala3/book/domain-modeling-tools.html
  https://github.com/egalli64/scala-playground

  Domain Modeling - Tools - Abstract class
 */
package com.github.egalli64.scala3.b04

/**
 * 1: Legacy, in Scala 2, only abstract class could have construct arguments
 *
 * @param name
 *   the pet name
 */
abstract class Pet(name: String):
  def greeting: String
  def age: Int
  override def toString = s"My name is $name, I say $greeting, and I’m $age"

/**
 * 2: In Scala 3, a trait can have parameters, leading to the same effect
 */
trait Pet3(name: String):
  def greeting: String
  def age: Int
  override def toString = s"My name is $name, I say $greeting, and I’m $age"

@main
def abstractClass(): Unit =
  /**
   * 1: Dog extends the abstract class Pet
   *
   * @param name
   *   the pet name
   * @param age
   *   the dog age
   */
  class Dog(name: String, var age: Int) extends Pet(name):
    val greeting = "Woof"

  val bob = Dog("Bob", 42)
  println(bob)

  /**
   * 2: Cat extends the trait Pet3
   *
   * @param name
   *   the cat name
   * @param age
   *   the cat age
   */
  class Cat(name: String, var age: Int) extends Pet3(name):
    val greeting = "Meow"

  val jim = Cat("Jim", 24)
  println(jim)
