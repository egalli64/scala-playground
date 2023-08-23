/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Givens - How it works
 */
package com.artima.scala5ed.ch21

@main
def s1_intro(): Unit =
  class PreferredPrompt(val preference: String)

  object Greeter:
    // "using" introduces (one or more) givens (aka: context parameters)
    def greet(name: String)(using prompt: PreferredPrompt): Unit =
      println(s"Welcome, $name. The system is ready.")
      println(prompt.preference)

  class PreferredDrink(val preference: String)

  object Greeter2:
    def greet(name: String)(using prompt: PreferredPrompt, drink: PreferredDrink): Unit =
      println(s"Welcome, $name. The system is ready.")
      println(s"But while you work, why not enjoy a cup of ${drink.preference}?")
      println(prompt.preference)

  object JillPref:
    given prompt: PreferredPrompt =
      PreferredPrompt("Your wish > ")

  object JoePref:
    given prompt: PreferredPrompt =
      PreferredPrompt("relax > ")
    given drink: PreferredDrink =
      PreferredDrink("tea")

  // without importing JillPref.prompt, the call to greet won't compile, no preferred prompt found
  //  import JillPref.prompt
  //  Greeter.greet("Jill")

  // a given can't be passed in as a normal parameter
  // Greeter.greet("Jill")(JillPref.prompt)

  // instead of importing, a context parameter could be explicitly passed by "using"
  Greeter.greet("Jill")(using JillPref.prompt)

  // all givens must be imported
  import JoePref.{prompt, drink}
  // it is not mandatory but, once imported, the gives could be explicitly passed in
  Greeter2.greet("Joe")(using prompt, drink)

  // get the right givens for the current case
  Greeter2.greet("Joe")(using JillPref.prompt, JoePref.drink)
