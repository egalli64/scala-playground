/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Packages, Imports, and Exports - Access modifiers - Visibility and companion objects
 */
package com.artima.scala5ed.ch12

@main
def s5c(): Unit =
  /**
   * A class and (below) its companion object, they shares all access rights
   */
  class Rocket:
    // Can access private members of its companion object
    import Rocket.fuel
    private def canGoHomeAgain = fuel > 20

  /**
   * An object and (above) its companion class
   */
  object Rocket:
    private def fuel = 10

    def chooseStrategy(rocket: Rocket): Unit =
      // Can access private members of its companion class
      if rocket.canGoHomeAgain then goHome()
      else pickAStar()

    def goHome(): Unit = println("Going home")

    def pickAStar(): Unit = println("Picking a star")

  val rocket = Rocket()
  Rocket.chooseStrategy(rocket)
