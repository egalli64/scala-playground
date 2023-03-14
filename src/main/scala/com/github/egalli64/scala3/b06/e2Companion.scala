/*
  https://docs.scala-lang.org/scala3/book/domain-modeling-fp.html
  https://github.com/egalli64/scala-playground

  Domain Modeling - FP Modeling - Organize - Companion Object
 */
package com.github.egalli64.scala3.b06

@main
def companion(): Unit =
  /*
    1. Put the behavior in the companion object
   */
  case class Pizza(
      crustSize: CrustSize,
      crustType: CrustType,
      toppings: Seq[Topping]
  )

  /**
   * Companion object for case class Pizza - they have to be in the same file
   */
  object Pizza:
    /**
     * The base pizza price is fix, plus an extra for each topping
     *
     * @param p
     *   pizza
     * @return
     *   its price
     */
    def price(p: Pizza): Double = p match
      case Pizza(_, _, toppings) => 6 + 1.5 * toppings.size

  import CrustSize.*
  import CrustType.*
  import Topping.*

  val aPizza = Pizza(Small, Regular, Seq(Cheese, Pepperoni))

  import Pizza.price
  println(s"$aPizza: ${price(aPizza)} €")
