/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Classes and Objects - Semicolon inference
 */
package com.artima.scala5ed.ch04

@main
def s2semicolon(): Unit =
  // semicolon is rarely required in Scala
  // mandatory in case of multiple statement on a single line (yuck!)
  val s = "hello"; println(s)

  // The compiler is smart enough to detect what is going on (formatting is another story)
  val t =
    if s.length < 10
    then "too small"
    else "ok"
  println(t)
