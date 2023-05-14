/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Built-in Control Structures - Variable scope
 */
package com.artima.scala5ed.ch07

import scala.util.Random

@main
def s7scope(): Unit =
  def printMultiTable(): Unit =
    var i = 1
    // only i in scope here
    while i <= 10 do
      var j = 1
      // both i and j in scope here
      while j <= 10 do
        val prod = (i * j).toString
        // i, j, and prod in scope here
        var k = prod.length
        // i, j, prod, and k in scope here
        while k < 4 do
          print(" ")
          k += 1
        print(prod)
        j += 1
      // i and j still in scope; prod and k out of scope
      println()
      i += 1
    println(s"i ($i) still in scope; j, prod, and k out of scope")

  /**
   * For fun: refactor printMultiTable() in a more compact way
   */
  def printMultiTableFor(): Unit =
    for i <- 1 to 10 do
      for j <- 1 to 10 do
        val prod = (i * j).toString
        print(" " * (4 - prod.length) + prod)
      println()

  printMultiTable()
  printMultiTableFor()

  // Same variable names in nested scoped are accepted (I wouldn't recommend them, though)
  val a = Random.nextInt(2)
  if a < 2 then
    val a = Random.nextInt(2)
    println("The internal 'a' is: " + a)
  println("The external 'a' is: " + a)
