/*
  https://docs.scala-lang.org/scala3/book/domain-modeling-fp.html
  https://github.com/egalli64/scala-playground

  Domain Modeling - FP Modeling - Data and functions
 */
package com.github.egalli64.scala3.b06

import scala.util.Random

/*
  1. Modeling data with different alternatives using enum

  In FP data and the operations on that data are separate - "Skinny domain objects"
 */
enum CrustSize:
  case Small, Medium, Large

enum CrustType:
  case Thin, Thick, Regular

enum Topping:
  case Cheese, Pepperoni, BlackOlives, GreenOlives, Onions

@main
def dataAndFunctions(): Unit =
  val aSize = CrustSize.fromOrdinal(Random.nextInt(CrustSize.values.length))
  val aType = CrustType.fromOrdinal(Random.nextInt(CrustType.values.length))
  val aTopping = Topping.fromOrdinal(Random.nextInt(Topping.values.length))
  println(s"Pizza $aSize, $aType, with $aTopping")

  /*
    2. Compound data by "case class" aka Product type
   */
  case class Pizza(
      crustSize: CrustSize,
      crustType: CrustType,
      toppings: Seq[Topping]
  )

  import CrustSize.*
  import CrustType.*
  import Topping.*

  val aPizza = Pizza(Small, Regular, Seq(Cheese, Pepperoni))
  println(s"A product type pizza: $aPizza")

  /*
    3. Modeling the Operations by pure functions (or methods)

    Being the data expressed by enum and case class, pattern matching comes natural
   */
  def pizzaPrice(p: Pizza): Double = p match
    case Pizza(crustSize, crustType, toppings) =>
      val base = 6.00
      val crust = crustPrice(crustSize, crustType)
      val tops = toppings.map(toppingPrice).sum
      base + crust + tops

  def toppingPrice(t: Topping): Double = t match
    case Cheese | Onions                       => 0.5
    case Pepperoni | BlackOlives | GreenOlives => 0.75

  def crustPrice(s: CrustSize, t: CrustType): Double =
    (s, t) match
      // if the crust size is small or medium, the type is not important
      case (Small | Medium, _) => 0.25
      case (Large, Thin)       => 0.50
      case (Large, Regular)    => 0.75
      case (Large, Thick)      => 1.00

  println(s"$aPizza price: " + pizzaPrice(aPizza))
