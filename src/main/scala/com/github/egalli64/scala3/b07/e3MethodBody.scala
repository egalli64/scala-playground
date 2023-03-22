/*
  https://docs.scala-lang.org/scala3/book/methods-most.html
  https://github.com/egalli64/scala-playground

  Method Features - if and match as method body
 */
package com.github.egalli64.scala3.b07

/**
 * 1 - Being if-else an expression, it could be the entire body of a function
 *
 * @param a
 *   any value
 * @return
 *   true if truthy
 */
def isTruthy(a: Any) =
  if a == 0 || a == "" || a == false || a == null then false
  else true

/**
 * 2 - Being match an expression, it could be the entire body of a function
 *
 * @param a
 *   any value
 * @return
 *   true if truthy
 */
def isTruthyMatch(a: Matchable) = a match
  case 0 | "" | false | null => false
  case _                     => true

@main
def methodBody(): Unit =
  println("A non-empty string is truthy, no matter what there is in it: " + isTruthy("false"))
  println("A non-zero number is truthy: " + isTruthyMatch(.42))
