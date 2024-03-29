/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 4 - Types and Pattern Matching - Practice Programming Assignment: Huffman Coding
 */
package org.coursera.efpl.course1.week4.assignment

import scala.annotation.tailrec

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
   * @param trees
   *   a list of code trees
   * @return
   *   same data, but, when possible, the first two elements are put in a Fork
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
   * @param done
   *   a predicate, we'll use "singleton"
   * @param merge
   *   a function converting list to list, we'll use "combine"
   * @param trees
   *   a list of code trees
   * @return
   *   the singleton generated by folding the list with merge
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
   * @param chars
   *   a list of characters
   * @return
   *   the code tree representing it
   */
  def createCodeTree(chars: List[Char]): CodeTree =
    val trees = makeOrderedLeafList(times(chars))
    until(singleton, combine)(trees).head

  // Part 3: Decoding
  type Bit = Int

  /**
   * This function decodes the bit sequence `bits` using the code tree `tree` and returns the
   * resulting list of characters.
   *
   * @param tree
   *   a code tree
   * @param bits
   *   a list of bits
   * @return
   *   the list of decoded characters
   */
  def decode(tree: CodeTree, bits: List[Bit]): List[Char] =
    /**
     * Loop on the bits and on the tree. Each time a bit is decoded, back to the root to decode the
     * next bit.
     *
     * @param node
     *   the current node in tree
     * @param curBits
     *   the current cons in the bit list
     * @param acc
     *   accumulator for the decoded message
     * @return
     *   the decoded message
     */
    @tailrec
    def loop(node: CodeTree, curBits: List[Bit], acc: List[Char]): List[Char] =
      node match
        // the new char decoded is more naturally added at the list beginning
        case Leaf(char, _) => loop(tree, curBits, char :: acc)
        case Fork(left, right, _, _) =>
          curBits match
            // done, but the accumulator was created in the "wrong" way
            case Nil => acc.reverse
            // eat another bit and go down left or right
            case x :: _ =>
              x match
                case 0 => loop(left, curBits.tail, acc)
                case 1 => loop(right, curBits.tail, acc)

    loop(tree, bits, Nil)

  /**
   * A Huffman coding tree for the French language. Generated from the data given at
   * http://fr.wikipedia.org/wiki/Fr%C3%A9quence_d%27apparition_des_lettres_en_fran%C3%A7ais
   */
  private val frenchCode: CodeTree = Fork(
    Fork(
      Fork(
        Leaf('s', 121895),
        Fork(
          Leaf('d', 56269),
          Fork(
            Fork(
              Fork(Leaf('x', 5928), Leaf('j', 8351), List('x', 'j'), 14279),
              Leaf('f', 16351),
              List('x', 'j', 'f'),
              30630
            ),
            Fork(
              Fork(
                Fork(
                  Fork(
                    Leaf('z', 2093),
                    Fork(Leaf('k', 745), Leaf('w', 1747), List('k', 'w'), 2492),
                    List('z', 'k', 'w'),
                    4585
                  ),
                  Leaf('y', 4725),
                  List('z', 'k', 'w', 'y'),
                  9310
                ),
                Leaf('h', 11298),
                List('z', 'k', 'w', 'y', 'h'),
                20608
              ),
              Leaf('q', 20889),
              List('z', 'k', 'w', 'y', 'h', 'q'),
              41497
            ),
            List('x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q'),
            72127
          ),
          List('d', 'x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q'),
          128396
        ),
        List('s', 'd', 'x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q'),
        250291
      ),
      Fork(
        Fork(Leaf('o', 82762), Leaf('l', 83668), List('o', 'l'), 166430),
        Fork(
          Fork(Leaf('m', 45521), Leaf('p', 46335), List('m', 'p'), 91856),
          Leaf('u', 96785),
          List('m', 'p', 'u'),
          188641
        ),
        List('o', 'l', 'm', 'p', 'u'),
        355071
      ),
      List('s', 'd', 'x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q', 'o', 'l', 'm', 'p', 'u'),
      605362
    ),
    Fork(
      Fork(
        Fork(
          Leaf('r', 100500),
          Fork(
            Leaf('c', 50003),
            Fork(
              Leaf('v', 24975),
              Fork(Leaf('g', 13288), Leaf('b', 13822), List('g', 'b'), 27110),
              List('v', 'g', 'b'),
              52085
            ),
            List('c', 'v', 'g', 'b'),
            102088
          ),
          List('r', 'c', 'v', 'g', 'b'),
          202588
        ),
        Fork(Leaf('n', 108812), Leaf('t', 111103), List('n', 't'), 219915),
        List('r', 'c', 'v', 'g', 'b', 'n', 't'),
        422503
      ),
      Fork(
        Leaf('e', 225947),
        Fork(Leaf('i', 115465), Leaf('a', 117110), List('i', 'a'), 232575),
        List('e', 'i', 'a'),
        458522
      ),
      List('r', 'c', 'v', 'g', 'b', 'n', 't', 'e', 'i', 'a'),
      881025
    ),
    List('s', 'd', 'x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q', 'o', 'l', 'm', 'p', 'u', 'r', 'c',
      'v', 'g', 'b', 'n', 't', 'e', 'i', 'a'),
    1486387
  )

  /**
   * What does the secret message say? Can you decode it? For the decoding use the `frenchCode`
   * Huffman tree defined above.
   */
  private val secret: List[Bit] = List(0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1,
    1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0,
    1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1)

  /**
   * Write a function that returns the decoded secret
   */
  def decodedSecret: List[Char] = decode(frenchCode, secret)

  // Part 4a: Encoding using Huffman tree

  /**
   * This function encodes `text` using the code tree `tree` into a sequence of bits.
   *
   * @param tree
   *   the code tree
   * @param text
   *   the source to encode
   * @return
   *   the encoded message
   */
  def encode(tree: CodeTree)(text: List[Char]): List[Bit] =
    /**
     * Loop on tree, work each time on its current node and text list, adding to the accumulator a
     * bit each time is found. For efficiency the accumulator is generated reverted and then
     * adjusted when returning it.
     *
     * @param node
     *   the current node in the tree
     * @param curText
     *   the current text
     * @param acc
     *   the accumulator so far
     * @return
     *   the generated encoding for the text
     */
    @tailrec
    def loop(node: CodeTree, curText: List[Char], acc: List[Bit]): List[Bit] =
      // for efficiency the accumulator generation is reversed
      if (curText.isEmpty) acc.reverse
      else
        node match
          // current char encoded, back to tree root, pass to the next char
          case Leaf(_, _) => loop(tree, curText.tail, acc)
          // char is left or right, 0 or 1 is added to acc
          case Fork(left, right, _, _) =>
            // the new bit is added at the beginning of acc!
            if (chars(left).contains(curText.head)) loop(left, curText, 0 :: acc)
            else loop(right, curText, 1 :: acc)
    loop(tree, text, Nil)

  // Part 4b: Encoding using code table

  /** mapping between a char and its bit representation */
  type CodeTable = List[(Char, List[Bit])]

  /**
   * This function returns the bit sequence that represents the character `char` in the code table
   * `table`.
   *
   * @param table
   *   mapper between char and its encoding
   * @param char
   *   a character
   * @return
   *   its encoding
   */
  def codeBits(table: CodeTable)(char: Char): List[Bit] =
    @tailrec
    def loop(cur: CodeTable): List[Bit] =
      if cur.head._1 == char then cur.head._2
      else loop(cur.tail)

    loop(table)

  /**
   * Given a code tree, create a code table which contains, for every character in the code tree,
   * the sequence of bits representing that character.
   *
   * Hint: think of a recursive solution: every sub-tree of the code tree `tree` is itself a valid
   * code tree that can be represented as a code table. Using the code tables of the sub-trees,
   * think of how to build the code table for the entire tree.
   *
   * @param tree
   *   the code tree
   * @return
   *   the associated code table
   */
  def convert(tree: CodeTree): CodeTable =
    /**
     * Loop on the tree
     *
     * @param node
     *   current node
     * @param bits
     *   the list of bits associated to a char
     * @param acc
     *   accumulator for the result
     * @return
     *   the code table
     */
    def loop(node: CodeTree, bits: List[Bit], acc: CodeTable): CodeTable =
      node match
        // the char-bits pair is ready (bits reverted for performance)
        case Leaf(char, _) => (char, bits.reverse) :: acc
        // go down in the tree, generating a new bit list (reverting 0/1), then merge
        case Fork(left, right, _, _) =>
          mergeCodeTables(loop(left, 0 :: bits, acc), loop(right, 1 :: bits, acc))

    // inception with root, an empty list of bits, an empty code table
    loop(tree, Nil, Nil)

  /**
   * This function takes two code tables and merges them into one. Depending on how you use it in
   * the `convert` method above, this merge method might also do some transformations on the two
   * parameter code tables.
   *
   * No transformation required, just concatenate the two lists
   *
   * @param a
   *   first code table
   * @param b
   *   second code table
   * @return
   *   the concatenation of the two lists
   */
  def mergeCodeTables(a: CodeTable, b: CodeTable): CodeTable = a ::: b

  /**
   * This function encodes `text` according to the code tree `tree`.
   *
   * To speed up the encoding process, it first converts the code tree to a code table and then uses
   * it to perform the actual encoding.
   *
   * @param tree
   *   the code tree
   * @param text
   *   the input text
   * @return
   *   the encoded text
   */
  def quickEncode(tree: CodeTree)(text: List[Char]): List[Bit] =
    val table = convert(tree)

    /**
     * Helper loop.
     *
     * @param curText
     *   the text left to be encoded
     * @param acc
     *   accumulator for the result
     * @return
     *   the encoded text
     */
    @tailrec
    def loop(curText: List[Char], acc: List[Bit]): List[Bit] = curText match {
      case Nil     => acc
      case x :: xs => loop(xs, acc ::: codeBits(table)(x))
    }
    loop(text, Nil)

end Huffman

/** The Huffman singleton */
object Huffman extends Huffman

/** Minimal smoke test for Huffman */
@main
def huffmanSmoke(): Unit =
  import Huffman.*
  println(Huffman.decodedSecret.mkString)
