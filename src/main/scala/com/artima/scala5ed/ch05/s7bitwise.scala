/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Basic Types and Operations - Bitwise operations
 */
package com.artima.scala5ed.ch05

@main
def s7bitwise(): Unit =
  println(s"Binary 01 AND 10 is 00: ${1 & 2}")
  println(s"Binary 01 OR 10 is 11: ${1 | 2}")
  println(s"Binary 01 XOR 11 is 10: ${1 ^ 3}")
  println(s"Binary complement 000...01 is 111...10: ${~1}")

  // (unsigned) shift right
  println(s"Binary 100 shift right 2 is 001: ${4 >> 2}")
  println(s"Decimal -1 is Hex 0xFFFFFFFF: ${-1 == 0xFFFFFFFF}")
  println(s"-1 shift right 1 is -1: ${-1 >> 1}")
  println(s"-1 shift right 11 is -1: ${-1 >> 11}")
  println(s"-1 shift right 31 is -1: ${-1 >> 31}")
  println(s"-1 unsigned shift right 31 is 1: ${-1 >>> 31}")
  println(s"-1 unsigned shift right 1 is ${Int.MaxValue}: ${-1 >>> 1}")

  // shift left
  println(s"Binary 001 shift left 2 is 100: ${1 << 2}")
  println(s"1 shift left 31 is ${Int.MinValue}: ${1 << 31}")
