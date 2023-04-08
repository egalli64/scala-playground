/*
  https://docs.scala-lang.org/scala3/book/types-adts-gadts.html
  https://github.com/egalli64/scala-playground

  Types and the Type System - Algebraic Data Types - enum

  Algebraic Data Types (ADTs) can be created with the enum construct
 */
package com.github.egalli64.scala3.b12

@main
def e3enum(): Unit =
  // An enumeration is used to define a type consisting of a set of named values
  enum Color:
    case Red, Green, Blue

  val colors = List(Color.Blue, Color.Blue, Color.Red, Color.Green)
  println(colors)

  /*
  // Same, explicit
  enum Color:
    case Red extends Color
    case Green extends Color
    case Blue extends Color

  val colors = List(Color.Blue, Color.Blue, Color.Red, Color.Green)
  println(colors)
   */

  // Parametrized enum
  enum Color2(val rgb: Int):
    case Red extends Color2(0xff0000)
    case Green extends Color2(0x00ff00)
    case Blue extends Color2(0x0000ff)

  println("Color2 Green RGB is " + Color2.Green.rgb)

  // Custom Definitions
  enum Planet(mass: Double, radius: Double):
    private final val G = 6.67300e-11

    def surfaceGravity = G * mass / (radius * radius)

    def surfaceWeight(otherMass: Double) = otherMass * surfaceGravity

    case Mercury extends Planet(3.303e+23, 2.4397e6)
    case Venus extends Planet(4.869e+24, 6.0518e6)
    case Earth extends Planet(5.976e+24, 6.37814e6)
    // etc

  // Companion object for enum
  object Planet:
    def earthToPlanets(earthWeight: Double) =
      val mass = earthWeight / Earth.surfaceGravity
      for (p <- values)
        println(s"Your weight on $p is ${p.surfaceWeight(mass)}")

  Planet.earthToPlanets(42.0)
