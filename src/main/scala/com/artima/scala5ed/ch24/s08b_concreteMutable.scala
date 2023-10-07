/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Collections in Depth - Concrete mutable collection classes
  Queue, Stack
 */
package com.artima.scala5ed.ch24

import scala.collection.mutable

@main
def s08b_concreteMutable(): Unit =
  /*
    Queue
   */
  val queue = new mutable.Queue[String]
  println("An empty queue: " + queue)

  queue += "a" // Queue(a)
  queue ++= List("b", "c")
  println("After adding an element and then a list of two elements: " + queue)
  println("The first element was: " + queue.dequeue)

  println("After dequeue: " + queue)

  /*
    Stack
   */
  val stack = new mutable.Stack[Int]
  println("\nAn empty stack: " + stack)

  println("After pushing 1: " + stack.push(1))
  println("After pushing 2: " + stack.push(2))

  println("The top element is: " + stack.top)
  println("The popped element is: " + stack.pop)

  println("Now the stack is: " + stack)
