/*
  https://docs.scala-lang.org/scala3/book/control-structures.html
  https://github.com/egalli64/scala-playground

  Match as method body
 */
package com.github.egalli64.scala3.b03

case class Person(firstName: String, lastName: String)
case class Dog(name: String)

@main
def methodMatch(): Unit =
  /**
   *   1. Compare the matchable with constants pattern
   * @param a
   *   a matchable
   * @return
   *   false in case of number zero, empty string, boolean false - true otherwise
   */
  def isTruthy(a: Matchable) = a match
    case 0 | "" | false => false
    case _              => true

  println("The string 'Hello' is truthy: " + isTruthy("Hello"))
  println("The empty string is truthy: " + isTruthy(""))
  println("The Int 42 is truthy: " + isTruthy(42))

  /**
   * 2. Matching against a constant, sequence, tuple, constructor, type, or wildcard
   *
   * @param x
   *   a a matchable
   * @return
   *   a string determined by match against many alternatives
   */
  def patternTypes(x: Matchable): String = x match
    // constant patterns
    case 0       => "The number zero"
    case true    => "The boolean true"
    case "hello" => "The string 'hello'"
    case Nil     => "The empty List"
    // sequence patterns
    case List(0, _, _) => "A 3-element list with 0 as the first element"
    case List(1, _*)   => "A list with at least a 1 as first element"
    case Vector(1, _*) => "A vector with at least a 1 as first element"
    // tuple patterns
    case (a, b)    => s"A 2-tuple with $a and $b"
    case (a, b, c) => s"A 3-tuple with $a, $b, and $c"
    // constructor patterns
    case Person(first, "Holz") => s"Holz first name is $first"
    case Dog("Bob")            => "Good dog"
    // type test patterns
    case s: String         => s"A string: $s"
    case i: Int            => s"An int: $i"
    case f: Float          => s"A float: $f"
    case a: Array[Int]     => s"An int array: ${a.mkString(",")}"
    case as: Array[String] => s"A string array: ${as.mkString(",")}"
    case d: Dog            => s"A dog: ${d.name}"
    case list: List[?]     => s"A list: $list"
    case m: Map[?, ?]      => s"A map: ${m.toString}"
    // catch-all pattern
    case _ => s"Something else: $x"

  println(patternTypes(0))
  println(patternTypes(true))
  println(patternTypes("hello"))
  println(patternTypes(List()))
  println(patternTypes(List(0, 42, 12)))
  println(patternTypes(List(1)))
  println(patternTypes(Vector(1)))
  println(patternTypes("hello", 42))
  println(patternTypes(Nil, false, Vector()))
  println(patternTypes(Person("Tom", "Holz")))
  println(patternTypes(Dog("Bob")))
  println(patternTypes("Welcome, Bob!"))
  println(patternTypes(42))
  println(patternTypes(42.24F))
  println(patternTypes(Array(4, 12)))
  println(patternTypes(Dog("Rocky")))
  println(patternTypes(List(0, 42, 12, 27)))
  println(patternTypes(Map(0 -> "zero", 42 -> "answer", 12 -> "number")))
  println(patternTypes(Vector(53)))