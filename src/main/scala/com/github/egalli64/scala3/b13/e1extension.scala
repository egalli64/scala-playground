/*
  https://docs.scala-lang.org/scala3/book/ca-extension-methods.html
  https://github.com/egalli64/scala-playground

  Contextual Abstractions - Extension Methods

  How add new methods to closed classes
 */
package com.github.egalli64.scala3.b13

@main
def e1extension(): Unit =
  /*
    Given a class we can't change
   */
  case class Circle(x: Double, y: Double, radius: Double)
  val c = Circle(2, 3, 5)
  println(c)

  /*
      We need a new method, circumference()

      The classic solution was creating it in another "helper" class
   */
  object CircleHelpers:
    def circumference(c: Circle): Double = c.radius * math.Pi * 2

  println(s"$c circumference is: " + CircleHelpers.circumference(c))

  /*
    Using extension

    Both class definition and extension should be visible by the user code
   */
  extension (c: Circle) def circumference: Double = c.radius * math.Pi * 2

  println(s"$c circumference is: " + c.circumference)
