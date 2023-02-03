/*
  https://docs.scala-lang.org/scala3/book/taste-objects.html
  https://github.com/egalli64/scala-playground

  Singleton Objects
 */
package com.github.egalli64.scala3.b01

import scala.math.{Pi, pow}

/**
 *   1. Object as a namespace for utility methods (there is no static keyword in Scala)
 */
object StringUtils:
  def isNullOrEmpty(s: String): Boolean = s == null || s.trim.isEmpty
  def leftTrim(s: String): String = s.replaceAll("^\\s+", "")
  def rightTrim(s: String): String = s.replaceAll("\\s+$", "")

/**
 * 2a. Companion class, can access the private members of its companion
 *
 * @param radius
 *   instance status
 */
class Circle(radius: Double):
  import Circle.*
  def area: Double = calculateArea(radius)

  override def toString: String = s"a circle with radius $radius"

/**
 * 2b. Companion object, provides utility methods for a companion class
 */
object Circle:
  private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)

/**
 * 3a. Defining a first trait, module for more complex structures
 */
trait AddService:
  def add(a: Int, b: Int): Int = a + b

/**
 * 3b. Defining a second trait, other module
 */
trait MultiplyService:
  def multiply(a: Int, b: Int): Int = a * b

/**
 * 3c. Object to put the modules together
 */
object MathService extends AddService, MultiplyService

@main
def singleton(): Unit =
  // 1. Using an object as a namespace
  import StringUtils.*
  val s1 = "   "
  val s2 = "   hello   "
  println("Check null/empty: " + isNullOrEmpty(s1))
  println(s"s2 is [$s2]")
  println(s"s2 trimmed is [${s2.trim}]")
  println(s"s2 left-trimmed is [${leftTrim(s2)}]")
  println(s"s2 right-trimmed is [${rightTrim(s2)}]")

  // 2. Using a class that refers to its object companion
  val circle = Circle(10)
  println(s"Area of $circle is ${circle.area}")

  // 3. Using an object as a module (composition of other modules)
  import MathService.*
  println("Adding: " + add(1, 1))
  println("Multiplying: " + multiply(2, 2))
