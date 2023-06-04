/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Packages, Imports, and Exports - Concise access to related code
 */
/**
 * a package hierarchy
 */
package pack2:
  package navigation:
    class Navigator:
      val map = new StarMap
    class StarMap
  package launch:
    class Booster

  class Ship:
    // No need to say pack2.navigation.Navigator
    val nav = new navigation.Navigator
  package fleets:
    class Fleet:
      // No need to say pack2.Ship
      def addShip() = new Ship

@main
def s2access(): Unit =
  val nav = new pack2.navigation.Navigator
  println(nav)
  println(nav.map)
  println(new pack2.launch.Booster)

  val ship = new pack2.Ship
  println(ship)
  println(ship.nav)

  val fleet = new pack2.fleets.Fleet
  println(fleet.addShip())
