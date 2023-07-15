/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - Methods of the List object
  Companion object methods
 */
package com.artima.scala5ed.ch14

@main
def s08_methods(): Unit =
  // 1. Creating lists from their elements: List.apply
  println(List.apply(1, 2, 3))
  // implicit call to List.apply()
  println(List(1, 2, 3))

  // 2. Creating a range of numbers: List.range(from, until)
  println("List in [1, 5) - 4 elements: " + List.range(1, 5))
  println("List in [5, 1) - empty: " + List.range(5, 1))
  println("List in [1, 9), step 2: " + List.range(1, 9, 2))
  println("List in [9, 1), step -3: " + List.range(9, 1, -3))

  // 3. Creating uniform lists: List.fill
  println("List of 5, filled with 'a': " + List.fill(5)('a'))
  println("List of 3 strings: " + List.fill(3)("hello"))
  println("A 2x3 list filled with 'b': " + List.fill(2, 3)('b'))

  // 4. Tabulating a function: List.tabulate, sort of fill, but calculating values in list
  val squares = List.tabulate(5)(n => n * n)
  println("Tabulating 5 with squares: " + squares)

  val multiplication = List.tabulate(5, 5)(_ * _)
  println("Tabulating 5x5 with multiplications: " + multiplication)

  // 5. Concatenating multiple lists: List.concat
  println("(a, b) + (c) = " + List.concat(List('a', 'b'), List('c')))
  println("() + (b) + (c) = " + List.concat(List(), List('b'), List('c')))
  println("Empty concat: " + List.concat())
