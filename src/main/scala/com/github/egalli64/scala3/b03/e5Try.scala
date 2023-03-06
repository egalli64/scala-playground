/*
  https://docs.scala-lang.org/scala3/book/control-structures.html
  https://github.com/egalli64/scala-playground

  Try - catch - finally
 */
package com.github.egalli64.scala3.b03

@main
def tryMe(): Unit =
  /**
   * There's no try-with-resources in Scala (but see Using), put the cleanup in the finally clause.
   *
   * The try-catch construct is structured like a match
   *
   * @param x
   *   an integer matched to generate different exceptions
   */
  def notImplemented(x: Int): Unit = x match
    case 0 => throw IllegalArgumentException("Zero is not an acceptable input")
    case _ => throw UnsupportedOperationException("Not yet implemented")

  for i <- 0 to 1 do
    try notImplemented(i)
    catch
      case iae: IllegalArgumentException      => println(s"Bad value: $iae")
      case iae: UnsupportedOperationException => println(s"Can't call this function: $iae")
    finally println("Done")
