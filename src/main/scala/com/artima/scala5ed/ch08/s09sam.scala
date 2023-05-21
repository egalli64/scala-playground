/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Functions and Closures - Single Abstract Method (SAM) types
 */
package com.artima.scala5ed.ch08

@main
def s09sam(): Unit =
  /**
   * A SAM trait - it has a single abstract method
   */
  trait Increaser:
    /**
     * The trait single abstract method
     *
     * @param i
     *   the value to increase
     * @return
     *   the increased value
     */
    def increase(i: Int): Int

  /**
   * A method requiring a SAM as argument
   *
   * @param increaser
   *   a SAM to do the required job
   * @return
   *   the expected result
   */
  def increaseOne(increaser: Increaser): Int =
    increaser.increase(1)

  /**
   * A concrete increaser, implements the trait SAM
   */
  class IncreaseBySeven extends Increaser:
    def increase(i: Int): Int = i + 7

  // using the concrete SAM-based class
  val a = increaseOne(new IncreaseBySeven)
  println(a)

  // An anonymous SAM concrete implementation passed as lambda
  val b = increaseOne(
    new Increaser:
      def increase(i: Int): Int = i + 41
  )
  println(b)

  // Same, but in a much more compact form
  val c = increaseOne(i => i + 12)
  println(c)
