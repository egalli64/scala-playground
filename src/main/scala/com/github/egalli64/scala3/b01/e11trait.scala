/*
  https://docs.scala-lang.org/scala3/book/taste-modeling.html
  https://github.com/egalli64/scala-playground

  OOP Domain Modeling: trait
 */
package com.github.egalli64.scala3.b01

trait Speaker:
  def speak: String // has no body, so it’s abstract

trait Wagger:
  def startTail(): Unit = println("tail is wagging")
  def stopTail(): Unit = println("tail is stopped")

trait Runner:
  def startRunning(): Unit = println("I’m running")
  def stopRunning(): Unit = println("Stopped running")

class Dog(name: String) extends Speaker, Wagger, Runner:
  def speak: String = name + ": woof!"

class Cat(name: String) extends Speaker, Wagger, Runner:
  def speak: String = name + ": meow"
  override def startRunning(): Unit = println("Yeah ... I don’t run")
  override def stopRunning(): Unit = println("No need to stop")

@main def traits(): Unit =
  // Wagger is a trait; it cannot be instantiated
//  val w = new Wagger()

  val d = Dog("Rover")
  d.startTail()
  println(d.speak)
  d.stopTail()

  val c = Cat("Morris")
  println(c.speak)
  c.startRunning()
  c.stopRunning()

  println("done")
