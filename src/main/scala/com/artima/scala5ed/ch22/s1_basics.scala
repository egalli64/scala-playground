/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Extension Methods - The basics
 */
package com.artima.scala5ed.ch22

@main
def s1_basics(): Unit =
  /**
   * A cleanup function, spaces at begin/end are removed, multiple whitespaces of any type in the
   * middle are compressed to a single blank
   *
   * @param s
   *   a string
   * @return
   *   the "cleaned" string
   */
  def singleSpaceFree(s: String): String = s.trim.split("\\s+").mkString(" ")

  println(singleSpaceFree("A Tale\tof Two Cities"))
  println(singleSpaceFree("  It was the\t\tbest\nof times.  "))

  val s = "One Fish, Two\tFish "
  val t = " One Fish, Two Fish"
  println(s"Is s considered same as t? ${singleSpaceFree(s) == singleSpaceFree(t)}")

  /*
    Defining singleSpace as an extension of the String class
   */
  extension (s: String) def singleSpace: String = s.trim.split("\\s+").mkString(" ")

  println(s"Is s considered same as t? ${s.singleSpace == t.singleSpace}")
