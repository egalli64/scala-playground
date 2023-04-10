/*
  https://docs.scala-lang.org/scala3/book/types-opaque-types.html
  https://github.com/egalli64/scala-playground

  Opaque Types - type aliases providing type abstractions without any overhead
 */
package com.github.egalli64.scala3.b12

import scala.annotation.targetName

@main
def e6opaque(): Unit =
  /*
    We want to store real numbers by logarithm, to improve precision for small/big numbers

    Classic attempt
   */
  class LogarithmA(protected val underlying: Double):
    def toDouble: Double = math.exp(underlying)

    @targetName("add")
    def +(that: LogarithmA): LogarithmA =
      // here we use the apply method on the companion
      LogarithmA(this.toDouble + that.toDouble)

    @targetName("mul")
    def *(that: LogarithmA): LogarithmA =
      new LogarithmA(this.underlying + that.underlying)

    override def toString: String = s"[$underlying -> $toDouble]"

  object LogarithmA:
    def apply(d: Double): LogarithmA = new LogarithmA(math.log(d))

  val la2 = LogarithmA(2.0)
  println("2 is " + la2)
  val la3 = LogarithmA(3.0)
  println("3 is " + la3)

  val la2add3 = la2 + la3
  println("2 + 3 is " + la2add3)
  val la2mul3 = la2 * la3
  println("2 * 3 is " + la2mul3)
  println("---")

  /*
  // Module Abstractions
  //  Instead of defining Logarithm as a class, define it using a type alias.
  trait LogarithmsB:
    type LogarithmB

    // operations on Logarithm
    def add(x: LogarithmB, y: LogarithmB): LogarithmB

    def mul(x: LogarithmB, y: LogarithmB): LogarithmB

    // functions to convert between Double and Logarithm
    def make(d: Double): LogarithmB

    def extract(x: LogarithmB): Double

    // extension methods to use `add` and `mul` as "methods" on Logarithm
    extension (x: LogarithmB)
      def toDouble: Double = extract(x)
      def +(y: LogarithmB): LogarithmB =
        add(x, y)
      def *(y: LogarithmB): LogarithmB = mul(x, y)

//     Directly using LogarithmsImpl would make the equality Logarithm = Double visible for the user,
//     who might accidentally use a Double where a logarithmic double is expected.
  object LogarithmsImpl extends LogarithmsB:
    type LogarithmB = Double

    // operations on Logarithm
    def add(x: LogarithmB, y: LogarithmB): LogarithmB = make(x.toDouble + y.toDouble)
    def mul(x: LogarithmB, y: LogarithmB): LogarithmB = x + y

    // functions to convert between Double and Logarithm
    def make(d: Double): LogarithmB = math.log(d)
    def extract(x: LogarithmB): Double = math.exp(x)

  // *** BUGGED ***
  import LogarithmsImpl.*
  val lb2: LogarithmB = make(2.0)
  println(s"2 is $lb2 -> ${extract(lb2)}")
  val lb3: LogarithmB = make(3.0)
  println(s"3 is $lb3 -> ${extract(lb3)}")

  val lb2add3 = add(lb2, lb3)
  println(s"2 + 3 is $lb2add3 -> ${extract(lb2add3)}")
  val lb2mul3 = mul(lb2, lb3)
  println(s"2 * 3 is $lb2mul3 -> ${extract(lb2mul3)}")
  println("---")
   */

  /*
    Opaque Types
   */
  object LogarithmsC:
    opaque type LogarithmC = Double

    object LogarithmC:
      def apply(d: Double): LogarithmC = math.log(d)

    extension (x: LogarithmC)
      def toDouble: Double = math.exp(x)
      def +(y: LogarithmC): LogarithmC = LogarithmC(math.exp(x) + math.exp(y))
      def *(y: LogarithmC): LogarithmC = x + y

  import LogarithmsC.*

  val lc2: LogarithmC = LogarithmC(2.0)
  println(s"2 is $lc2")
  val lc3: LogarithmC = LogarithmC(3.0)
  println(s"3 is $lc3")

  val lc2add3 = lc2 + lc3
  println(s"2 + 3 is $lc2add3 -> ${lc2add3.toDouble}")
  val lc2mul3 = lc2 * lc3
  println(s"2 * 3 is $lc2mul3 -> ${lc2mul3.toDouble} ")
  println("---")

  // won't compile
  // val d: Double = log2
