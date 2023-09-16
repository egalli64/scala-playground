/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Typeclasses - Main methods
 */
package com.artima.scala5ed.ch23

/**
 * From the target/scala/classes folder, run scala com.artima.scala5ed.ch23.s3_main
 *
 * @param args
 *   the passed arguments, string varargs
 */
@main
def s3_main(args: String*): Unit =
  println("The passed arguments: " + args.mkString(" "))

/**
 * From the target/scala/classes folder, run scala com.artima.scala5ed.ch23.s3_main2
 *
 * Scala will check the arguments (number and type) at runtime
 *
 * @param word
 *   a string
 * @param count
 *   an int
 */
@main
def s3_main2(word: String, count: Int): Unit =
  val msg =
    if count > 0 then
      val words = List.fill(count)(word)
      words.mkString(" ")
    else "Please enter a word and a positive integer count."
  println(msg)

enum Mood:
  case Surprised, Angry, Neutral

val error = "Enter a word, a count, and a mood ('angry', 'surprised', or 'neutral')"

/**
 * From the target/scala/classes folder, run scala com.artima.scala5ed.ch23.s3_main2
 *
 * Scala will check the arguments (number and type) at runtime. We should explain how Scala should
 * convert a string to a mood.
 *
 * @param word
 *   a string
 * @param count
 *   an int
 * @param mood
 *   a mood
 */
@main
def s3_main3(word: String, count: Int, mood: Mood): Unit =
  val msg =
    if count > 0 then
      val words = List.fill(count)(word.trim)
      val extra = mood match
        case Mood.Angry     => "!"
        case Mood.Surprised => "?"
        case Mood.Neutral   => ""
      val sep = extra + " "
      words.mkString(sep) + extra
    else error
  println(msg)

/**
 * From string to mood
 */
object Mood:
  import scala.util.CommandLineParser.FromString
  given moodFromString: FromString[Mood] with
    def fromString(s: String): Mood = s.trim.toLowerCase match
      case "angry"     => Mood.Angry
      case "surprised" => Mood.Surprised
      case "neutral"   => Mood.Neutral
      case _           => throw new IllegalArgumentException(error)
