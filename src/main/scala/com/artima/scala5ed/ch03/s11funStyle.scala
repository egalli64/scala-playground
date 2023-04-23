/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Next Steps in Scala - Learn to recognize the functional style
 */
package com.artima.scala5ed.ch03

@main
def s11funStyle(): Unit =
  // val are preferred over var

  /**
   * A loop - imperative approach
   *
   * @param args
   *   some strings
   */
  def printArgs(args: List[String]): Unit =
    var i = 0
    while i < args.length do
      println(args(i))
      i += 1

  /**
   * A loop - still imperative, but no var in it
   *
   * @param args
   *   some strings
   */
  def printArgs2(args: List[String]): Unit =
    for arg <- args do println(arg)

  /**
   * A loop - still imperative, but no explicit loop construct
   *
   * @param args
   *   some strings
   */
  def printArgs3(args: List[String]): Unit =
    args.foreach(println)

  /*
    A pure function is always returning something, it has no side effect

    Refactoring printArgs() in a functional way leads to ...
   */

  /**
   * No more var, loop, side effect
   *
   * @param args
   *   some strings
   * @return
   *   a single string, ready to be printed
   */
  def formatArgs(args: List[String]) = args.mkString("\n")

  val data = List("one", "two", "three")

  printArgs(data)
  println("---")

  printArgs2(data)
  println("---")

  printArgs3(data)
  println("---")

  val s = formatArgs(data)

  // somewhere a side effect is a necessity, in a useful program
  println(s)

  // testing a pure function is easy
  assert(s == "one\ntwo\nthree")
