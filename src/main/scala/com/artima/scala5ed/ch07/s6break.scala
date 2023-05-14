/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Built-in Control Structures - Living without break and continue
 */
package com.artima.scala5ed.ch07

import scala.annotation.tailrec

@main
def s6break(args: String*): Unit =
  // no break nor continue in Scala - say you have to port the following code from Java
  /*
    // foundIt is true if an arg not starting by "-" and ending by ".scala" is passed
    int i = 0;
    boolean foundIt = false;
    while (i < args.length) {
      if (args[i].startsWith("-")) {
        i = i + 1;
        continue;
      }
      if (args[i].endsWith(".scala")) {
        foundIt = true;
        break;
      }
      i = i + 1;
    }
   */

  // 1. Direct conversion to Scala
  var i = 0
  var foundIt = false
  while i < args.length && !foundIt do
    if !args(i).startsWith("-") then
      if args(i).endsWith(".scala") then foundIt = true
      else i = i + 1
    else i = i + 1

  println(foundIt)

  /**
   * 2. Following a recursive approach
   *
   * @param i
   *   index in the array to search
   * @return
   *   the index of the found instance, or -1 if not found
   */
  @tailrec
  def searchFrom(i: Int): Int =
    if i >= args.length then -1
    else if args(i).startsWith("-") then searchFrom(i + 1)
    else if args(i).endsWith(".scala") then i
    else searchFrom(i + 1)

  val index = searchFrom(0)
  println(index)
