/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  7. Packages, Imports, end Exports
   1. Packages - same purpose of Java packages
    With some difference, for instance, no need to match the folder name containing the file
 */
package com.horstmann.scala3ed.ch07

// an alternative notation for package definition
package com:
  package horstmann:
    package people:
      class Employee(val name: String)

@main
def s01_package(): Unit =
  val tom = com.horstmann.people.Employee("Tom")
  println(tom.name)
