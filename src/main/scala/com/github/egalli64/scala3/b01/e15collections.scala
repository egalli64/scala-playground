/*
  https://docs.scala-lang.org/scala3/book/taste-collections.html
  https://github.com/egalli64/scala-playground

  Collections
 */
package com.github.egalli64.scala3.b01

@main
def collections(): Unit =
  // 1. List: an immutable, linked-list class

  println("Creating lists from values, ranges, by the range factory method:")
  println("A list: " + List(1, 2, 3)); // implicit List[Int]
  println("Range toList: " + (1 to 5).toList)
  println("Stepped range toList: " + (1 to 10 by 2).toList)
  println("Range until toList: " + (1 until 5).toList)
  println("List by range(): " + List.range(1, 5))
  println("List by range() with step: " + List.range(1, 10, 2))

  // 2. A few functional methods on list
  val l = List(10, 20, 30, 40, 10)

  println("Functional methods from base: " + l)
  println("Drop first 2 elements: " + l.drop(2))
  println("Drop heading while less than 25: " + l.dropWhile(_ < 25))
  println("Filter, keep less than 25: " + l.filter(_ < 25))
  println("Get slice [2..4): " + l.slice(2, 4))
  println("Get tail: " + l.tail)
  println("Take 3 heading: " + l.take(3))
  println("Take heading while less than 25: " + l.takeWhile(_ < 25))

  // 3. flatten, map, flatMap
  val biList = List(List(1, 2), List(3, 4))
  println(s"Flatten $biList is ${biList.flatten}")

  val numbers = List("one", "two")
  println(s"Mapped $numbers by uppercase is ${numbers.map(_.toUpperCase)}")
  println(s"Flat-mapped $numbers by uppercase is ${numbers.flatMap(_.toUpperCase)}")

  // 4. Folding and reducing left
  val firstTen = (1 to 10).toList
  println(s"$firstTen reduced left is ${firstTen.reduceLeft(_ + _)}")
  println(s"$firstTen folded left is ${firstTen.foldLeft(100)(_ + _)}")

  // 5. Tuple, heterogeneous collection
  val t = (11, "eleven")
  println(s"tuple $t, first is ${t(0)}, second is ${t(1)}")
  val (first, second) = t
  println(s"tuple $t, extracted first: $first, and second: $second")
