/*
  https://docs.scala-lang.org/scala3/book/types-variance.html
  https://github.com/egalli64/scala-playground

  Variance

  Invariant: exactly the same type is expected for argument and return type
  Covariant: when sub-types could be used, following Liskov principle
  Contravariant: less common, for consumers, they could be super type
 */
package com.github.egalli64.scala3.b12

@main
def e5variance(): Unit =
  // Given a trait hierarchy based on Item
  trait Item {
    def productNumber: String
  }
  trait Buyable extends Item {
    def price: Int
  }
  trait Book extends Buyable {
    def isbn: String
  }

  /**
   * An _invariant_ type
   *
   * Types like Pipeline[Item], Pipeline[Buyable], and Pipeline[Book] are in no subtyping
   * relationship to each other.
   *
   * @tparam T
   *   the generic type
   */
  trait Pipeline[T]:
    def process(t: T): T

  class MyBuyable extends Buyable:
    override def price: Int = 43

    override def productNumber: String = "PN 43"

  class MyBook extends Book:
    override def isbn: String = "ISBN 44"

    override def productNumber: String = "PN 44"

    override def price: Int = 44

  class MyBuyablePipeline extends Pipeline[Buyable]:
    override def process(t: Buyable): Buyable = t

  /**
   * Being Pipeline an invariant type, exactly the specified template parameter type is expected
   *
   * @param p1
   *   a Buyable pipeline
   * @param p2
   *   another Buyable pipeline
   * @param b
   *   a Buyable
   * @return
   *   a price
   */
  def oneOf(
      p1: Pipeline[Buyable],
      p2: Pipeline[Buyable],
      b: Buyable
  ): Buyable =
    val b1 = p1.process(b)
    val b2 = p2.process(b)
    if b1.price < b2.price then b1 else b2

  val buyable = MyBuyable()
  val buyPipe = MyBuyablePipeline()

  println("One price - invariant: " + oneOf(buyPipe, buyPipe, buyable).price)

  // Invariant: Super generic type not accepted
//  class MyItemPipeline extends Pipeline[Item]:
//    override def process(t: Item): Item = t
//  val itemPipe = MyItemPipeline()
//  // won't compile - Found: (mip : MyItemPipeline) Required: Pipeline[Buyable]
//  println("One price: " + oneOf(buyPipe, itemPipe, buyable).price)

  // Invariant: Sub generic type not accepted
//  class MyBookPipeline extends Pipeline[Book]:
//    override def process(t: Book): Book = t
//  val bookPipe = MyBookPipeline()
//  // won't compile - Found: (bookPipe : MyBookPipeline) Required: Pipeline[Buyable]
//  println("One price: " + oneOf(buyPipe, bookPipe, buyable).price)

  /**
   * A _covariant_ type
   *
   * A Producer[Book] is accepted where a Producer[Buyable] is expected. Book is-a Buyable implies
   * Producer[Book] is-a Producer[Buyable]
   *
   * @tparam T
   *   the generic type
   */
  trait Producer[+T]:
    def make: T

  class MyBuyableProducer extends Producer[Buyable]:
    override def make: Buyable = MyBuyable()

  /**
   * Being Producer an covariant type, subs of the specified template parameter type are accepted
   *
   * @param p
   *   a Buyable (or subs) Producer
   * @return
   *   an int
   */
  def makeTwo(p: Producer[Buyable]): Int =
    p.make.price + p.make.price

  val buyableProd = MyBuyableProducer()
  println("Passing to myTwo() an object of the exactly type: " + makeTwo(buyableProd))

  // Covariant: Sub generic type accepted
  class MyBookProducer extends Producer[Book]:
    override def make: Book = MyBook()
  val bookProd = MyBookProducer()
  println("Calling myTwo() - covariant: " + makeTwo(bookProd))

  // Covariant: Super generic type not accepted
//  class MyItemProducer extends Producer[Item]:
//    override def make = MyItem()
//  val itemProd = MyItemProducer()
//  // won't compile - Found: (itemProd : MyItemProducer) Required: Producer[Buyable]
//  println("Calling myTwo(): " + makeTwo(itemProd))

  /**
   * A _contravariant_ type
   *
   * A Printer[Item] is accepted where a Printer[Buyable] is expected. Item is-a Buyable implies
   * Printer[Buyable] is-a Printer[Item]
   *
   * @tparam T
   *   the generic type
   */
  trait Printer[-T]:
    def print(t: T): Unit

  class MyBuyablePrinter extends Printer[Buyable]:
    override def print(t: Buyable): Unit = println("printing buyable: " + t)

  /**
   * Being Printer an contravariant type, supers of the specified template parameter type are
   * accepted
   *
   * @param p
   *   a Buyable (or supers) Printer
   */
  def buyPrint(p: Printer[Buyable]): Unit =
    p.print(buyable)

  val buyPrinter = MyBuyablePrinter()
  buyPrint(buyPrinter)

  // Contravariant: Super generic type accepted
  class MyItemPrinter extends Printer[Item]:
    override def print(t: Item): Unit = println("printing item - contravariant: " + t)
  val itemPrinter = MyItemPrinter()
  buyPrint(itemPrinter)

  // Contravariant: Sub generic type not accepted
//  class MyBookPrinter extends Printer[Book]:
//    override def print(t: Item): Unit = println("printing book: " + t)
//  val bookPrinter = MyBookPrinter()
//  // // won't compile - Found: (bookPrinter : MyBookPrinter) Required: Printer[Buyable]
//  buyPrint(bookPrinter)
