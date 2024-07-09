/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  4. Map, Option, Tuple
   5. Linked and Sorted Maps
    Default map is hash based, the common alternative is BST based
 */
package com.horstmann.scala3ed.ch04

@main
def s5_map_link_sort(): Unit =
  /*
    Immutable hash map is a linked hash map, traversed in insertion order
   */
  val m1 = Map("Fred" -> 1, "Alice" -> 2, "Bob" -> 3)
  println("The immutable map preserves the insertion order: " + m1)

  val m2 = Map("Bob" -> 3, "Alice" -> 2, "Fred" -> 1)
  println("Another map: " + m2)

  /*
    For efficiency, by default mutable hash map is not linked
   */
  val mm1 = scala.collection.mutable.Map("Fred" -> 1, "Alice" -> 2, "Bob" -> 3)
  println("A mutable map (no order): " + mm1)

  val mm2 = scala.collection.mutable.Map("Bob" -> 3, "Alice" -> 2, "Fred" -> 1)
  println("Another mutable map: " + mm2)

  /*
    Use of mutable linked hash map
   */
  val lmm1 = scala.collection.mutable.LinkedHashMap("Fred" -> 1, "Alice" -> 2, "Bob" -> 3)
  println("A linked mutable map (insertion order preserved): " + lmm1)

  val lmm2 = scala.collection.mutable.LinkedHashMap("Bob" -> 3, "Alice" -> 2, "Fred" -> 1)
  println("Another linked mutable map: " + lmm2)

  /*
    Sorted maps
   */
  val sm = scala.collection.SortedMap("Fred" -> 1, "Alice" -> 2, "Bob" -> 3)
  println("A sorted map: " + sm)

  val smm = scala.collection.mutable.SortedMap("Fred" -> 1, "Alice" -> 2, "Bob" -> 3)
  println("A mutable sorted map: " + smm)
