/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Packages, Imports, and Exports - Access modifiers
 */
package com.artima.scala5ed.ch12

@main
def s5a(): Unit =
  /**
   * Show private access modifier at work
   */
  class Outer:
    class Inner:
      // A private member is visible only inside its class or object
      private def f = "f"
      class InnerMost:
        f // OK
      end InnerMost
      println(new InnerMost())
    end Inner

    // Won't compile: method f cannot be accessed as a member of Outer.this.Inner from class Outer
    // (new Inner).f
    println(new Inner())
  end Outer

  println(new Outer().getClass)

  /**
   * Show protected access modifier at work
   */
  class Super:
    protected def f = "f"
  class Sub extends Super:
    f
  class Other:
    // protected method of super is not accessible outside its hierarchy
    // (new Super).f
    println(Super())

  println(Sub().getClass)
  println(Other().getClass)
