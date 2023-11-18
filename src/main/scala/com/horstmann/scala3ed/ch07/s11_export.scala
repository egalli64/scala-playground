/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  7. Packages, Imports, end Exports
   11. Exports (as a tool to simplify delegation in composition)
 */
package com.horstmann.scala3ed.ch07

import java.awt.{Color, Point}

@main
def s11_export(): Unit =
  /**
   * Using composition instead of derivation implies delegation, that is not very fun
   *
   * @param color
   *   the color component
   * @param point
   *   the point component
   */
  class ColoredPoint(val color: Color, val point: Point):
    /**
     * Delegate to the getter for red
     *
     * @return
     *   the red component in [0 .. 255]
     */
    def red: Int = color.getRed
    def green: Int = color.getGreen
    def blue: Int = color.getBlue

    val x: Int = point.x
    val y: Int = point.y

  val p1 = ColoredPoint(Color.red, Point(3, 2))
  println(s"p1: (${p1.x}, ${p1.y}) color (${p1.red}, ${p1.green}, ${p1.blue})")

  class ColoredPoint2(val color: Color, val point: Point):
    // delegate to the color getters for RGB
    export color.{getRed as red, getGreen as green, getBlue as blue}

    // delegate to point for x and y
    export point.{x, y}

  val p2 = ColoredPoint2(Color.green, Point(1, 5))
  println(s"p2: (${p2.x}, ${p2.y}) color (${p2.red()}, ${p2.green()}, ${p2.blue()})")
