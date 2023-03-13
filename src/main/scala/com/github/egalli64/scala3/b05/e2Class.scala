/*
  https://docs.scala-lang.org/scala3/book/domain-modeling-oop.html
  https://github.com/egalli64/scala-playground

  Domain Modeling - OOP Modeling - Class
 */
package com.github.egalli64.scala3.b05

@main
def classes(): Unit =
  /**
   * 1: A class is usually a leaf in the inheritance model
   *
   * If required extends traits (and classes), can have instances
   *
   * @param name
   *   the service name
   */
  class MyService(name: String) extends ComposedService, Showable:
    def show = s"$name says $sayHello"

  val s1 = MyService("Service 1")
  println(s1.show)

  /**
   * 2: The Liskov principle
   */
  val s2: GreetingService = s1
  println(s2.translate("Hello"))

  val s3: TranslationService = s1
  println(s3.translate("Bye"))

  val s4: Showable = s1
  println(s4.showHtml)

  /**
   * 3: Also classes could be extended
   *
   * @param name
   *   the person name
   */
  class Person(name: String):
    def hello(): Unit = println(s"Hello, $name")

  class SoftwareDeveloper(name: String, favoriteLang: String) extends Person(name):
    override def toString: String = s"$name favorite language is $favoriteLang"

  val tom = SoftwareDeveloper("Tom", "Scala")
  println(tom)
  tom.hello()

  /**
   * 4: Access Modifiers
   *
   * By default, members are public. They could also be private or protected
   *
   * Here, currentCount is represents a private mutable state
   */
  class Counter:
    // can only be observed by the method `count`
    private var currentCount = 0

    def tick(): Unit = currentCount += 1
    def count: Int = currentCount

  val c1 = Counter()
  println(c1.count) // 0
  c1.tick()
  c1.tick()
  println(c1.count) // 2