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

  print("Plain while-do: ")
  while n > 1 do
    r *= n
    print(s"$n -> $r; ")
    n -= 1
  println()

  // no do-while in Scala
  print("Emulate do-while: ")
  n = 6
  r = 2
  while
    r *= n
    print(s"$n -> $r; ")
    n -= 1
    n > 1
  do () // All work is done in the condition block
  println()

  // for-loop works on iterables (or sort of that) - here, on a range
  r = 2
  for i <- 2 to 6 do
    r *= i
    print(s"$i -> $r; ")
  println()

  // for-loop on a string
  val s = "Hello"
  var sum = 0
  for c <- "Hello" do sum += c
  println("Adding up the chars in a string: " + sum)

  // same for-loop on string, in a less Scala way
  sum = 0
  for i <- 0 until s.length do sum += s(i)
  println("Same (muddier): " + sum)
