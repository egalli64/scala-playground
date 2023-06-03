/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Packages, Imports, and Exports - Putting code in packages
 */

/**
 * A class placed in the unnamed package
 */
class Navigator

/**
 * packaging: explicitly placing code in a package
 */
package bobsrockets.navigation:
  class Navigator

@main
def s1unnamedPackage(): Unit =
  println(new Navigator().getClass)
  println(new bobsrockets.navigation.Navigator().getClass)
