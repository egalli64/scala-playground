/*
  https://docs.scala-lang.org/scala3/book/methods-most.html
  https://github.com/egalli64/scala-playground

  Method Features - Parameters
 */
package com.github.egalli64.scala3.b07

import scala.util.Random

/**
 * 1 - Parameters could have a default value
 *
 * @param timeout
 *   defaulted to 5_000
 * @param protocol
 *   defaulted to http
 */
def makeConnection(timeout: Int = 5_000, protocol: String = "http"): Unit =
  println(f"timeout = $timeout, protocol = $protocol")

@main
def parameters(): Unit =
  print("both parameters defaulted: ")
  makeConnection()

  print("second parameter defaulted: ")
  makeConnection(2_000)

  print("no parameter defaulted: ")
  makeConnection(3_000, "https")

  // won't compiler, an Int is expected
  // makeConnection("https")

  /*
    2 - Parameter by name
   */
  print("timeout by-name, protocol defaulted: ")
  makeConnection(timeout = 10_000)

  print("timeout defaulted, protocol by-name: ")
  makeConnection(protocol = "https")

  print("both parameters by-name: ")
  makeConnection(timeout = 10_000, protocol = "https")

  print("both parameters by-name, swapping position: ")
  makeConnection(protocol = "https", timeout = 10_000)

  /*
    3 - No parameter / arity-0
   */

  /**
   * No parameter, no side effect THEN (by convention) no parenthesis
   *
   * @return
   *   a random number
   */
  def randomNumberGenerator = Random.nextInt

  /**
   * No parameter, side effect THEN (by convention) parenthesis
   */
  def sayGoodbye(): Unit = println("Goodbye")

  // parenthesis must match between declaration and invocation
  println("A random number: " + randomNumberGenerator)
  sayGoodbye()
