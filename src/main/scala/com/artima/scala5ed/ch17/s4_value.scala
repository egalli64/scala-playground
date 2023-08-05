/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Scala’s Hierarchy - Defining your own value classes

  A custom value class can have just one parameter and could have only def inside
  Moreover, it is a non-local final subclass of AnyVal and can't redefine equals nor hashCode

  The actual JVM type is determined by the passed val, however, they are considered as real types by the compiler
 */
package com.artima.scala5ed.ch17

class Dollars(val amount: Int) extends AnyVal:
  override def toString: String = amount + " $"

class SwissFrancs(val amount: Int) extends AnyVal:
  override def toString = s"$amount CHF"

// a few tiny classes
class Anchor(val value: String) extends AnyVal
class Style(val value: String) extends AnyVal
class Text(val value: String) extends AnyVal
class Html(val value: String) extends AnyVal:
  override def toString: String = value

@main
def s4_value(): Unit =
  val money = Dollars(1_000_000)

  println("Dollars as string: " + money)
  println("Access the dollars amount: " + money.amount)

  val francs = SwissFrancs(1_000)
  println("Swiss francs as string: " + francs)

  // won't compile
  // val mistake: SwissFrancs = money

  /*
    tiny types help writing more robust code
   */

  def unsafeTitle(text: String, anchor: String, style: String): String =
    s"<a id='$anchor'><h1 class='$style'>$text</h1></a>"

  println("A mix-up: " + unsafeTitle("chap:vcls", "bold", "Value Classes"))

  def title(text: Text, anchor: Anchor, style: Style): Html =
    Html(s"<a id='${anchor.value}'>" + s"<h1 class='${style.value}'>" + text.value + "</h1></a>")

  // won't compile
  // println("A mix-up: " + title(Anchor("chap:vcls"), Style("bold"), Text("Value Classes")))

  println("Safer: " + title(Text("Value Classes"), Anchor("chap:vcls"), Style("bold")))
