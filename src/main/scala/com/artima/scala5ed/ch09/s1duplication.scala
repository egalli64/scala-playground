/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Control Abstraction - Reducing code duplication
 */
package com.artima.scala5ed.ch09

import java.io.File

@main
def s1duplication(): Unit =
  /**
   * A file matcher utility
   */
  object FileMatcher:
    private def filesHere = new java.io.File(".").listFiles
    def filesEnding(query: String): Array[File] =
      for file <- filesHere if file.getName.endsWith(query) yield file

    def filesContaining(query: String): Array[File] =
      for file <- filesHere if file.getName.contains(query) yield file

    def filesRegex(query: String): Array[File] =
      for file <- filesHere if file.getName.matches(query) yield file

  println(FileMatcher.filesEnding("sbt").mkString("\n"))
  println("---")

  println(FileMatcher.filesContaining("scala").mkString("\n"))
  println("---")

  println(FileMatcher.filesRegex("^b.*t$").mkString("\n"))
  println("---")

  /**
   * A refactored file matcher utility
   */
  object FileMatcher2:
    private def filesHere = new java.io.File(".").listFiles

    /**
     * A first-class function provides the structure
     *
     * @param matcher
     *   lambda provided by caller explaining how to filter the result
     * @return
     *   the filtered data
     */
    private def filesMatching(matcher: String => Boolean) =
      for file <- filesHere if matcher(file.getName) yield file

    def filesEnding(query: String): Array[File] =
      // a closure associates the passed string to the required function literal
      filesMatching(_.endsWith(query))

    def filesContaining(query: String): Array[File] = filesMatching(_.contains(query))

    def filesRegex(query: String): Array[File] = filesMatching(_.matches(query))

  println(FileMatcher2.filesEnding("t").mkString("\n"))
  println("---")

  println(FileMatcher2.filesContaining("scala").mkString("\n"))
  println("---")

  println(FileMatcher2.filesRegex("^b.*t$").mkString("\n"))
  println("---")
