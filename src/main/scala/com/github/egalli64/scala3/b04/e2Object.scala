/*
  https://docs.scala-lang.org/scala3/book/domain-modeling-tools.html
  https://github.com/egalli64/scala-playground

  Domain Modeling - Tools - Object
 */
package com.github.egalli64.scala3.b04

import scala.math.{Pi, pow}

/**
 * 1: An "object" is a singleton - a class that has exactly one instance
 *
 * Initialized lazily when its members are referenced - see "lazy val"
 *
 * The effect is like the one achieved by Java using static on its members
 */
object MyUtils:
  val Pi = 3.141592653589793
  def truncate(s: String, length: Int): String = s.take(length)
  def containsWhitespace(s: String): Boolean = s.matches(".*\\s.*")
  def isNullOrEmpty(s: String): Boolean = s == null || s.trim.isEmpty

/**
 * 3a: A "companion class" has a "companion object". Same name, declared in the same file.
 *
 * In Java the companion object is the static part of a class
 *
 * @param radius
 *   the circle radius
 */
class Circle(val radius: Double):
  def area: Double = Circle.calculateArea(radius)

/**
 * 3b: The companion object here has a single private method, it can be accessed only from the
 * object and its companion class
 */
object Circle:
  private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)

/**
 * 4a: A class companion could have factory method in its object companion, named "apply" and
 * working as constructor
 *
 * This class has no constructor
 */
class PersonX:
  var name = ""
  var age = 0
  override def toString = s"$name is $age years old"

/**
 * 4b: The companion object provides two factory methods
 */
object PersonX:
  /**
   * A one-arg factory method
   *
   * @param name
   *   person name
   * @return
   *   the person instance
   */
  def apply(name: String): PersonX =
    val p = new PersonX
    p.name = name
    p

  /**
   * A two-arg factory method
   *
   * @param name
   *   person name
   * @param age
   *   person age
   * @return
   *   the person instance
   */
  def apply(name: String, age: Int): PersonX =
    val p = new PersonX
    p.name = name
    p.age = age
    p

@main
def objects(): Unit =
  /**
   * 1: Calling a member on an object is like calling a static member in Java
   */
  println(MyUtils.truncate("Tom Jones", 3))

  /**
   * 2: import from an object all members or just what is needed
   */
  // import MyStringUtils.*
  import MyUtils.{Pi, containsWhitespace, isNullOrEmpty}
  println("Is there at least a whitespace in that string? " + containsWhitespace("Tom Jones"))
  println("Is null or empty? " + isNullOrEmpty(""))
  println("PI is " + Pi)

  /**
   * 3: Create an object from a class with companion object
   */
  val circle1 = Circle(5.0)
  println("The circle area is: " + circle1.area)

  // Won't compile, not accessible
  // Circle.calculateArea(4.2)

  val joe = PersonX("Joe")
  val fred = PersonX("Fred", 29)

  println(s"$joe, $fred")
