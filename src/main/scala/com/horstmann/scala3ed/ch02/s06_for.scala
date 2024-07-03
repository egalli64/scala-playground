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
  println("The for loop is flexible")

  // a double for-loop
  print("i in [1, 3] and j in [7, 9]: ")
  for
    i <- 1 to 3
    j <- 7 to 9
  do print(f"${10 * i + j}%3d")
  println()

  // use a _guard_ to filter loops
  print("i and j both in [1, 3] but i != j: ")
  for
    i <- 1 to 3
    j <- 1 to 3
    if i != j
  do print(f"${10 * i + j}%3d")
  println()

  // use _definition_ for complex loops
  print("i in [1, 3], j in [4 - i, 3]: ")
  // expecting 13 / 22, 23 / 31, 32, 33
  for
    i <- 1 to 3
    beg = 4 - i
    j <- beg to 3
  do print(f"($i) ${10 * i + j}%3d")
  println()

  // use a _for comprehension_ to generate a collection of values
  val result = for i <- 1 to 10 yield i % 3
  println("A for comprehension: " + result)

  // the generated result is compatible with the generator: here, string to string
  val encoded = for c <- "Hello" yield (c + 1).toChar
  println("Encoded 'Hello' (plus 1): " + encoded)
