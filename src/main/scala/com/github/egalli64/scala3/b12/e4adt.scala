/*
  https://docs.scala-lang.org/scala3/book/types-adts-gadts.html
  https://github.com/egalli64/scala-playground

  Types and the Type System - Algebraic Data Types

  Algebraic Data Types (ADTs) can be created with the enum construct
 */
package com.github.egalli64.scala3.b12

@main
def e4adt(): Unit =
  /*
    // Option represented as ADT, with explicit extends
    enum MyOption[+T]:
      case Some(x: T) extends MyOption[T]
      case None extends MyOption[Nothing]


    println(MyOption.Some("hello"))
    println(MyOption.None)
   */

  // Option represented as ADT, with implicit extends
  enum MyOption[+T]:
    case Some(x: T)
    case None

    // as every enum, ADT could define additional methods
    def isDefined: Boolean = this match
      case None    => false
      case Some(_) => true

  println(MyOption.Some("hello"))
  println(MyOption.None)

  // define factories in the companion object
  object MyOption:
    def apply[T >: Null](x: T): MyOption[T] = if (x == null) None else Some(x)
    def apply[T](): MyOption[T] = None

  val mo = MyOption("Hello")
  println(s"x = $mo is defined? " + mo.isDefined)

  val mo2 = MyOption(null)
  println(s"x = $mo2 is defined? " + mo2.isDefined)

  val mo3 = MyOption()
  println(s"x = $mo3 is defined? " + mo3.isDefined)

  // A enum / ADT hybrid - Color with predefined case and a open one
  enum Color(val rgb: Int):
    case Red extends Color(0xff0000)
    case Green extends Color(0x00ff00)
    case Blue extends Color(0x0000ff)
    case Mix(mix: Int) extends Color(mix)

  val colors = List(Color.Green, Color.Green, Color.Mix(0x12b0a7))
  println(colors)

  // Recursive enumeration
  enum Nat:
    case Zero
    case Succ(n: Nat)

  import Nat.*
  val zero = Zero
  val two = Succ(Succ(Zero))
  println(s"Zero: $zero, two: $two")
