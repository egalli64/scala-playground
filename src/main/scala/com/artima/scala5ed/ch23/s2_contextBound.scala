/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Typeclasses - Context bounds
 */
package com.artima.scala5ed.ch23

@main
def s2_contextBound(): Unit =
  /**
   * The "using" provides more information on the used type. The implicit given is used if no
   * explicit one is passed.
   *
   * @param xs
   *   data to be searched
   * @param ordering
   *   the sorting strategy to be used
   * @tparam T
   *   the template parameter
   * @return
   *   max value in list
   */
  def maxList[T](xs: List[T])(using ordering: Ordering[T]): T = xs match
    case Nil     => throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val max = maxList(rest) // (using ordering) // the passed given is assumed
      if ordering.gt(x, max) then x else max

  val values = List(1, 2, 3)
  println(s"$values has max " + maxList(values))

  try maxList(List.empty[Int])
  catch case ex: IllegalArgumentException => println(ex.getMessage)

  /**
   * A more compact version. T has an ordering. The "summon" of ordering let us access it
   * internally, no need of a name.
   *
   * @param xs
   *   data to be searched
   * @tparam T
   *   the template parameter
   * @return
   *   max value in list
   */
  def maxList2[T: Ordering](xs: List[T]): T = xs match
    case Nil     => throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val max = maxList(rest)
      if summon[Ordering[T]].gt(x, max) then x else max

  println(s"$values has max " + maxList2(values))
