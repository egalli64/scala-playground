/*
  https://docs.scala-lang.org/scala3/book/methods-most.html
  https://github.com/egalli64/scala-playground

  Method Features - Basic
 */
package com.github.egalli64.scala3.b07

/**
 * A method is introduced by "def", use camelCase for its name
 *
 * @param a
 *   a param, the type must be specified
 * @param b
 *   another param
 * @return
 *   the return type is optional (but preferred for clarity)
 */
def add(a: Int, b: Int) = a + b

/**
 * You won't see often code so verbose in Scala
 *
 * @param a
 *   first parameter
 * @param b
 *   second parameter
 * @return
 *   the returned value
 */
def verboseAdd(a: Int, b: Int): Int =
  val sum = a + b

  // the expression result for the last line of code in a function is implicitly its return value
  // no need of using the "return" keyword, could be used by it is redundant
  sum
  // the "end" keyword is optional, used for clarity in case of long body
end verboseAdd

/**
 * Invoking a method, its result is assigned to the left hand side, when specified
 */
val x = add(1, 2) - verboseAdd(1, 2)

// Compile error: Illegal start of toplevel definition
// println(x)

@main
def myMainMethod(): Unit =
  // using an variable from the top level
  println("The value of x is " + x)

  // create a list with the specified elements - by apply() on List
  val li = List(1, 2, 3)

  // a function - here a method, size - that does not expect any argument is invoked without parenthesis
  println("The size of li is " + li.size)

  // invoking a method that requires an argument and return a boolean
  println("It contains 1: " + li.contains(1))

  // passing a lambda, return a new list
  println("A new list with mapped elements: " + li.map(_ * 10))
