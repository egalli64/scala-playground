/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Packages, Imports, and Exports - Imports
 */
//package com.artima.scala5ed.ch12

package pack3:
  abstract class Fruit(val name: String, val color: String)
  object Fruits:
    object Apple extends Fruit("apple", "red")
    object Orange extends Fruit("orange", "orange")
    object Pear extends Fruit("pear", "yellowish")

    val menu: Seq[Fruit] = List(Apple, Orange, Pear)

@main
def s3import(): Unit =
  // easy access to Fruit - single import
  import pack3.Fruit
  println(classOf[Fruit])

  // easy access to all members of pack3 - on-demand import
  import pack3.*
  println(Fruits.getClass)

  // easy access to all members of Fruits - like Java static import
  // exception to import by "as _"
  import pack3.Fruits.{Apple as _, *}
  println(s"${Fruits.Apple.getClass}, ${Orange.getClass}, ${Pear.getClass}")
  println(menu)

  /**
   * Import could be done anywhere and also for values (singleton or regular)
   *
   * @param fruit
   *   a fruit
   * @return
   *   a string
   */
  def showFruit(fruit: Fruit) =
    // all members of fruit are imported
    import fruit.*
    s"${name}s are $color"

  println(showFruit(Pear))
