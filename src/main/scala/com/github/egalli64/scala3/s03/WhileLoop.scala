/*
  https://docs.scala-lang.org/scala3/book/taste-control-structures.html
  https://github.com/egalli64/scala-playground

  Control structures: while loop
 */
package com.github.egalli64.scala3.s03

@main def whileLoop(): Unit =
  var count = 3
  while count > 0 do
    println(count)
    count -= 1
  println("done")
