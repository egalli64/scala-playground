/*
  https://docs.scala-lang.org/scala3/book/collections-classes.html
  https://github.com/egalli64/scala-playground

  Collections Types - Range: special case of an indexed sequence

  It represents integer values in a range with non-zero step value
 */
package com.github.egalli64.scala3.b10

@main
def e06Range(): Unit =
  // to-range [left, right]
  val r1 = 1 to 5
  println(s"From $r1 to " + r1.toList)

  // until-range [left, right)
  val r2 = 1 until 5
  println(s"From $r2 to " + r2.toBuffer)

  // to-by-range
  val r3 = 1 to 9 by 2
  println(s"From $r3 to " + r3.toList)

  // to-range on char
  val r4 = 'a' to 'e'
  println(s"From $r4 to " + r4.toList)

  // range in a for loop
  print("Range in for: ")
  for i <- 1 to 5 do print(i + " ")
  println()

  // range factory method in collections
  println("Vector from range: " + Vector.range(1, 5))
  println("List from range: " + List.range(1, 8, 2))
  println("Set from range: " + Set.range(1, 5))

  // mapping a range to a vector
  println(s"From $r1 to " + r1.map(_ * 1.0))

  // mapping a range in a map
  println(s"From $r1 to " + r1.map(x => (x, s"§$x§")))
