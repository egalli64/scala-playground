/*
  https://docs.scala-lang.org/scala3/book/taste-hello-world.html
  https://github.com/egalli64/scala-playground

  Hello World plus import for read
 */
package com.github.egalli64.scala3.b01

import scala.io.StdIn.readLine

@main def hello2(): Unit =
  print("Enter your name: ")
  val name = readLine()

  println("Hello, " + name + "!")
