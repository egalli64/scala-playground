/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Typeclasses - Multiversal equality
 */
package com.artima.scala5ed.ch23

@main
def s4_equality(): Unit =
  val s1 = "Hello"
  val s2 = "Hell" + "o"
  if (s1 == s2) {
    println(s"Universal equality: $s1 == $s2")
  }

  val optStr = Option(s1)
  // won't compile: can't compare String with Option[String]
  // if (s1 == optStr) { println("Unexpected") }

  case class Apple(size: Int) derives CanEqual

  // non idiomatic alternative to deriving CanEqual
  //  object Apple:
  //    given canEq: CanEqual[Apple, Apple] = CanEqual.derived

  val appleTwo = Apple(2)
  val appleTwoToo = Apple(2)
  println(s"Comparing apple with apple: ${appleTwo == appleTwoToo}")

  case class Orange(size: Int)
  val orangeTwo = Orange(2)

  // "derives" states that only apples can be compared to apples
  // println(appleTwo == orangeTwo)

  // instead of "derives", strict equality could be used
//  import scala.language.strictEquality
