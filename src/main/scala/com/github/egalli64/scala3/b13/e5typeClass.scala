/*
  https://docs.scala-lang.org/scala3/book/ca-type-classes.html
  https://github.com/egalli64/scala-playground

  Contextual Abstractions - Type Classes

  A Scala type class is close to Java util Comparator[T]
 */
package com.github.egalli64.scala3.b13

@main
def e5typeClass(): Unit =
  /**
   * A type class - different from a "normal" trait
   *
   *   - type parametric - the type for the method implementation
   *
   *   - an implementation of Showable[A] is required
   *
   *   - make use of an extension method.
   *
   * @tparam A
   *   the base type
   */
  trait Showable[A]:
    extension (a: A) def show: String

  /**
   * A class that we want to be Showable
   *
   * @param firstName
   *   first
   * @param lastName
   *   last
   */
  case class Person(firstName: String, lastName: String)

  /**
   * The Showable extension for Person
   */
  given Showable[Person] with
    extension (p: Person) def show: String = s"First: ${p.firstName}, last: ${p.lastName}"

  val p = Person("Tom", "Holz")
  println(p.show)
