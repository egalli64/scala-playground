/*
  https://docs.scala-lang.org/scala3/book/taste-control-structures.html
  https://github.com/egalli64/scala-playground

  Control structures: if - else
 */
package com.github.egalli64.s03

import scala.math.random

@main def ifElse() : Unit =
  val x = random() - .5
  print(s"x is a ${x.getClass} set to $x: ")

  // if - else if - else as a statement
  if x < 0 then
    println("negative")
  else if x == 0 then
    println("zero")
  else
    println("positive")

  // if - else if - else is actually an expression
  val check = if x < 0 then "negative" else "positive or zero"
  println("The value of x is " + check)
