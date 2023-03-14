/*
  https://docs.scala-lang.org/scala3/book/domain-modeling-tools.html
  https://github.com/egalli64/scala-playground

  Domain Modeling - Tools - Enum
 */
package com.github.egalli64.scala3.b04

import scala.util.Random

@main
def enumerate(): Unit =
  /*
    1. An enum is a finite set of named values
   */
  enum CrustSize:
    case Small, Medium, Large

  enum CrustType:
    case Thin, Thick, Regular

  enum Topping:
    case Cheese, Pepperoni, BlackOlives, GreenOlives, Onions

  /*
    1b. assigning an enum to a variable
   */
  val myTopping = Topping.GreenOlives
  println(s"My topping is $myTopping")

  /*
    2. Direct access to enumerators by import
   */
  import CrustSize.*
  val mySize = Large
  println(s"My size is $mySize")

  /*
    3. Pick random enums, for the following examples
   */
  val aTopping = Topping.fromOrdinal(Random.nextInt(Topping.values.length))
  val aCrust = CrustType.values(Random.nextInt(CrustType.values.length))

  /*
    3a. Compare enums for equality
   */
  if aTopping == Topping.Cheese then println("Cheese!") else println(s"Topping is $aTopping")

  /*
    3b. Matching an enum
   */
  aCrust match
    case CrustType.Thin  => println("Fun!")
    case CrustType.Thick => println("Tasty!")
    case _               => println("Good choice!")
