/*
  https://docs.scala-lang.org/scala3/book/fun-hofs.html
  https://github.com/egalli64/scala-playground

  Functions - Higher-Order Functions
 */
package com.github.egalli64.scala3.b08

@main
def hof(): Unit =
  /*
    Higher-order function (HOF): takes other functions as input parameters or returns a function as a result

    Ex: List.filter accept a predicate on A and returns a List of A
      (predicate: function returning a boolean; A: generic type of both List and predicate)
   */
  List(1, 2, 3).filter(x => x % 2 == 0).foreach(println)

  /**
   * HOF, a consumer that runs the passed argument
   *
   * @param f
   *   a runnable
   */
  def sayHello(f: () => Unit): Unit = f()

  /**
   * A runnable takes no parameter, does not return anything
   */
  def helloJoe(): Unit = println("Hello, Joe")
  val bonjourJulien = () => println("Bonjour, Julien")

  /*
    Passing runnables to a HOF
   */
  sayHello(helloJoe)
  sayHello(bonjourJulien)

  /**
   * A HOF with a few parameters, uses its first argument to generate a value from the other
   * arguments to be printed
   *
   * @param f
   *   a function from two integers to an integer
   * @param i
   *   a first integer
   * @param j
   *   another integer
   */
  def executeAndPrint(f: (Int, Int) => Int, i: Int, j: Int): Unit =
    println(f(i, j))

  /*
    A few lambda respecting the signature of the first argument for the above HOF
   */
  def add(a: Int, b: Int): Int = a + b
  def subtract(a: Int, b: Int): Int = a - b
  def multiply(a: Int, b: Int): Int = a * b

  /*
    Calling a HOF with a few arguments
   */
  executeAndPrint(add, 3, 5)
  executeAndPrint(subtract, 3, 5)
  executeAndPrint(multiply, 3, 5)
