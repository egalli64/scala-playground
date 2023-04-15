/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  First Steps in Scala - Loop with while; decide with if
 */
package com.artima.scala5ed.ch02

@main
def s05(): Unit =
  /**
   * Looping on a sequence by while-do
   *
   * @param args
   *   repeated parameter
   */
  def m1(args: String*): Unit =
    // i is Int by type inference
    var i = 0
    // the block is identified by indentation (a la Python), args is a sequence of strings, length is its size
    while i < args.length do
      println(args(i))
      // no prefix/postfix ++ in Scala
      i += 1

  /**
   * Looping on a sequence by while-do, but here using print() instead of println() on args
   *
   * @param args
   *   repeated parameter
   */
  def m2(args: String*): Unit =
    var i = 0
    while i < args.length do
      if i != 0 then print(" ")
      print(args(i))
      i += 1
    println()

  m1("a", "b", "c")
  println("---")

  m2("a", "b", "c")
  println("---")
end s05 // end marker, with its specifier token - not mandatory
