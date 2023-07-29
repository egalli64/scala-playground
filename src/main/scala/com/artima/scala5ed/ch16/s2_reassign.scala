/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Mutable Objects - Reassignable variables and properties
 */
package com.artima.scala5ed.ch16

@main
def s2_reassign(): Unit =
  /**
   * A class with public data members
   */
  class PublicTime:
    var hour = 12
    var minute = 0

    override def toString: String = s"Time is $hour:$minute"

  val pt = PublicTime()
  pt.hour = 13
  pt.minute = 20
  println(pt)
  println(pt.hour + "_" + pt.minute)

  class Time:
    private var _hour = 12
    private var _minute = 0

    /**
     * Getter
     *
     * @return
     *   the hour
     */
    def hour: Int = _hour

    /**
     * Setter
     *
     * @param hour
     *   new current hour
     */
    def hour_=(hour: Int): Unit = _hour = hour

    /**
     * Getter
     *
     * @return
     *   the minute
     */
    def minute: Int = _minute

    /**
     * Setter
     *
     * @param minute
     *   new current minute
     */
    def minute_=(minute: Int): Unit = _minute = minute

    override def toString: String = s"Time is $_hour:$_minute"

  val t = Time()
  // implicitly call the setter
  t.hour = 13
  t.minute = 20
  println(t)
  // implicitly call the getters
  println(t.hour + "_" + t.minute)

  class CheckedTime:
    private var _hour = 12
    private var _minute = 0

    def hour: Int = _hour
    def hour_=(hour: Int): Unit =
      require(0 <= hour && hour < 24)
      _hour = hour

    def minute: Int = _minute
    def minute_=(minute: Int): Unit =
      require(0 <= minute && minute < 60)
      _minute = minute

    override def toString: String = s"Time is $_hour:$_minute"

  val ct = CheckedTime()
  try ct.hour = 42
  catch case ex: IllegalArgumentException => println("Can't change hour to 42, " + ex)
  println(ct)
