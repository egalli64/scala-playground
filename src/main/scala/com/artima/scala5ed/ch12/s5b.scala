/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Packages, Imports, and Exports - Access modifiers - Scope of protection
 */
//package com.artima.scala5ed.ch12
package pack5b

package navigation:
  private[pack5b] class Navigator:
    protected[navigation] def useStarChart(): Unit = println("hello")
    class LegOfJourney:
      private[Navigator] val distance = 100

    val loj: LegOfJourney = LegOfJourney()
    def f(): Int = loj.distance

  class SubNav extends Navigator:
    def g(): Unit = useStarChart()

package launch:
  import navigation.*
  object Vehicle:
    private[launch] val guide = new Navigator

    def h(): Unit = println(guide.getClass)

@main
def s5b(): Unit =
  val nav = navigation.Navigator()
  println(nav.getClass)
  println(nav.loj)

  val subNav = navigation.SubNav()
  println(subNav.f())
  subNav.g()

  launch.Vehicle.h()

