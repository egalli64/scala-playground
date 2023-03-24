/*
  https://docs.scala-lang.org/scala3/book/methods-main-methods.html
  https://github.com/egalli64/scala-playground

  Main Methods in Scala 3
 */
package com.github.egalli64.scala3.b07

import scala.util.CommandLineParser

/*
  The method annotated @main is the entry point of an executable program
  Run it from shell passing the actual fileName.scala to scala
  Or, from sbt, run
    when more @main are available, sbt asks which one it should run

  The method should be accessed statically, so it can't be defined in a class (but in an object)

  The return type should be Unit
 */
@main
def aboutMain(): Unit =
  println("Hello, Scala")

/**
 * At least two argument, otherwise -> Illegal command line: more arguments expected
 *
 * Wrong type argument -> Illegal command line: java.lang.NumberFormatException: For input ...
 *
 * A star after a parameter type says it is a vararg (0, 1, ... values)
 *
 * @param age
 *   the age
 * @param name
 *   the name
 * @param others
 *   other strings
 */
@main
def happyBirthday(age: Int, name: String, others: String*): Unit =
  val suffix = age % 100 match
    case 11 | 12 | 13 => "th"
    case _ =>
      age % 10 match
        case 1 => "st"
        case 2 => "nd"
        case 3 => "rd"
        case _ => "th"

  val sb = StringBuilder(s"Happy $age$suffix birthday, $name")
  for other <- others do sb.append(" and ").append(other)
  println(sb.toString)

/**
 * If we want out main to accept custom type, some extra work required
 */
enum Color:
  case Red, Blue, Green

/**
 * Tell the command line parser how to convert a string to our type
 */
given CommandLineParser.FromString[Color] with {
  override def fromString(s: String): Color = Color.valueOf(s)
}

/**
 * Now we can use our custom type
 *
 * Or Illegal command line: java.lang.IllegalArgumentException: enum case not found: ...
 *
 * @param color
 *   a color
 */
@main
def paint(color: Color): Unit =
  println(s"Color is $color")
