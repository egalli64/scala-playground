/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 6 - Collections - Lecture 6.5 - Putting the Pieces Together
 */
package org.coursera.efpl.course1.week6

class Coder(words: List[String]):
  /** Mapping between digits in [2..9] and letters */
  private val mnemonics = Map(
    '2' -> "ABC",
    '3' -> "DEF",
    '4' -> "GHI",
    '5' -> "JKL",
    '6' -> "MNO",
    '7' -> "PQRS",
    '8' -> "TUV",
    '9' -> "WXYZ"
  )

  /** Map each char to its digit */
  val charCode: Map[Char, Char] =
    for mnemonic <- mnemonics; letter <- mnemonic._2 yield letter -> mnemonic._1

  /** Word to string of digits */
  def wordCode(word: String): String = word.toUpperCase.map(charCode)

  /** Map a digit string to all associated words */
  private val wordsForNum: Map[String, List[String]] =
    words.groupBy(wordCode).withDefaultValue(Nil)

  def encode(number: String): Set[List[String]] =
    if number.isEmpty then Set(Nil)
    else
      for
        splitPoint <- (1 to number.length).toSet
        word <- wordsForNum(number.take(splitPoint))
        rest <- encode(number.drop(splitPoint))
      yield word :: rest

  override def toString: String = "Coder"

@main
def lecture5(): Unit =
  val coder = Coder(List("Scala", "rocks"))
  println(coder.charCode)
  println("Tim mapped to " + coder.wordCode("Tim"))

  val input = "7225276257"
  println(coder.encode(input))
