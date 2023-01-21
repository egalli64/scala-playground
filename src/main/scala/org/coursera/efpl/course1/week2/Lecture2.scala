/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 2 - High Order Functions - Lecture 2.2 - Currying
 */
package org.coursera.efpl.course1.week2

@main
def lecture2(): Unit =
  /**
   * Sum function, as seen in lecture 1, but returning a function
   *
   * @param f the function to be applied to each value in the interval
   * @return the function that will do the job, once it gets lower and upper bound
   */
  def sumCurry(f: Int => Int): (Int, Int) => Int =
    def sumF(a: Int, b: Int): Int = if a > b then 0 else f(a) + sumF(a + 1, b)
    sumF

  // 1. Getting a function from a function
  // pass the identity function to sum to get a sum interval function
  def sumInterval = sumCurry(x => x)

  // pass the cube function to sum to get a sum cubes for interval function
  def sumCubes = sumCurry(x => x * x * x)

  println("Plain interval: " + sumInterval(2, 6))
  println("Cube interval: " + sumCubes(2, 6))

  // 2. Consecutive stepwise applications
  // pass an anonymous function to sum, getting back a function and invoking it on an interval
  println(sumCurry(x => x * x * x)(2, 6))

  // pass a named function to sum, etc ...
  def cube(x: Int): Int = x * x * x
  println(sumCurry(cube)(2, 6))

  // 3. Multiple parameter list - more compact notation for currying
  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if a > b then 0 else f(a) + sum(f)(a + 1, b)

  println("Compact definition: " + sum(cube)(2, 6))

  // 4. Exercise
  // 4.1 Product of element in an interval function
  def product(f: Int => Int)(a: Int, b: Int): Int = if a > b then 1 else f(a) * product(f)(a + 1, b)
  println(product(x => x)(2, 4))

  // 4.2 Write factorial in terms of product
  def factorial(x: Int): Int = product(x=>x)(1, x)
  println(factorial(5))

  // 4.3 Generalization of sum and product
  def fold(f: Int => Int, op: (Int, Int) => Int, base: Int)(lower: Int, upper: Int) : Int =
    def loop(lower: Int): Int =
      if lower > upper then base else op(f(lower), loop(lower + 1))
    loop(lower)

  def mySum(f: Int => Int) = fold(f, (x, y) => x + y, 0)
  println(mySum(x => x * x)(2, 4))

  // 5 Quiz
  def f(a: String)(b: Int)(c: Boolean): String = "(" + a + ", " + b + ", " + c + ")"
  val partialApplication1 = f("Scala")
  val partialApplication2 = partialApplication1(42)
  println(partialApplication2(true))