package com.github.egalli64.scala3.s04

enum CrustSize:
  case Small, Medium, Large

import CrustSize.*
val curSize = Small

enum Nat:
  case Zero
  case Next(x: Nat)
val curNat = Nat.Next(Nat.Zero)

@main def enumSum(): Unit =
  curSize match
    case Small => println("Small crust size")
    case Medium => println("Medium crust size")
    case Large => println("Large crust size")

  println(curNat)

