/*
  https://docs.scala-lang.org/scala3/book/types-union.html
  https://github.com/egalli64/scala-playground

  Types and the Type System - Union Types

  The type A | B represents values that are either of the type A or of the type B.
 */
package com.github.egalli64.scala3.b12

@main
def e2union(): Unit =
  // given two classes, whose objects require a similar management ...
  case class Username(name: String)
  case class Password(hash: String)

  // ... say that this is the similar management required by Username and Password
  def lookupName(name: String) = name == "Tom"
  def lookupPassword(hash: String) = hash == "1234"

  /**
   * We could write a function requiring a union type: the argument could be a Username or a
   * Password
   *
   * @param id
   *   a username or a password
   * @return
   *   true if accepted
   */
  def check(id: Username | Password) = id match
    case Username(name) => lookupName(name)
    case Password(hash) => lookupPassword(hash)
    // case 42 => true // won't compile, just Username or Password are expected

  // won't compile, just Username or Password are expected
  // check("Bob")

  if check(Username("Tom")) then println("As expected, this user is accepted")
  if !check(Username("Bob")) then println("As expected, this user is not accepted")

  if check(Password("1234")) then println("As expected, this password is accepted")
  if !check(Password("4321")) then println("As expected, this password is not accepted")
  println("---")

  /*
    Alternative approach /1: pre-planning a class hierarchy
    Requires more future-telling and clutters the code with the trait type name (not very readable)
   */
  trait UsernameOrPassword2
  case class Username2(name: String) extends UsernameOrPassword2
  case class Password2(hash: String) extends UsernameOrPassword2

  def check2(id: UsernameOrPassword2) = id match
    case Username2(name) => lookupName(name)
    case Password2(hash) => lookupPassword(hash)

  // won't compile, just UsernameOrPassword2 is expected
  // check2("Bob")

  if check2(Username2("Tom")) then println("As expected, this user is accepted")
  if !check2(Username2("Bob")) then println("As expected, this user is not accepted")

  if check2(Password2("1234")) then println("As expected, this password is accepted")
  if !check2(Password2("4321")) then println("As expected, this password is not accepted")
  println("---")

  /*
    Alternative approach /2: tagged union
    Requires explicit wrapping and unwrapping and introduce (again) a not very readable supertype name
   */
  enum UsernameOrPassword3:
    case IsUsername(u: Username)
    case IsPassword(p: Password)

  // simplify access
  import UsernameOrPassword3.*

  def check3(id: UsernameOrPassword3) = id match
    case IsUsername(u) => lookupName(u.name)
    case IsPassword(p) => lookupPassword(p.hash)

  // won't compile, just UsernameOrPassword3 is expected
  // check3("Bob")

  val tom = IsUsername(Username("Tom"))
  val bob = IsUsername(Username("Bob"))
  if check3(tom) then println("As expected, this user is accepted")
  if !check3(bob) then println("As expected, this user is not accepted")

  val tomPwd = IsPassword(Password("1234"))
  val bobPwd = IsPassword(Password("4321"))
  if check3(tomPwd) then println("As expected, this password is accepted")
  if !check3(bobPwd) then println("As expected, this password is not accepted")
  println("---")
