/*
  https://docs.scala-lang.org/scala3/book/types-structural.html
  https://github.com/egalli64/scala-playground

  Structural Types
 */
package com.github.egalli64.scala3.b12

@main
def e7structural(): Unit =
  /**
   * (Selectable is a marker trait for objects that support structural selection via selectDynamic and applyDynamic)
   *
   * @param elems sequence of pairs key/value - String/Any
   */
  class MyRecord(elems: (String, Any)*) extends Selectable:
    private val fields = elems.toMap

    def selectDynamic(name: String): Any = fields(name)

  type Person = MyRecord {
    val name: String
    val age: Int
  }

  val person = MyRecord(
    "name" -> "Emma",
    "age" -> 42
  ).asInstanceOf[Person]

  println("Access to age by static typing: " + person.selectDynamic("age").asInstanceOf[Int])

  println(s"The structural type way: ${person.name} is ${person.age} years old.")
