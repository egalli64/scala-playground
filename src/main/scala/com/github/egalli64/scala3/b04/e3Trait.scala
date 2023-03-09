/*
  https://docs.scala-lang.org/scala3/book/domain-modeling-tools.html
  https://github.com/egalli64/scala-playground

  Domain Modeling - Tools - Trait
 */
package com.github.egalli64.scala3.b04

/**
 * 1: Trait is similar to Java interface
 *
 * Using "def" we let the implementer decide if it actually is a def, val, lazy val, or object
 */
trait Employee:
  def id: Int
  def firstName: String
  def lastName: String

/**
 * 1a: class extending a trait. No need of "override" keyword when implementing a method
 * @param id
 *   employee id
 * @param firstName
 *   employee first name
 * @param lastName
 *   employee last name
 */
class MyEmployee(val id: Int, val firstName: String, val lastName: String) extends Employee:
  override def toString: String = s"$id: $firstName $lastName"

/**
 * 2: Traits can contain both methods and fields (abstract or concrete)
 */
trait HasLegs:
  def numLegs: Int
  def walk(): Unit
  def stop(): Unit = println("Stopped walking")

trait HasTail:
  def tailColor: String
  def wagTail(): Unit = println("Tail is wagging")
  def stopTail(): Unit = println("Tail is stopped")

/**
 * 2a: Classes implementing traits with already defined methods
 */
class Millipede extends HasLegs:
  val numLegs = 1_000
  def walk(): Unit = println(s"Moving all $numLegs legs")
  override def toString: String = s"A millipede"

class IrishSetter(name: String) extends HasLegs, HasTail:
  val numLegs = 4
  val tailColor = "Red"
  def walk(): Unit = println(s"I ($name) am walking on all my $numLegs legs")
  override def toString = s"$name is a Dog"

@main
def trailing(): Unit =
  // 1a: instancing a class that has a trait
  val tom = MyEmployee(42, "Tom", "Holz")
  println(tom)

  // 2a: instancing classes having traits
  val bob = Millipede()
  println(bob)
  bob.walk()
  bob.stop()

  val kim = IrishSetter("Kim")
  println(kim)
  kim.walk()
  kim.wagTail()
  kim.stopTail()
