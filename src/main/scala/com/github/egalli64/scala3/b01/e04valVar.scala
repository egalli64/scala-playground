/*
  https://docs.scala-lang.org/scala3/book/taste-vars-data-types.html
  https://github.com/egalli64/scala-playground

  Variable declaration by var and val
 */
package com.github.egalli64.scala3.b01

@main def valVar(): Unit =
  // immutable
  val a = 1
  // mutable
  var b = 2

  println("a is " + a)
  println("b is " + b)

  // a += 1
  b += 1
  println("now b is " + b)

  val msg1 = "Won't change"
  var msg2 = "Could be reassigned"
  println(msg1 + " - vs - " + msg2)
  // msg1 = "Won't compile"
  msg2 = "Reassigned to other string"
  println(msg1 + " - vs - " + msg2)
