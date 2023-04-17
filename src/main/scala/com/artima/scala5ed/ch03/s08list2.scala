/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Next Steps in Scala - Use lists - methods and usages
 */
package com.artima.scala5ed.ch03

@main
def s08b(): Unit =
  println("The empty list: " + List.empty)
  println("Nil is the empty list: " + Nil)

  println("A new List[String] by factory: " + List("Cool", "tools", "rule"))

  val thrill = "Will" :: "fill" :: "until" :: Nil
  println("A new list by cons (::) " + thrill)

  val concatenated = List("a", "b") ::: List("c", "d")
  println("A new list by concatenation (:::) " + concatenated)

  println("The element @2 in thrill: " + thrill(2))
  println("Count the elements in thrill sized 4: " + thrill.count(s => s.length == 4))

  println("A copy of thrill, after dropping the first two elements: " + thrill.drop(2))
  println("A copy of thrill, after dropping the last two elements: " + thrill.dropRight(2))

  println("Check if exists an element sized 5 in thrill: " + thrill.exists(s => s.length == 5))
  println("Check if thrill contains an element _until_: " + thrill.contains("until"))
  println("Check if all elements in thrill end by _l_: " + thrill.forall(s => s.endsWith("l")))

  println("Filter thrill, keeping elements sized 4: " + thrill.filter(s => s.length == 4))
  println("Filter thrill, keeping elements _not_ sized 4: " + thrill.filterNot(s => s.length == 4))

  print("Print all the elements in thrill: ")
  thrill.foreach(s => print(s))
  println()

  print("Print all the elements in thrill (compact): ")
  thrill.foreach(print)
  println()

  println("The head of thrill: " + thrill.head)
  println("The init of thrill (cut off the last element): " + thrill.init)
  println("The last of thrill: " + thrill.last)
  println("The tail of thrill (cut off the first element): " + thrill.tail)

  println("The size of thrill: " + thrill.size)
  println("Is thrill empty? " + thrill.isEmpty)

  println("Map each string in thrill to itself plus _y_: " + thrill.map(s => s + "y"))

  println("Make a comma separate string from thrill: " + thrill.mkString(","))
  println("Reverse thrill: " + thrill.reverse)
  println("Sort thrill lowercase: " + thrill.sortWith((s, t) => s.toLowerCase() < t.toLowerCase()))
