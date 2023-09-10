/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Extension Methods - Using a type-class

  Ad hoc extension just for classes requiring it
 */
package com.artima.scala5ed.ch22

@main
def s4_adHoc(): Unit =
  /**
   * A new ad hoc trait for twos-complement integral types
   *
   * @tparam N
   *   template parameter
   */
  trait TwosComplement[N]:
    def equalsMinValue(n: N): Boolean
    def absOf(n: N): N
    def negationOf(n: N): N

  object TwosComplement:
    given tcOfByte: TwosComplement[Byte] with
      def equalsMinValue(n: Byte): Boolean = n == Byte.MinValue
      def absOf(n: Byte): Byte = n.abs
      def negationOf(n: Byte): Byte = (-n).toByte

    given tcOfShort: TwosComplement[Short] with
      def equalsMinValue(n: Short): Boolean = n == Short.MinValue
      def absOf(n: Short): Short = n.abs
      def negationOf(n: Short): Short = (-n).toShort

    given tcOfInt: TwosComplement[Int] with
      def equalsMinValue(n: Int): Boolean = n == Int.MinValue
      def absOf(n: Int): Int = n.abs
      def negationOf(n: Int): Int = -n

    given tcOfLong: TwosComplement[Long] with
      def equalsMinValue(n: Long): Boolean = n == Long.MinValue
      def absOf(n: Long): Long = n.abs
      def negationOf(n: Long): Long = -n

  /**
   * Providing an ad hoc extension based on TwosComplement
   */
  extension [N](n: N)(using tc: TwosComplement[N])
    def isMinValue: Boolean = tc.equalsMinValue(n)
    def absOption: Option[N] = if !isMinValue then Some(tc.absOf(n)) else None
    def negateOption: Option[N] = if !isMinValue then Some(tc.negationOf(n)) else None

  println("Negate min byte: " + Byte.MinValue.negateOption)
  println("Negate min long: " + Long.MinValue.negateOption)

  // won't compile, BigInt is not a TwosComplement
  // println("Negate a big int: " + BigInt(42).negateOption)
