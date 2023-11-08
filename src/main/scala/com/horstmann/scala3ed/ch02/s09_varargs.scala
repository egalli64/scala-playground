/*
Scala for the Impatient Third Edition - Cay S. Horstmann
Source code shown in the book
Download the zip file from: https://horstmann.com/scala/

https://github.com/egalli64/scala-playground

2. Control Structures and Functions
 9. Variable Arguments L1
 */
package com.horstmann.scala3ed.ch02

@main
def s09_varargs(): Unit =
  /**
   * A vararg function
   *
   * @param args
   *   vararg parameter
   * @return
   *   the result
   */
  def sum(args: Int*) =
    var result = 0
    for arg <- args do result += arg
    result

  println(sum(1, 2, 3, 4, 5))
  // splat a sequence to have its values passed as varargs
  println(sum(1 to 5*))
  println(sum(List(1, 2, 3, 4, 5)*))

  /**
   * A recursive varargs function
   *
   * @param args
   *   a vararg parameter
   * @return
   *   the result
   */
  def recursiveSum(args: Int*): Int =
    // "tail" is a collection, it needs to be splat to be passed as vararg
    if args.isEmpty then 0 else args.head + recursiveSum(args.tail*)

  println(recursiveSum(1, 2, 3, 4, 5))
  // splat a sequence to have its values passed as varargs
  println(recursiveSum(1 to 5 *))
  println(recursiveSum(List(1, 2, 3, 4, 5) *))
