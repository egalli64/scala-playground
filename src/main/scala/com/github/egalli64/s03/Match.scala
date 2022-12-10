/*
  https://docs.scala-lang.org/scala3/book/taste-control-structures.html
  https://github.com/egalli64/scala-playground

  Control structures: match
 */
package com.github.egalli64.s03

import scala.io.StdIn.readLine

@main def matching(): Unit =
  println("Pattern matching by match")
  println(matcher(2))
  println(matcher(42))
  println(matcher(Math.PI))
  println(matcher("hello"))
  println(matcher(List(1, 2, 3, 4)))

def matcher(x: Any) : String = x match
  case i: Int =>
    print("Plain match of an Int ... ")
    i match
      case 1 => "one"
      case 2 => "two"
      case _ => "other"
  case d: Double => "a Double: " + d
  case s: String => "a String: " + s
  case ls: List[_] => "a List: " + ls
  case _ => "unknown"
