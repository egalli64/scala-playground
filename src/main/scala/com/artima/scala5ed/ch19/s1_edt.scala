/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Enums - Enumerated data types (EDT)
 */
package com.artima.scala5ed.ch19

@main
def s1_edt(): Unit =
  enum Direction:
    case North, East, South, West

  import Direction.*

  def invert(dir: Direction): Direction =
    dir match
      case North => South
      case East  => West
      case South => North
      case West  => East

  println(s"${North.ordinal}, ${East.ordinal}, ${South.ordinal}, ${West.ordinal}")
  println(s"Opposite $North is: " + invert(North))
  println(s"Available directions: " + Direction.values.mkString(", "))
  println("From string to enum: " + Direction.valueOf("West"))

  try println("From string to (missing) enum: " + Direction.valueOf("Up"))
  catch case ex: IllegalArgumentException => println(ex)

  enum Where(val degrees: Int):
    case North extends Where(0)
    case East extends Where(90)
    case South extends Where(180)
    case West extends Where(270)

    def invert: Where = this match
      case North => South
      case East  => West
      case South => North
      case West  => East

  println(s"${Where.North}, ${Where.East}, ${Where.South}, ${Where.West}")
  println(s"${Where.North} [${Where.North.degrees}] inverted is ${Where.North.invert}")

  object Where:
    def nearestTo(degrees: Int): Where =
      val rem = degrees % 360
      val angle = if rem < 0 then rem + 360 else rem
      val (ne, se, sw, nw) = (45, 135, 225, 315)
      angle match
        case a if a > nw || a <= ne => North
        case a if a > ne && a <= se => East
        case a if a > se && a <= sw => South
        case a if a > sw && a <= nw => West

  println("Nearest to 50 is: " + Where.nearestTo(42))

  def allButNearest(degrees: Int): List[Where] =
    val nearest = Where.nearestTo(degrees)
    Where.values.toList.filter(_ != nearest)

  println("Not nearest: " + allButNearest(42))
