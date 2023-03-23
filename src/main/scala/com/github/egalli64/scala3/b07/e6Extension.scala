/*
  https://docs.scala-lang.org/scala3/book/methods-most.html
  https://github.com/egalli64/scala-playground

  Method Features - extension
 */
package com.github.egalli64.scala3.b07

/**
 * Given a class that for any reason can't be changed, we can use extension
 *
 * @param x
 *   X position
 * @param y
 *   Y position
 * @param radius
 *   the radius
 */
case class Circle(x: Double, y: Double, radius: Double)

/**
 * A class extension could be placed other file than the referenced class.
 */
extension (c: Circle)
  def circumference: Double = c.radius * math.Pi * 2
  def diameter: Double = c.radius * 2
  def area: Double = math.Pi * c.radius * c.radius

@main
def anExtension(): Unit =
  val aCircle = Circle(0, 0, 5)

  println(s"Standard circle features: ${aCircle.x}, ${aCircle.y}, ${aCircle.radius}")
  println(s"Extended circle features: ${aCircle.circumference}, ${aCircle.diameter}, ${aCircle.area}")
