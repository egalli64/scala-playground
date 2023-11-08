/*
Scala for the Impatient Third Edition - Cay S. Horstmann
Source code shown in the book
Download the zip file from: https://horstmann.com/scala/

https://github.com/egalli64/scala-playground

2. Control Structures and Functions
 8. Default and Named Arguments L1
 */
package com.horstmann.scala3ed.ch02

@main
def s08_args(): Unit =
  /**
   * A function with two defaulted parameters
   *
   * @param str
   *   a plain parameter
   * @param left
   *   a parameter defaulted to "["
   * @param right
   *   a parameter defaulted to "]"
   * @return
   *   the result
   */
  def decorate(str: String, left: String = "[", right: String = "]") = left + str + right

  println(decorate("Bob"))
  println(decorate("Bob", "*", "*"))
  println(decorate("Bob", "<"))
  // passing a parameter "by name"
  println(decorate("Bob", right = ">"))
