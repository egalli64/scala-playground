/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 6 - Collections - Practice Programming Assignment: Anagrams
 */
package org.coursera.efpl.course1.week6.assignment

import scala.annotation.tailrec

object Anagrams:
  /** A word is simply a `String`. */
  type Word = String

  /** A sentence is a `List` of words. */
  type Sentence = List[Word]

  /**
   * `Occurrences` is a `List` of pairs of characters and positive integers saying how often the
   * character appears. This list is sorted alphabetically w.r.t. to the character in each pair. All
   * characters in the occurrence list are lowercase.
   *
   * Any list of pairs of lowercase characters and their frequency which is not sorted is **not** an
   * occurrence list.
   *
   * Note: If the frequency of some character is zero, then that character should not be in the
   * list.
   */
  type Occurrences = List[(Char, Int)]

  /**
   * The dictionary is simply a sequence of words. It is predefined and obtained as a sequence using
   * the utility method `loadDictionary`.
   */
  private val dictionary: List[Word] = Dictionary.loadDictionary

  /**
   * Converts the word into its character occurrence list.
   *
   * Note: the uppercase and lowercase version of the character are treated as the same character,
   * and are represented as a lowercase character in the occurrence list.
   *
   * Note: you must use `groupBy` to implement this method!
   *
   * @param w
   *   a word (actually, a string)
   * @return
   *   the lowercase letters in the word, each seen as an occurrence, pair (Char, Int)
   */
  def wordOccurrences(w: Word): Occurrences =
    w.toLowerCase.groupBy(c => c).map((c, s) => (c, s.length)).toList.sorted

  /**
   * Converts a sentence into its character occurrence list.
   *
   * @param s
   *   a sentence (actually, a list of words)
   * @return
   *   the associated occurrences
   */
  def sentenceOccurrences(s: Sentence): Occurrences =
    wordOccurrences(s.mkString)

  /**
   * The `dictionaryByOccurrences` is a `Map` from different occurrences to a sequence of all the
   * words that have that occurrence count. This map serves as an easy way to obtain all the
   * anagrams of a word given its occurrence list.
   *
   * For example, the word "eat" has the following character occurrence list:
   *
   * `List(('a', 1), ('e', 1), ('t', 1))`
   *
   * Incidentally, so do the words "ate" and "tea".
   *
   * This means that the `dictionaryByOccurrences` map will contain an entry:
   *
   * List(('a', 1), ('e', 1), ('t', 1)) -> Seq("ate", "eat", "tea")
   */
  lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] =
    dictionary.groupBy(wordOccurrences).withDefaultValue(Nil)

  /**
   * Returns all the anagrams of a given word.
   *
   * @param word
   *   a word
   * @return
   *   all its anagrams in dictionary
   */
  def wordAnagrams(word: Word): List[Word] =
    dictionaryByOccurrences(wordOccurrences(word))

  /**
   * Returns the list of all subsets of the occurrence list. This includes the occurrence itself,
   * i.e. `List(('k', 1), ('o', 1))` is a subset of `List(('k', 1), ('o', 1))`. It also include the
   * empty subset `List()`.
   *
   * Example: the subsets of the occurrence list `List(('a', 2), ('b', 2))` are:
   *
   * List( List(), List(('a', 1)), List(('a', 2)), List(('b', 1)), List(('a', 1), ('b', 1)),
   * List(('a', 2), ('b', 1)), List(('b', 2)), List(('a', 1), ('b', 2)), List(('a', 2), ('b', 2)) )
   *
   * Note that the order of the occurrence list subsets does not matter -- the subsets in the
   * example above could have been displayed in some other order
   *
   * @param occurrences
   *   representation of text as occurrence of letters in it
   * @return
   *   all the possible subsets
   */
  def combinations(occurrences: Occurrences): List[Occurrences] =
    /**
     * Recursion to get all the combinations
     *
     * @param acc
     *   the accumulator, initialized with the empty occurrence
     * @param others
     *   the occurrences not yet seen
     * @return
     *   the final result
     */
    @tailrec
    def recursion(acc: List[Occurrences], others: Occurrences): List[Occurrences] = others match
      case Nil          => acc
      case head :: tail =>
        // all the head char variation in size are added to all the previously generated elements
        val generated = for l <- acc; i <- 1 to head._2 yield l :+ (head._1, i)
        // the accumulator is expanded with the newly generated lists, then get to the next
        recursion(acc ++ generated, tail)

    recursion(List(Nil), occurrences)
