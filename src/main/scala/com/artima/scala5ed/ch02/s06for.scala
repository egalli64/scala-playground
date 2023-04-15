/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  First Steps in Scala - Iterate with foreach and for-do
 */
package com.artima.scala5ed.ch02

@main
def s06(): Unit =
  /**
   * Looping on a sequence in functional style: foreach()
   *
   * @param args
   *   strings as repeated parameter
   */
  def m(args: String*): Unit =
    // the lambda passed to foreach is in its more explicit form
    args.foreach((arg: String) => println(arg))
    println("(1) ---")

  /**
   * foreach() with simplified lambda
   *
   * @param args
   *   strings as repeated parameter
   */
  def m2(args: String*): Unit =
    args.foreach(arg => println(arg))
    println("(2) ---")

  /**
   * foreach() with partially applied function: just one statement that takes a single argument
   *
   * @param args
   *   strings as repeated parameter
   */
  def m3(args: String*): Unit =
    args.foreach(println)
    println("(3) ---")

  /**
   * for-do
   *
   * @param args
   *   strings as repeated parameter
   */
  def m4(args: String*): Unit =
    // a new val "arg" is created for each iteration and consumed in the block
    for arg <- args do println(arg)
    println("(4) ---")

  m("a", "b", "c")
  m2("a", "b", "c")
  m3("a", "b", "c")
  m4("a", "b", "c")
