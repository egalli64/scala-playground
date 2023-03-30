/*
  https://docs.scala-lang.org/scala3/book/collections-classes.html
  https://github.com/egalli64/scala-playground

  Collections Types - ArrayBuffer
 */
package com.github.egalli64.scala3.b10

import scala.collection.mutable.ArrayBuffer

@main
def e03arrayBuffer(): Unit =
  /*
    ArrayBuffer is a mutable indexed sequence

    Being mutable, an array buffer is often created empty - the parametrized type is required
    As parameter, it is possible to pass its initial size
   */
  val names = ArrayBuffer[String]()
  println("No names: " + names)

  // when initial values are know, they could be passed in
  val numbers = ArrayBuffer(1, 2, 3)
  println("Numbers: " + numbers)

  // Appending by += and ++=
  names += "Bob"
  println("Appended a name: " + names)
  numbers ++= List(4, 5)
  println("Appended a list: " + numbers)

  // Removing by -= and --=
  numbers -= 3
  println("Removed 3: " + numbers)
  numbers --= Set(1, 4)
  println("Removed 1, 4: " + numbers)

  // Update
  numbers(0) = 42
  println("Element 0 updated: " + numbers)

  numbers.update(1, 12)
  println("Element 1 updated: " + numbers)
