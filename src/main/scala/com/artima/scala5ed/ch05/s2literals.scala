/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Basic Types and Operations - Literals
 */
package com.artima.scala5ed.ch05

@main
def s2literals(): Unit =
  val hex = 0x5
  println("Literal Int hexadecimal 0x5: " + hex)

  val hex2 = 0x00ff
  println("Literal Int hexadecimal 0x00FF: " + hex2)

  val magic = 0xcafebabe
  println("Literal Int hexadecimal 0xcafebabe: " + magic)

  val billion = 1_000_000_000
  println("Literal Int decimal 1_000_000_000: " + billion)

  // Won't compile: octal literal syntax has been disabled since Scala 2.11
  // val octal = 0777

  val magic2 = 0xcafebabeL
  println(s"Literal Long hexadecimal 0xcafebabeL (final L for long): $magic2")

  val tower = 35L
  println("Literal Long decimal 35L (final L for long): " + tower)

  val little: Short = 367
  println("Literal Short: " + little)

  val littler: Byte = 38
  println("Literal Byte: " + littler)

  val big = 1.2345
  println("Literal Double: " + big)

  val bigger = 1.23e45
  println("Literal Double 1.23e45 (exponential notation): " + bigger)

  val littleBigger = 3e5f // 300000.0: Float
  println("Literal Float 3e5f (final F for float): " + littleBigger)

  // Experimental features may only be used with a nightly or snapshot version of the compiler
  // import scala.language.experimental.genericNumberLiterals
  // val invoice: BigInt = 1_000_000_000_000_000_000_000
  // println(invoice)
  // val pi: BigDecimal = 3.1415926535897932384626433833
  // println(pi)

  val a = 'A'
  println("A Char literal is composed of any Unicode character between single quotes: " + a)

  val au = '\u0041'
  println("A Char literal by code point - u0041: " + au)

  val backslash = '\\'
  println("Backslash is for escaping: " + backslash)

  val hello = "hello"
  println("String literal by double quotes: " + hello)

  val raw = """Scala raw strings are a tad different from Java test block"""
  println(raw)
  println("""Welcome to Ultamix 3000.
             Type "HELP" for help.""")
  println("""|Welcome to Ultamix 3000.
             |Type "HELP" for help.""".stripMargin)
