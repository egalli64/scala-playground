/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Built-in Control Structures - For expressions (Filtering)
 */
package com.artima.scala5ed.ch07

@main
def s3bFor(): Unit =
  val filesHere = new java.io.File(".").listFiles

  // Filtered loop - only the items matching the if clause are used - preferred approach
  for file <- filesHere if file.getName.endsWith("t") do println(file)
  println("---")

  // Alternative approach - filter in the for-do block
  for file <- filesHere do if file.getName.endsWith("t") then println(file)
  println("---")

  // Filtering loop - more if could be used
  for
    file <- filesHere
    if file.isFile
    if file.getName.endsWith("t")
  do println(file)
