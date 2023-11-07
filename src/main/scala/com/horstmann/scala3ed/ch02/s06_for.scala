/*
Scala for the Impatient Third Edition - Cay S. Horstmann
Source code shown in the book
Download the zip file from: https://horstmann.com/scala/

https://github.com/egalli64/scala-playground

2. Control Structures and Functions
 6. More about the for Loop
 */
package com.horstmann.scala3ed.ch02

@main
def s06_for(): Unit =
  // a double for-loop
  for
    i <- 1 to 3
    j <- 1 to 3
  do print(f"${10 * i + j}%3d")

  println("\n---")

  // use a _guard_ to filter loops
  for
    i <- 1 to 3
    j <- 1 to 3
    if i != j
  do print(f"${10 * i + j}%3d")

  println("\n---")

  // use _definition_ for complex loops
  for
    i <- 1 to 3
    beg = 4 - i
    j <- beg to 3
  do print(f"${10 * i + j}%3d")

  println("\n---")

  // use a _for comprehension_ to generate a collection of values
  val result = for i <- 1 to 10 yield i % 3
  println("Values generated: " + result)

  // the generated result is compatible with the generator
  val encoded = for c <- "Hello" yield (c + 1).toChar
  println("Encoded string: " + encoded)
