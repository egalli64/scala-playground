/*
  https://docs.scala-lang.org/scala3/book/packaging-imports.html
  https://github.com/egalli64/scala-playground

  Packaging and Imports

  No import required for packages java.lang and scala

  No import required for members of Predef object - as println()
 */
package com.github.egalli64.scala3.b09

/*
  Using multiple packages in the same file
 */
package users:
  class User

  package administrators:
    class AdminUser

  package normalusers:
    class NormalUser
    class Guest

  package extras:
    class SuperUser
    class Daemon

@main
def packageImport(): Unit =
  /*
    No import, access to class by full name
   */
  println("Accessing a class by its full name: " + users.administrators.AdminUser())

  /*
    Import everything from the `users` package
   */
  import users.administrators.*
  println("'Import-all' let a class be accessible by its simple name: " + AdminUser())

  /*
    Import only a class from a package
   */
  import users.User
  println("'Import-that' let a specific class be accessible by its simple name: " + User())

  /*
    Import only the named classes
   */
  import users.normalusers.{Guest, NormalUser}
  println("'Import-those' let the specified classes be accessible by its simple name: " + Guest())

  /*
    Import a class with an alias
   */
  import users.normalusers.Guest as NUGuest
  println("'Import-alias' let the specified classes be accessible by alias: " + NUGuest())

  /*
    Hiding members on import
   */
  import users.extras.{Daemon as _, *}
  println("'Import-hide' let the all classes but one be accessible: " + SuperUser())

  /*
    Import from objects - and import of static members from Java classes
   */
  import java.lang.Math.*
  println(s"'Static-import' to access Math members: $PI, ${cos(PI)}")
