/*
  https://docs.scala-lang.org/scala3/book/methods-most.html
  https://github.com/egalli64/scala-playground

  Method Features - object
 */
package com.github.egalli64.scala3.b07

import scala.annotation.targetName

/**
 * The object keyword identifies a singleton - useful for utility methods
 */
object StringUtils:
  /**
   * Create copy of the input string, but truncated to the specified length.
   *
   * @param s
   *   a string
   * @param length
   *   requested size for the new string
   * @return
   *   a new string
   */
  def truncate(s: String, length: Int): String = s.take(length)

  /**
   * Check if a string contains only letters and numbers.
   *
   * (Notice the _? at the end of the method name, someone likes it when a boolean is returned)
   *
   * @param s
   *   the checked string
   * @return
   *   true if it respects the request
   */
  @targetName("hasLettersAndNumbersOnly")
  def lettersAndNumbersOnly_?(s: String): Boolean = s.matches("[a-zA-Z0-9]+")

  /**
   * Check if the given string contains any whitespace at all. Assumes that `s` is not null.
   *
   * @param s
   *   a non-null string
   * @return
   *   true if it respects the request
   */
  def containsWhitespace(s: String): Boolean = s.matches(".*\\s.*")

end StringUtils

@main
def usingObject(): Unit =
  println("Truncating: " + StringUtils.truncate("Hello", 4))
  println("Check for letters and numbers: " + StringUtils.lettersAndNumbersOnly_?("Hello42"))
  println("Check for whitespace: " + StringUtils.containsWhitespace("Hello 42!"))
