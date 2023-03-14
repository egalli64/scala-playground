/*
  https://docs.scala-lang.org/scala3/book/domain-modeling-fp.html
  https://github.com/egalli64/scala-playground

  Domain Modeling - FP Modeling - Organize - Functional Object
 */
package com.github.egalli64.scala3.b06

@main
def functionalObject(): Unit =
  /**
   * Hybrid FP/OOP design - A case class with data _and_ functionality
   *
   * State is immutable, and methods return a copy
   *
   * @param crustSize
   *   the crust size
   * @param crustType
   *   the crust type
   * @param toppings
   *   the toppings
   */
  case class Pizza(crustSize: CrustSize, crustType: CrustType, toppings: Seq[Topping]):
    def price: Double = 6 + 1.5 * toppings.size

    def addTopping(t: Topping): Pizza =
      this.copy(toppings = this.toppings :+ t)

    def removeAllToppings(): Pizza =
      this.copy(toppings = Seq.empty)

    def updateCrustSize(cs: CrustSize): Pizza =
      this.copy(crustSize = cs)

    def updateCrustType(ct: CrustType): Pizza =
      this.copy(crustType = ct)
  end Pizza

  import CrustType.*
  import CrustSize.*
  import Topping.*

  val price = Pizza(Small, Thin, Seq(Cheese))
    .removeAllToppings()
    .addTopping(Pepperoni)
    .updateCrustType(Thick)
    .updateCrustSize(Large)
    .price

  println(s"Pizza price is $price")
