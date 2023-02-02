/*
  https://docs.scala-lang.org/scala3/book/taste-modeling.html
  https://github.com/egalli64/scala-playground

  FP Domain Modeling: enum and sum type - to model algebraic data types
 */
package com.github.egalli64.scala3.b01

/**
 * enum pretty close to Java
 */
enum CrustSize:
  case Small, Medium, Large

// importing enumerated values
import com.github.egalli64.scala3.b01.CrustSize.*
val curSize = Small

/**
 * enum as sum type - notice the Next case with parameter
 */
enum Nat:
  case Zero
  case Next(x: Nat)

@main def enumSum(): Unit =
  curSize match
    case Small => println("Small crust size")
    case Medium => println("Medium crust size")
    case Large => println("Large crust size")

  val curNat = Nat.Next(Nat.Zero)
  println(curNat)
