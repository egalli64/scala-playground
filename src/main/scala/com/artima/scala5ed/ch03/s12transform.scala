/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Next Steps in Scala - Transform with map and for-yield
 */
package com.artima.scala5ed.ch03

@main
def s12(): Unit =
  /*
    Functional style: a goal is achieved transforming immutable data structures into new ones
   */

  // given a list ...
  val adjectives = List("One", "Two", "Red", "Blue")
  println(adjectives)

  // transform it into a new one by map()
  val nouns = adjectives.map(adj => adj + " Fish")
  println(nouns)

  // transform it into a new one by for-yield expression
  val nouns2 = for adjective <- adjectives yield adjective + " Fish"
  println(nouns2)

  // while mapping we can change the type of the elements
  val lengths = nouns.map(noun => noun.length)
  println(lengths)

  // choose the approach you like the most - no real difference
  val lengths2 = for noun <- nouns yield noun.length
  println(lengths2)

  // many types could be mapped in this way, for instance Vector
  val questions = Vector("Who", "What", "When", "Where", "Why")
  val mappedQ = questions.map(question => question.toLowerCase + "?")
  println(mappedQ)
  val yieldedQ = for question <- questions yield question.toLowerCase() + "?"
  println(yieldedQ)

  // Option - close to Java Optional - is preferred over null

  // find() returns a Option: Some with the first found, None for not found
  val startsW = questions.find(q => q.startsWith("W"))
  println("First question starting by W is " + startsW)

  val hasLen4 = questions.find(_.length == 4)
  println("First question sized 4 is " + hasLen4)

  val hasLen5 = questions.find(q => q.length == 5)
  println("First question sized 5 is " + hasLen5)

  val startsH = questions.find(_.startsWith("H"))
  println("First question starting by H is " + startsH)

  // map() / for-yield is defined also on Option
  println(startsW.map(_.toUpperCase()))
  println(for s <- startsW yield s.toUpperCase())
  println(startsH.map(_.toUpperCase()))
  println(for s <- startsH yield s.toUpperCase())
