/*
  https://docs.scala-lang.org/scala3/book/domain-modeling-fp.html
  https://github.com/egalli64/scala-playground

  Domain Modeling - FP Modeling - Organize - Module
 */
package com.github.egalli64.scala3.b06

@main
def module(): Unit =
  /*
    Given a case class
   */
  case class Pizza(
      crustSize: CrustSize,
      crustType: CrustType,
      toppings: Seq[Topping]
  )

  /*
    1. Put its behavior in a trait
   */
  trait PizzaServiceInterface:

    def price(p: Pizza): Double

    def addTopping(p: Pizza, t: Topping): Pizza
    def removeAllToppings(p: Pizza): Pizza

    def updateCrustSize(p: Pizza, cs: CrustSize): Pizza
    def updateCrustType(p: Pizza, ct: CrustType): Pizza

  /*
    2. Create its concrete implementation as a singleton object
   */
  object PizzaService extends PizzaServiceInterface:

    def price(p: Pizza): Double = p match
      case Pizza(_, _, toppings) => 6 + 1.5 * toppings.size

    def addTopping(p: Pizza, t: Topping): Pizza =
      p.copy(toppings = p.toppings :+ t)

    def removeAllToppings(p: Pizza): Pizza =
      p.copy(toppings = Seq.empty)

    def updateCrustSize(p: Pizza, cs: CrustSize): Pizza =
      p.copy(crustSize = cs)

    def updateCrustType(p: Pizza, ct: CrustType): Pizza =
      p.copy(crustType = ct)

  end PizzaService

  /*
    3. Use data and functionality
   */
  import CrustSize.*
  import CrustType.*
  import Topping.*

  val p = Pizza(Small, Thin, Seq(Cheese))

  import PizzaService.*

  val p1 = addTopping(p, Pepperoni)
  val p2 = addTopping(p1, Onions)
  val p3 = updateCrustType(p2, Thick)
  val p4 = updateCrustSize(p3, Large)

  println(p4)
