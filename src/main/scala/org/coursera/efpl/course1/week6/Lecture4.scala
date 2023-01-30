/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 6 - Collections - Lecture 6.4 - Maps
 */
package org.coursera.efpl.course1.week6

import java.util.NoSuchElementException
import scala.annotation.targetName

@main
def lecture4(): Unit =
  // Map is an Iterable of (key, value), usually expressed as key -> value
  val romans = Map("I" -> 1, "V" -> 5, "X" -> 10)
  println(romans)

  val capitals = Map(("Rome", "Italy"), ("Paris", "France"))
  println(capitals)

  println(capitals.map(kv => (kv._2, kv._1)))
  println(capitals.map((k, v) => (v, k)))
  println(for ((k, v) <- capitals) yield (v, k))

  // Map is also a function: Key => Value
  println("The capital Rome is mapped to " + capitals("Rome"))

  // Map of missing result in NoSuchElementException
  try capitals("Madrid")
  catch case _ => println("Madrid is a missing capital")

  // The method get() returns an Option, Some(x) or None if missing
  println("The capital Rome is mapped to " + capitals.get("Rome"))
  println("The capital Madrid is mapped to " + capitals.get("Madrid"))
  // Alternative: Map withDefaultValue() - used for apply() only
  println("The capital Madrid is mapped to " + capitals.withDefaultValue("<Missing>")("Madrid"))

  // Using Option
  val cities = List("Rome", "Madrid")
  cities.foreach(c =>
    print(s"$c: ")
    capitals.get(c) match
      case Some(capital) => println(capital)
      case None          => println("Missing")
  )

  // Updating Map (in a functional way, maps are immutable)
  val capitals2 = capitals + ("Madrid" -> "Spain")
  println(capitals2)
  val capitals3 = capitals2 ++ List(("London", "UK"), ("Berlin", "Germany"))
  println(capitals3)

  // Sorting Map
  val fruits = List("apple", "pear", "orange", "pineapple")
  println("Fruits: " + fruits)
  println("Natural sort: " + fruits.sorted)
  println("Sort with length: " + fruits.sortWith(_.length < _.length))

  // Partitioning with group by
  println("Partition by initial: " + fruits.groupBy(_.head))

  // Example: map a polynomial e.g.: x**3 - 2x + 5 is (0->5), (1->-2), (3,1)
  class Polynomial(nonZeroTerms: Map[Int, Double]):
    // varargs by repeated parameter
    def this(varargs: (Int, Double)*) = this(varargs.toMap.withDefaultValue(0.0))

    private val terms = nonZeroTerms.withDefaultValue(0.0)

    @targetName("plus")
    def +(other: Polynomial): Polynomial =
      Polynomial(terms ++ other.terms.map((e, c) => (e, terms(e) + c)))

    def addPoly(other: Polynomial): Polynomial =
      Polynomial(other.terms.foldLeft(terms)(addTerm))

    private def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] =
      terms + (term._1 -> (terms(term._1) + term._2))

    override def toString: String =
      val result =
        for (exponent, coefficient) <- terms.toList.sorted.reverse
        yield s"$coefficient x^$exponent"
      result.mkString(" + ")

  end Polynomial

  val p = Polynomial(Map(0 -> 5.0, 1 -> -2.0, 3 -> 1.0))
  println(p)

  val p2 = Polynomial(0 -> 3, 1 -> 1)
  println(p2)

  println(p + p2)
  println(p.addPoly(p2))
