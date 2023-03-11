/*
  https://docs.scala-lang.org/scala3/book/domain-modeling-tools.html
  https://github.com/egalli64/scala-playground

  Domain Modeling - Tools - Enum, additional features
 */
package com.github.egalli64.scala3.b04

import scala.util.Random

/**
 * 1: Parametrized enum
 */
enum Color(val rgb: Int):
  case Red extends Color(0xff0000)
  case Green extends Color(0x00ff00)
  case Blue extends Color(0x0000ff)

/**
 * 2. Parametrized enum with members
 */
enum Planet(mass: Double, radius: Double):
  private final val G = 6.67300e-11
  def surfaceGravity: Double = G * mass / (radius * radius)
  def surfaceWeight(otherMass: Double): Double =
    otherMass * surfaceGravity

  case Mercury extends Planet(3.303e+23, 2.4397e6)
  case Earth extends Planet(5.976e+24, 6.37814e6)

/**
 * 3. Java enum compatibility
 */
enum JColor extends Enum[JColor] { case Red, Green, Blue }

@main
def enumPlus(): Unit =
  /**
   * 1: Parametrized enum
   */
  val myColor = Color.fromOrdinal(Random.nextInt(Color.values.length))
  println(s"$myColor coded as Ox${myColor.rgb.toHexString}")
  println("The red RGB value is " + Color.Red.rgb)

  /**
   * 2. Parametrized enum with members
   */
  val myPlanet = Planet.values(Random.nextInt(Planet.values.length))
  print(s"On $myPlanet gravity is ${myPlanet.surfaceGravity}")
  val x = 100
  println(s" and $x mass has weight ${myPlanet.surfaceWeight(x)}")

  /**
   * 3. Java enum compatibility
   */
  val jColor = JColor.values(Random.nextInt(JColor.values.length))
  print(s"Java-compatible enum: $jColor as ")
  jColor match
    case JColor.Blue  => println("water")
    case JColor.Green => println("grass")
    case JColor.Red   => println("strawberry")
