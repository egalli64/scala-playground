/*
Scala for the Impatient Third Edition - Cay S. Horstmann
Source code shown in the book
Download the zip file from: https://horstmann.com/scala/

https://github.com/egalli64/scala-playground

2. Control Structures and Functions
 7. Functions
 */
package com.horstmann.scala3ed.ch02

@main
def s07_function(): Unit =
  /**
   * A oneliner function definition
   *
   * @param x
   *   the parameter
   * @return
   *   the result - notice that no "return" keyword is required
   */
  def abs(x: Double) = if x >= 0 then x else -x

  // invoking a method
  val result = abs(-23.33)
  println("The result of invoking the method is " + result)

  /**
   * A multiline function definition
   *
   * @param n
   *   the parameter
   * @return
   *   the result
   */
  def iterativeFactorial(n: Int) =
    var r = 1
    for i <- 1 to n do r = r * i
    // no "return" keyword, the return value is implicitly the last statement value
    r
  // optional tail, could make the code clearer
  end iterativeFactorial

  println("Factorial (iterative): " + iterativeFactorial(5))


  /**
   * A multiline function definition - using brackets
   *
   * @param n
   *   the parameter
   * @return
   *   the result
   */
  def bracketFactorial(n: Int) = {
    var r = 1
    for i <- 1 to n do r = r * i
    r
  }

  println("Factorial (bracket): " + bracketFactorial(5))

  /**
   * The return type is mandatory for recursive functions
   *
   * @param n
   *   the parameter
   * @return
   *   the result
   */
  def recursiveFactorial(n: Int): Int = if n <= 0 then 1 else n * recursiveFactorial(n - 1)

  println("Factorial (recursive): " + recursiveFactorial(5))

  /**
   * If the last statement value in the code should be disregarded, the function could be tagged as
   * of "Unit" type
   *
   * @param sb
   *   a parameter (I/O)
   * @param message
   *   another parameter
   */
  def appender(sb: StringBuilder, message: String): Unit =
    sb.append(java.time.Instant.now())
    sb.append(": ")
    sb.append(message)
    sb.append("\n")

  val sb = StringBuilder("Some text ... ")
  appender(sb, "Hello")
  println(sb)
