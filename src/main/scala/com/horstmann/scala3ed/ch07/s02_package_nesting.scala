/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  7. Packages, Imports, end Exports
   2. Package Scope Nesting
 */
package com.horstmann.scala3ed.ch07

package com:
  package horstmann:
    package people:
      /**
       * com.horstmann.people,Employee, has access to com.horstmann.Math without need of an import
       *
       * @param name
       *   employee name
       * @param salary
       *   employee salary
       */
      class Employee2(val name: String, var salary: Double):
        /**
         * Notice the call to Math.percentOf, it is in scope! Notice/2: the package name is
         * _relative_!
         *
         * @param rate
         *   raise percentage
         */
        def giveRaise(rate: Double): Unit =
          salary += Math.percentOf(salary, rate)

    /**
     * Defined in com.horstmann
     *
     * Visible in the current package AND in the sub-packages
     */
    object Math:
      def percentOf(value: Double, rate: Double): Double = value * rate / 100

@main
def s02_package_nesting(): Unit =
  val tom = com.horstmann.people.Employee2("Tom", 42_000.0)
  tom.giveRaise(10.0)
  println(s"${tom.name} has salary ${tom.salary}")

  // when absolute path is required, prefix it with _root_
  val bob = _root_.com.horstmann.scala3ed.ch07.com.horstmann.people.Employee2("Bob", 49_000.0)
  println(s"${bob.name} has salary ${bob.salary}")
