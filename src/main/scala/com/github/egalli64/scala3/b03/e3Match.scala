/*
  https://docs.scala-lang.org/scala3/book/control-structures.html
  https://github.com/egalli64/scala-playground

  Match
 */
package com.github.egalli64.scala3.b03

import scala.annotation.switch
import scala.util.Random

enum WeekDay:
  case Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday

@main
def matching(): Unit =
  import WeekDay.*
  // 1. Used like a Java switch expression, with its optional annotation
  @switch
  val day = Random.nextInt(8) match
    case 0 => Sunday
    case 1 => Monday
    case 2 => Tuesday
    case 3 => Wednesday
    case 4 => Thursday
    case 5 => Friday
    case 6 => Saturday
    // catch-all-case, similar to the default for a Java switch, must be the last case
    case _ => throw IllegalStateException("Doomsday!")
  println(day)

  // 1b. Used like a Java switch statement, with default value
  day match
    case Saturday => println("Time to having fun")
    case Sunday   => println("Time to relax")
    // catch-all-case, the actual value is assigned to a local variable that could be used on the rhs
    case cur => println(s"Today is $cur, right, it is only $day")

  // 1c. Multi-match
  day match
    case Tuesday | Wednesday | Thursday => println("Core working day")
    case Monday | Friday                => println("Border day")
    case _                              => println("Weekend")

  // 2. If guards in case clause
  day match
    case x if x != Monday && x.ordinal < Friday.ordinal => println("Lot of things to do ...")
    case x if x == Monday || x == Friday => println("Take it easy")
    case _ => println("Weekend")

  // 2b. Guards with ranges
  val x = Random.nextInt(40)
  x match
    case a if 0 to 9 contains a => println(s"0-9 range: $a")
    case b if 10 to 19 contains b => println(s"10-19 range: $b")
    case c if 20 to 29 contains c => println(s"20-29 range: $c")
    case _ => println(s"Hmmm... ($x)")

  // 3. Match on case class
  case class Person(name: String)

  def greet(p: Person): Unit = p match
    case Person(name) if name == "Tim" || name == "Kim" => println(s"Welcome back, ${name}my!")
    case Person(name) if name == "Bill" => println(s"Welcome back, ${name}y!")
    case _ => println("Hi, " + p.name)

  greet(Person("Bob"))
  greet(Person("Kim"))
