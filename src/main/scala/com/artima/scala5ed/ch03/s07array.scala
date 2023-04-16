/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Next Steps in Scala - Parameterize arrays with types
 */
package com.artima.scala5ed.ch03

@main
def s07(): Unit =
  /*
    An object in Scala is _parametrized_ on creation, assigning a type and a value to it

    Here a BigInteger object is parametrized with the value 12345
   */
  val big = new java.math.BigInteger("12345")
  println(big)

  /*
    In Scala "new" could be inferred by the compiler
   */
  val b2 = java.math.BigInteger("54321")
  println(b2)

  /*
    We could parametrized the type too - in Java this is done through the concept of generic type

    The parametric type (or types) is specified in square brackets

    Here an array is created, parametrized in type - String - and its value, the size: 3
   */
  val greetStrings = new Array[String](3)

  // notice the write access to an element in the array by round brackets
  greetStrings(0) = "Hello"
  greetStrings(1) = ", "
  greetStrings(2) = "world!\n"

  // the read access to array elements is done by round brackets too
  for i <- 0 to 2 do print(greetStrings(i))

  /*
    There are no operators in Scala
    "to" is a function and 0 to 2 is converted in 0.to(2) - generating a range
   */
  val to1 = 0 to 2
  println(to1)

  val to2 = 0.to(2)
  println(to2)

  /*
    Same for +, -, ...
   */
  val sum1 = 1 + 2
  println(sum1)

  val sum2 = 1.+(2)
  println(sum2)

  /*
    A class in Scala is kind of a C++ functor where the method "()" is resolved by the compiler

    For calls on the right-hand side of an assignment, Array uses its apply() to give read access to its components
   */
  println(greetStrings(0))
  println(greetStrings.apply(0))

  /*
      If the call is on the left-hand side of an assignment, it is resolved as an update() call
   */
  greetStrings(0) = "Ciao"
  println(greetStrings(0))

  greetStrings.update(0, "Hi")
  println(greetStrings.apply(0))

  /*
    If the call is made on the class, apply() is a factory method
   */
  val numbers = Array("zero", "one", "two", "three")
  println(numbers(2))

  val numbers2 = Array.apply("zero", "one", "two", "three")
  println(numbers2(2))
