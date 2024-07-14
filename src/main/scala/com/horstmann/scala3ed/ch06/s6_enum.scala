/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  6. Objects and Enumeration
   6. Enumerations - close to Java
 */
package com.horstmann.scala3ed.ch06

@main
def s6_enum(): Unit =
  enum TrafficLightColor:
    case Red, Yellow, Green

  // implicit call to toString for an enum - notice the Scala naming convention
  println("The yellow TrafficLightColor enum is " + TrafficLightColor.Yellow)

  // every enum has an ordinal method
  println("Its ordinal is " + TrafficLightColor.Yellow.ordinal)

  // fromOrdinal()
  println("Build an enum from its ordinal: " + TrafficLightColor.fromOrdinal(1))

  // values
  println("The TrafficLightColor are: " + TrafficLightColor.values.mkString(" "))

  // valueOf
  println("The yellow TrafficLightColor: " + TrafficLightColor.valueOf("Yellow"))

  // explicit call to toString
  println("Enum to string: " + TrafficLightColor.Yellow.toString)

  /**
   * An enum with a custom methods
   */
  enum TrafficLightColor2:
    case Red, Yellow, Green

    /**
     * The next enum (by ordinal)
     *
     * @return
     *   the next color
     */
    def next: TrafficLightColor = TrafficLightColor.fromOrdinal((ordinal + 1) % 3)

  // calling a custom method
  println("The next to yellow (custom method): " + TrafficLightColor2.Yellow.next)

  /**
   * Adding a method to an enum companion object
   */
  object TrafficLightColor:
    def random(): TrafficLightColor = TrafficLightColor.fromOrdinal(scala.util.Random.nextInt(3))

  // calling the companion custom method
  val color = TrafficLightColor.random()
  println(s"A random color (companion custom method), $color")

  /**
   * An enum with a state, here, the light description
   *
   * Notice the "extends", each enum is an object extending the enum
   */
  enum TrafficLightColor3(val description: String):
    case Red extends TrafficLightColor3("Stop")
    case Yellow extends TrafficLightColor3("Hurry up")
    case Green extends TrafficLightColor3("Go")

  println("Yellow description is: " + TrafficLightColor3.Yellow.description)

  /**
   * An enum instance could be deprecated
   */
  enum TrafficLightColor4:
    case Red, Yellow, Green
    @deprecated("Put your details here") case Blue

  // Blue can be used, but the compiler warns about the deprecation
//  println(TrafficLightColor4.Blue)

/**
 * A Scala enum compatible with Java enum should be declared in a static scope
 */
enum TrafficLightColor5 extends Enum[TrafficLightColor5]:
  case Red, Yellow, Green
