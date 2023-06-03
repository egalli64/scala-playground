import pack2a.Ship
import pack2a.fleets.Fleet
import pack2a.launch.Booster

/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Packages, Imports, and Exports - Concise access to related code
 */

package pack2a:
  package navigation:
    class Navigator2:
      val map = new StarMap
    class StarMap
  package launch:
    class Booster

  class Ship:
    // No need to say pack2a.navigation.Navigator
    val nav = new navigation.Navigator2
  package fleets:
    class Fleet:
      // No need to say pack2a.Ship
      def addShip() = new Ship

@main
def s2access(): Unit =
  val nav = new pack2a.navigation.Navigator2
  println(nav)
  println(nav.map)
  println(new pack2a.launch.Booster)

  val ship = new Ship
  println(ship)
  println(ship.nav)

  val fleet = new Fleet
  println(fleet.addShip())
