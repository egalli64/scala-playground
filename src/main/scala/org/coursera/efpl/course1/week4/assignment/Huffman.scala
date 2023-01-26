/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 4 - Types and Pattern Matching - Practice Programming Assignment: Huffman Coding
 */
package org.coursera.efpl.course1.week4.assignment

/**
 * A huffman code is represented by a binary tree.
 *
 * Every `Leaf` node of the tree represents one character of the alphabet that the tree can encode.
 * The weight of a `Leaf` is the frequency of appearance of the character.
 *
 * The branches of the huffman tree, the `Fork` nodes, represent a set containing all the characters
 * present in the leaves below it. The weight of a `Fork` node is the sum of the weights of these
 * leaves.
 */
abstract class CodeTree
case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
case class Leaf(char: Char, weight: Int) extends CodeTree

/**
 * Assignment 4: Huffman coding - `patmat` project
 */
trait Huffman: // extends HuffmanInterface:
  // Part 1: Basics
  /**
   * Getter
   *
   * @param tree
   *   a CodeTree
   * @return
   *   its weight
   */
  def weight(tree: CodeTree): Int = tree match
    case Fork(_, _, _, weight) => weight
    case Leaf(_, weight)       => weight

  /**
   * Getter / adapter to List[Char] for Leaf
   *
   * @param tree
   *   a CodeTree
   * @return
   *   its chars / its char converted to List for Leaf
   */
  def chars(tree: CodeTree): List[Char] = tree match
    case Fork(_, _, chars, _) => chars
    case Leaf(char, _)        => char :: Nil

  /**
   * Fork factory, put together two CodeTrees
   *
   * @param left
   *   first code tree
   * @param right
   *   second code tree
   * @return
   *   the fork for the two input code tree
   */
  def makeCodeTree(left: CodeTree, right: CodeTree): Fork =
    Fork(left, right, chars(left) ::: chars(right), weight(left) + weight(right))

// Part 2: Generating Huffman trees

  /**
   * In this assignment, we are working with lists of characters. This function allows you to easily
   * create a character list from a given string.
   *
   * @param str
   *   a string
   * @return
   *   the string converted to a list of characters
   */
  def string2Chars(str: String): List[Char] = str.toList

  /**
   * This function computes for each unique character in the list `chars` the number of times it
   * occurs. For example, the invocation
   *
   * times(List('a', 'b', 'a'))
   *
   * should return the following (the order of the resulting list is not important):
   *
   * List(('a', 2), ('b', 1))
   *
   * The type `List[(Char, Int)]` denotes a list of pairs, where each pair consists of a character
   * and an integer. Pairs can be constructed easily using parentheses:
   *
   * val pair: (Char, Int) = ('c', 1)
   *
   * In order to access the two elements of a pair, you can use the accessors `_1` and `_2`:
   *
   * val theChar = pair._1 val theInt = pair._2
   *
   * Another way to deconstruct a pair is using pattern matching:
   *
   * pair match { case (theChar, theInt) => println("character is: "+ theChar) println("integer is :
   * "+ theInt) }
   *
   * @param chars
   *   a list of characters
   * @return
   *   a frequency list for each character in the input list, without duplicates
   */
  def times(chars: List[Char]): List[(Char, Int)] =
    chars.distinct.map(char => (char, chars.count(_ == char)))

  /**
   * Returns a list of `Leaf` nodes for a given frequency table `freqs`.
   *
   * The returned list should be ordered by ascending weights (i.e. the head of the list should have
   * the smallest weight), where the weight of a leaf is the frequency of the character.
   *
   * @param freqs
   *   list of (char, frequency)
   * @return
   *   The conversion in list of leaves, sorted by weight
   */
  def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] =
    freqs.sortBy(_._2).map(freq => Leaf(freq._1, freq._2))

  /**
   * Checks whether the list `trees` contains only one single code tree.
   *
   * @param trees
   *   a list of code trees
   * @return
   *   true if the list contains a single code tree
   */
  def singleton(trees: List[CodeTree]): Boolean = trees.size == 1

  /**
   * The parameter `trees` of this function is a list of code trees ordered by ascending weights.
   *
   * This function takes the first two elements of the list `trees` and combines them into a single
   * `Fork` node. This node is then added back into the remaining elements of `trees` at a position
   * such that the ordering by weights is preserved.
   *
   * If `trees` is a list of less than two elements, that list should be returned unchanged.
   *
   * @param trees a list of code trees
   * @return same data, but, when possible, the first two elements are put in a Fork
   */
  def combine(trees: List[CodeTree]): List[CodeTree] =
    if trees.size < 2 then trees
    else (makeCodeTree(trees.head, trees.tail.head) :: trees.tail.tail).sortBy(weight)

  /**
   * This function will be called in the following way:
   *
   * until(singleton, combine)(trees)
   *
   * where `trees` is of type `List[CodeTree]`, `singleton` and `combine` refer to the two functions
   * defined above.
   *
   * In such an invocation, `until` should call the two functions until the list of code trees
   * contains only one single tree, and then return that singleton list.
   *
   * @param done a predicate, we'll use "singleton"
   * @param merge a function converting list to list, we'll use "combine"
   * @param trees a list of code trees
   * @return the singleton generated by folding the list with merge
   */
  def until(done: List[CodeTree] => Boolean, merge: List[CodeTree] => List[CodeTree]) //
  (trees: List[CodeTree]): List[CodeTree] = //
    if (done(trees)) trees
    else until(done, merge)(merge(trees))

  /**
   * This function creates a code tree which is optimal to encode the text `chars`.
   *
   * The parameter `chars` is an arbitrary text. This function extracts the character frequencies
   * from that text and creates a code tree based on them.
   *
   * @param chars a list of characters
   * @return the code tree representing it
   */
  def createCodeTree(chars: List[Char]): CodeTree =
    val trees = makeOrderedLeafList(times(chars))
    until(singleton, combine)(trees).head

/** The Huffman singleton */
object Huffman extends Huffman

/** Minimal smoke test for Huffman */
@main
def huffmanSmoke(): Unit =
  import Huffman.*
  val l1 = Leaf('x', 7)
  println("Weight: " + weight(l1))