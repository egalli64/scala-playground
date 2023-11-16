/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  5. Classes
   3. Properties with Only Getters
 */
package com.horstmann.scala3ed.ch05

import java.time.Instant

@main
def s3_readonly_property(): Unit =
  class Message:
    val timeStamp: Instant = java.time.Instant.now

  val message = Message()
  println(message.timeStamp)

  // won't compile, can't reassign a val
  // message.timeStamp = java.time.Instant.now

  class Counter:
    private var _value = 0
    def increment(): Unit = _value += 1
    def value: Int = _value

  val counter = Counter()
  println(counter.value)

  // won't compile, no parameter, no parentheses
  // println(counter.value())

  // won't compile, can't reassign a val (!)
  // counter.value = 42

  counter.increment()
  println(counter.value)
