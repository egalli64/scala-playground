/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functions and Closures - Methods
  Method: Functional member of an object
 */
package com.artima.scala5ed.ch08

@main
def s01method(): Unit =
  object Padding:
    /**
     * A public (by default) method that pads the lines passed as a string
     *
     * @param text
     *   could contain more lines separated by \n
     * @param minWidth
     *   if a line is shorter, it would be left-padded with blanks
     * @return
     *   the padded input
     */
    def padLines(text: String, minWidth: Int): String =
      val paddedLines = for line <- text.linesIterator yield padLine(line, minWidth)
      paddedLines.mkString("\n")

    /**
     * A private method that pads a single line
     *
     * @param line
     *   the input line
     * @param minWidth
     *   the minimal line length, when padded
     * @return
     *   the padded input line
     */
    private def padLine(line: String, minWidth: Int): String =
      if line.length >= minWidth then line else " " * (minWidth - line.length) + line

  val text = "a\nab\nabc\nabba"
  println("input:\n" + text)

  val padded = Padding.padLines(text, 4)
  println("output:\n" + padded)
