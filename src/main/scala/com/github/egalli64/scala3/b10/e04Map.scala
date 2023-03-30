/*
  https://docs.scala-lang.org/scala3/book/collections-classes.html
  https://github.com/egalli64/scala-playground

  Collections Types - Map
 */
package com.github.egalli64.scala3.b10

@main
def e04Map(): Unit =
  /*
    Both mutable and immutable maps are available

    This is an immutable map
   */
  val states = Map(
    "AK" -> "Alaska",
    "AL" -> "Alabama",
    "AZ" -> "Arizona"
  )
  println(states)

  // for looping on a map
  for (k, v) <- states do println(s"key: $k, value: $v")

  // accessing a value by key
  val ak = states("AK") // ak: String = Alaska
  println("The 'AK' state is " + ak)

  // new map by addiction, + and ++
  val a = Map(1 -> "one")
  println("A map is " + a)
  val b = a + (2 -> "two")
  println("B map, by + is " + b)
  val c = b ++ Seq(3 -> "three", 4 -> "four")
  println("C map, by ++ is " + c)

  // new map by subtraction, - and --
  val d = c - 4
  println("D map, by - 4 is " + d)

  val e = c - 4 - 3
  println("E map, by - 4 - 3 is " + e)

  val f = c -- Seq(3, 4)
  println("F map, by -- of Seq(3, 4) is " + f)
