/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Other Collections - Tuples
 */
package com.artima.scala5ed.ch15

@main
def s5_tuple(): Unit =
  val t1 = (1, "hello", Console)
  println("A tuple: " + t1)

  /**
   * A function returning a tuple
   *
   * @param words
   *   an array of words
   * @return
   *   the longest passed word, and its position
   */
  def longestWord(words: Array[String]): (String, Int) =
    var word = words(0)
    var idx = 0
    for i <- 1 until words.length do
      if words(i).length > word.length then
        word = words(i)
        idx = i
    (word, idx)

  val input = "The quick brown fox"
  val longest = longestWord(input.split(" "))
  println(s"From $input to $longest")

  // access to tuple component
  println("The longest word is " + longest(0))

  // splat tuple
  val (word, idx) = longest
  println(s"Word is $word and index is $idx")

  // don't confuse it with multiple definition!
  val word2, idx2 = longest
  println(s"Word2 is $word2 just like index2 is $idx2")
