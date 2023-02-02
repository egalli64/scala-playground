/*
  https://docs.scala-lang.org/scala3/book/taste-control-structures.html
  https://github.com/egalli64/scala-playground

  Control structures: for loop
 */
package com.github.egalli64.scala3.b01

@main def loop(): Unit =
  val data = List(1, 2, 3, 4, 5)
  print("Plain for loop: ") // <- is called "generator"
  for x <- data do print(x + " ")
  println()

  print("Loop with a guard: ")
  for x <- data // generator
      if x % 2 == 0 // guard
  do print(x + " ")
  println()

  print("Multiple generators and guards: ")
  for i <- 1 to 5
      j <- 'a' to 'e'
      if i % 2 == 0 if j % 2 == 0
  do print(s"($i, $j) ") // 2,b 2,d 4,b 4,d
  println()

  print("For expression with yield to generate a new list from an existing one: ")
  println(for x <- data yield x * 2)

  print("Yield a capitalized list: ")
  println(for x <- List("tom", "bob", "kim") yield x.capitalize)

  print("Yield a guarded list: ")
  println(for f <- List("apple", "banana", "lime", "orange") if f.length > 4 yield f.length)

  println("done")