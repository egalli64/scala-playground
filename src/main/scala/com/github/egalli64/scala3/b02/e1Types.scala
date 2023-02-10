/*
  https://docs.scala-lang.org/scala3/book/taste-collections.html
  https://github.com/egalli64/scala-playground

  Type hierarchy
 */
package com.github.egalli64.scala3.b02

@main
def types(): Unit =
  // 1. Any: top type - supertype of all types. It provides universal methods
  val ax: Any = "hello"
  val ay: Any = 42

  println("Any to string: " + ax.toString)
  println("Any hashcode: " + ax.hashCode)
  println("Comparing two object of Any type by equals: " + ax.equals(ay))

  // 2. Matchable: a trait marking types that support pattern matching

  // 3. AnyVal: Any value type, non nullable (related to Java primitives - plus Unit)
  val avx: AnyVal = 42
  val avy: AnyVal = ()
  println("An Int is an AnyVal: " + avx.isInstanceOf[AnyVal])
  println("The unique Unit instance is an AnyVal: " + avy.isInstanceOf[AnyVal])
  println("Unit hashcode: " + avy.hashCode)

  // 4. AnyRef: Any reference type, correspond to Java Object
  val arx: AnyRef = "hello"
  println("A string is an AnyRef: " + arx.isInstanceOf[AnyRef])

  // Anything could go in a list of Any
  val al: List[Any] = List("a string", 732, 'c', true, () => "hello")
  println("A list of any: " + al)
