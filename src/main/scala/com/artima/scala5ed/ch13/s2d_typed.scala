/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Pattern Matching - Kinds of patterns - Typed patterns

  Alternative to type test/cast
 */
package com.artima.scala5ed.ch13

@main
def s2d(): Unit =
  def generalSize(x: Any) = x match
    // typed pattern: if x is a (not null) String is casted in s
    case s: String    => s.length
    case m: Map[_, _] => m.size
    case _            => -1

  assert(generalSize("abc") == 3)
  assert(generalSize(Map(1 -> 'a', 2 -> 'b')) == 2)
  assert(generalSize(math.Pi) == -1)

  def doNotDoItLikeThis(x: Any) =
    if x.isInstanceOf[String] then
      val s = x.asInstanceOf[String]
      s.length
    else if x.isInstanceOf[Map[Any, Any]] then
      val m = x.asInstanceOf[Map[Any, Any]]
      m.size
    else -1

  assert(doNotDoItLikeThis("abc") == 3)
  assert(doNotDoItLikeThis(Map(1 -> 'a', 2 -> 'b')) == 2)
  assert(doNotDoItLikeThis(math.Pi) == -1)

  /**
   * Type erasure is a bad beast
   *
   * @param x
   *   could be anything
   * @return
   *   true if x is a (Int?) map
   */
  def isIntIntMap(x: Any) = x match
    case m: Map[Int, Int] => true
    case _                => false

  assert(isIntIntMap(Map(1 -> 1)))
  // No way to determine the actual type argument at runtime!
  assert(isIntIntMap(Map("abc" -> "abc")))

  /**
   * No type erasure for arrays (just like in Java)
   *
   * @param x
   *   could be anything
   * @return
   *   true if x is a string array
   */
  def isStringArray(x: Any) = x match
    case a: Array[String] => true
    case _                => false

  assert(isStringArray(Array("abc")))
  assert(!isStringArray(Array(1, 2, 3)))
