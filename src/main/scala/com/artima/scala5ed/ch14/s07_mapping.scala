/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Working with Lists - Higher-order methods on class List
  A higher-order method takes one or more functions as arguments

  Mapping over lists: map, flatMap and foreach
 */
package com.artima.scala5ed.ch14

@main
def s07(): Unit =
  // 1. map
  val numbers = List(1, 2, 3)
  val increasedNumbers = numbers.map(_ + 1)
  println(s"Mapping $numbers to $increasedNumbers by increasing")
  val words = List("the", "quick", "brown", "fox")
  val lenWords = words.map(_.length)
  println(s"Mapping $words to $lenWords by length")
  val obscured = words.map(_.toList.reverse.mkString)
  val rev = words.map(_.reverse)
  println(s"Mapping $words to $obscured or, _same_, to $rev")

  // 2. flatMap
  val mapCharsInWords = words.map(_.toList)
  println(s"From $words to $mapCharsInWords")

  val flatMapCharsInWords = words.flatMap(_.toList)
  println(s"From $words to $flatMapCharsInWords")

  /*
    Constructs a list of all pairs (i; j) such that 1 <= j < i < 5:

    1. create a list from the range (1, 5) ---> 1, 2, 3, 4
    2. for each value in the list
        a. create a list from the range (1, i)
            ---> empty / 1 / 1, 2 / 1, 2, 3 / 1, 2, 3, 4
        b. map each element j in the list to the tuple (i, j)
            ---> (2, 1) / (3, 1), (3, 2) / (4, 1), (4, 2), (4, 3)
    3. flat map the resulting list ---> List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3))
   */
  val x1 = List.range(1, 5).flatMap(i => List.range(1, i).map(j => (i, j)))
  println(x1)

  /*
    Constructs a list of all pairs (i; j) such that 1 <= j < i < 5:

    For each i in range (1, 5), each j in (1, i) generate the tuple (i, j) in the resulting list
   */
  val x2 = for i <- List.range(1, 5); j <- List.range(1, i) yield (i, j)
  println(x2)

  // 3. foreach
  var sum = 0
  numbers.foreach(sum += _)
  println(s"Sum of $numbers is $sum")
