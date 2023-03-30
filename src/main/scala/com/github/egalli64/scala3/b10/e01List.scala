/*
  https://docs.scala-lang.org/scala3/book/collections-classes.html
  https://github.com/egalli64/scala-playground

  Collections Types - List

  Three main categories of collections
    Seq - Sequences: indexed (e.g. array), linear (e.g. linked list)
    Map - Maps: collections of key/value pairs
    Set - Sets: unique elements

  Based on traits: Seq, Map, Set
  All of them are Iterable
  Usually there are immutable and mutable concrete classes implementations

  Commonly used sequences:

  Vector: indexed - immutable
  List: linear - immutable
  ArrayBuffer: indexed - mutable
  ListBuffer: linear - mutable
 */

package com.github.egalli64.scala3.b10

@main
def listIntro(): Unit =
  /*
    List is a singly linked list that ends with the Nil element
   */

  // creation - implicit type
  val numbers = List(1, 2, 3)
  println(numbers)

  // same, using the "cons" operator
  val names = "Tom" :: "Bob" :: "Tim" :: Nil
  println(names)

  /*
    Any vs Union types
   */
  val dataAny = List(1, "two", 3.0)
  println(dataAny)

  val dataUnion: List[String | Int | Double] = List(1, "two", 3.0)
  println(dataUnion)

  /*
    Adding elements to a List by prepending
      Single element by ::
      Another list by :::
    Notice that List are immutable, a new one is generated
   */
  val names2 = "Bill" :: names
  println("Prepended with a new name: " + names2)

  val names3 = List("Kim", "Jim") ::: names
  println("Prepended with a another list: " + names3)

  // generic prepending, for any sequence
  val names4 = "Tom" +: names3
  println(names4)

  // generic appending, for any sequence, _not_ advisable for (long) lists
  val names5 = names4 :+ "Zoe"
  println(names5)

  // looping over a list
  for name <- names5 do println(name)
