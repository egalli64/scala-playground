/*
  https://docs.scala-lang.org/scala3/book/domain-modeling-oop.html
  https://github.com/egalli64/scala-playground

  Domain Modeling - OOP Modeling - Trait and mixin
 */
package com.github.egalli64.scala3.b05

@main
def traitMixin(): Unit =
  /**
   * 1: Scala decomposition is based on trait, where concrete members are provided services, and
   * abstract members are required services, to be implemented by subclasses
   */
  trait Showable:
    def show: String
    def showHtml: String = "<p>" + show + "</p>"

  /**
   * 1b: A class extending a trait can uses its provided services but has to implement the required
   * ones, so that it could be instantiated
   *
   * @param text
   *   the document text
   */
  class Document(text: String) extends Showable:
    def show: String = text

  val doc = Document("Stuff")
  println(doc.showHtml)

  /**
   * 2: Mixin. Traits could be mixed in a new trait by extension
   *
   * Abstract members in one trait are automatically matched with concrete members in another trait
   */
  trait GreetingService:
    def translate(text: String): String
    def sayHello: String = translate("Hello")

  trait TranslationService:
    def translate(text: String): String = s"$text translated is some way"

  trait ComposedService extends GreetingService, TranslationService

  class MyCS extends ComposedService

  val cs = MyCS()

  println(cs.sayHello)
  println(cs.translate("Tom"))
