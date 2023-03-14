/*
  https://docs.scala-lang.org/scala3/book/domain-modeling-fp.html
  https://github.com/egalli64/scala-playground

  Domain Modeling - FP Modeling - Organize - extension
 */
package com.github.egalli64.scala3.b06

@main
def extending(): Unit =
  /*
    Given a case class
   */
  case class Pizza(crustSize: CrustSize, crustType: CrustType, toppings: Seq[Topping])

  /*
    Instead of adding behavior in the class, it is possible to extend the class

    It could be defined in another file
   */
  extension (p: Pizza)
    def price: Double = 6 + 1.5 * p.toppings.size

    def addTopping(t: Topping): Pizza =
      p.copy(toppings = p.toppings :+ t)

    def removeAllToppings(): Pizza =
      p.copy(toppings = Seq.empty)

    def updateCrustSize(cs: CrustSize): Pizza =
      p.copy(crustSize = cs)

    def updateCrustType(ct: CrustType): Pizza =
      p.copy(crustType = ct)

  /*
    A class with extension is used like a function object
   */
  import CrustType.*
  import CrustSize.*
  import Topping.*

  val curPrice = Pizza(Small, Thin, Seq(Cheese))
    .removeAllToppings()
    .addTopping(Pepperoni)
    .updateCrustType(Thick)
    .updateCrustSize(Large)
    .price

  println(s"Pizza price is $curPrice")
