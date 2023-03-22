/*
  https://docs.scala-lang.org/scala3/book/methods-most.html
  https://github.com/egalli64/scala-playground

  Method Features - visibility in classes
 */
package com.github.egalli64.scala3.b07

/**
 * In classes, objects, traits, and enums, methods are public by default
 *
 * Otherwise, they could be private or protected
 */
class Animal:
  // visible only in the current class
  private def breathe(): Unit = println("I’m breathing")

  // visible to everyone
  def walk(): Unit =
    breathe()
    println("I’m walking")

  // visible in the current class and subclasses (that's it)
  protected def speak(): Unit = println("Hello?")

class Cat extends Animal:
  override def speak(): Unit = println("Meow")

  // won’t compile
  // override def breathe = println("Yo, I’m totally breathing")

@main
def visibility(): Unit =
  val tom = Cat()

  tom.speak()
  tom.walk()

  // no access to Animal::breathe from here
  // tom.breathe
