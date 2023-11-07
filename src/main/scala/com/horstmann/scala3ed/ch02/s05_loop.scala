/*
Scala for the Impatient Third Edition - Cay S. Horstmann
Source code shown in the book
Download the zip file from: https://horstmann.com/scala/

https://github.com/egalli64/scala-playground

2. Control Structures and Functions
 5. Loops
 */
package com.horstmann.scala3ed.ch02

@main
def s05_loop(): Unit =
  var n = 6
  var r = 2

  while n > 1 do
    r *= n
    print(s"$n -> $r; ")
    n -= 1
  println()

  // no do-while in Scala, but the while could be twisted in this way
  n = 6
  r = 2
  while
    r *= n
    print(s"$n -> $r; ")
    n -= 1
    n > 1
  do () // All work was done in the condition block
  println()

  // no "classic" for-loop, just the "enhanced" one
  r = 2
  for i <- 2 to 6 do
    r *= i
    print(s"$i -> $r; ")
  println()

  // Looping on chars in a string, close to a "classic" for-loop
  val s = "Hello"
  var sum = 0
  for i <- 0 until s.length do sum += s(i)
  println(sum)

  // Prefer using the "enhanced" for-loop
  sum = 0
  for c <- "Hello" do sum += c
  println(sum)
