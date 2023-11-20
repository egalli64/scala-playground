/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  8. Inheritance
   9. Open and Sealed Classes
 */
package com.horstmann.scala3ed.ch08

@main
def s09b_sealed(): Unit =
  val dr = DomesticRate()

  println(dr.letter(2.0))

  // won't compile: Illegal inheritance from sealed class 'PostalRate'
//  class IntergalacticRate extends PostalRate:
//    override def letter(x: Double) = Double.MaxValue
