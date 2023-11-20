/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  8. Inheritance
   9. Open and Sealed Classes
 */
package com.horstmann.scala3ed.ch08

/**
 * Find the first element in rates that has a weight greater or equal to the passed weight, and
 * return its associated price, if found
 *
 * @param rates
 *   an array of pair of doubles
 * @param x
 *   the letter weight
 * @return
 *   the associated price, or -1
 */
def lookup(rates: Array[(Double, Double)])(x: Double) =
  //
  rates.find(x <= _(0)) match
    case Some((_, price)) => price
    case None             => -1

/**
 * A sealed abstract class, subclasses could be defined only in this file
 */
sealed abstract class PostalRate:
  def letter(oz: Double): Double

class DomesticRate extends PostalRate:
  override def letter(oz: Double): Double =
    lookup(Array((1.0, 0.58), (2.0, 0.78), (3.0, 0.98), (3.5, 1.18)))(oz)

class InternationalRate extends PostalRate:
  override def letter(oz: Double): Double =
    lookup(Array((1.0, 1.3), (2.0, 2.25), (3.0, 3.2), (3.5, 4.14)))(oz)
