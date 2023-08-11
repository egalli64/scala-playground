/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Enums - Algebraic data types (ADT)

  A sealed family of case classes is an ADT if at least one class takes parameters
 */
package com.artima.scala5ed.ch19

@main
def s2_adt(): Unit =
  /**
   * an ADT enum
   */
  enum Eastwood[+G, +B]:
    case Good(g: G)
    case Bad(b: B)
    case Ugly(ex: Throwable)

    /**
     * A method cannot operate on a specific case, but could work on the common superclass
     *
     * @param f
     *   a function expecting a G and returning a G2
     * @tparam G2
     *   the parametric type for the function
     * @return
     *   a mapped G, or the untouched element
     */
    def map[G2](f: G => G2): Eastwood[G2, B] =
      this match
        case Good(g)  => Good(f(g))
        case Bad(b)   => Bad(b)
        case Ugly(ex) => Ugly(ex)

  val aGood = Eastwood.Good(41)
  println(aGood.map(n => n + 1))

  val aBad = Eastwood.Bad("I'm bad")
  println(aBad.map(n => None))

  val anUgly = Eastwood.Ugly(Exception("Ugly"))
  println(anUgly.map(n => None))
