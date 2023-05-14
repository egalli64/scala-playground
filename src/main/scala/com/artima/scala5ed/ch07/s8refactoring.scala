/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Built-in Control Structures - Refactoring imperative-style code

  Refactoring the code from s7scope to make it functional:
    - no side effect: instead of printing, return a string
    - get rid of while loops and vars
    - split the code on short functions, use vals and for loops
 */
package com.artima.scala5ed.ch07

@main
def s8refactoring(): Unit =
  // Returns a row as a sequence

  /**
   * Make a sequence of strings for the multiples in [1..10] of i
   *
   * @param i
   *   the row seed
   * @return
   *   a row as a sequence
   */
  def makeRowSeq(i: Int) =
    for col <- 1 to 10 yield
      val prod = (i * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod

  /**
   * Make a string for the [1..10] multiples of i
   *
   * @param i
   *   the row seed
   * @return
   *   a row as a string
   */
  def makeRow(i: Int) = makeRowSeq(i).mkString

  /**
   * Generate a 10 x 10 multiplication table
   *
   * @return
   *   a table as a string with one row per line
   */
  def multiTable() =
    // a sequence of row strings
    val tableSeq = for row <- 1 to 10 yield makeRow(row)
    tableSeq.mkString("\n")

  // the side effect is delayed till this point
  println(multiTable())
