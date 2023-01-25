/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 4 - Types and Pattern Matching - Practice Programming Assignment: Huffman Coding
 */
package org.coursera.efpl.course1.week4.assignment

/** A huffman code is represented by a binary tree.
  *
  * Every `Leaf` node of the tree represents one character of the alphabet that the tree can encode.
  * The weight of a `Leaf` is the frequency of appearance of the character.
  *
  * The branches of the huffman tree, the `Fork` nodes, represent a set containing all the
  * characters present in the leaves below it. The weight of a `Fork` node is the sum of the weights
  * of these leaves.
  */
abstract class CodeTree
case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
case class Leaf(char: Char, weight: Int) extends CodeTree

/** Assignment 4: Huffman coding
 */
trait Huffman: // extends HuffmanInterface:
  // Part 1: Basics
  def weight(tree: CodeTree): Int = tree match
    case Fork(_, _, _, weight) => weight
    case Leaf(_, weight)       => weight

  def chars(tree: CodeTree): List[Char] = tree match
    case Fork(_, _, chars, _) => chars
    case Leaf(char, _)        => char :: Nil

  def makeCodeTree(left: CodeTree, right: CodeTree): Fork =
    Fork(left, right, chars(left) ::: chars(right), weight(left) + weight(right))

object Huffman extends Huffman

@main
def huffmanSmoke(): Unit =
  import Huffman.*
  val l1 = Leaf('x', 7)
  println("Weight: " + weight(l1))
