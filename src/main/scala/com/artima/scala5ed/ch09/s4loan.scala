/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Control Abstraction - Writing new control structures
 */
package com.artima.scala5ed.ch09

import java.io.{File, PrintWriter}
import java.time.LocalDate

@main
def s4loan(): Unit =
  /**
   * Apply the passed lambda two times to the passed value
   *
   * @param op
   *   a lambda taking an Int and returning an Int
   * @param x
   *   a value
   * @return
   *   result
   */
  def twice(op: Int => Int, x: Int) = op(op(x))

  // apply twice "plus 1" to 5 should return 7
  println(twice(_ + 1, 5))

  /**
   * Loan pattern (Scala alternative approach to Java try-with-resources)
   *
   * The caller provides what to do, the callee manages the full life cycle of the resource
   *
   * @param filename
   *   the file where to print
   * @param op
   *   the operation to perform on the associated print writer
   */
  def withPrintWriter(filename: String, op: PrintWriter => Unit): Unit =
    val writer = new PrintWriter(filename)
    try op(writer)
    finally writer.close()

  withPrintWriter(
    // to create the PrintWriter
    "date.txt",
    // what to do with the PrintWriter
    _.println(LocalDate.now())
  )

  // For argument list with _single_ argument {} can be used as ()
  val s = "Hello, world!"
  println(s.charAt(1) + "/" + s.charAt { 4 })

  // Using together currying and {} we can write
  def withPrintWriter2(filename: String)(op: PrintWriter => Unit): Unit =
    val writer = new PrintWriter(filename)
    try op(writer)
    finally writer.close()

  withPrintWriter2("date2.txt") { _.println(LocalDate.now()) }
