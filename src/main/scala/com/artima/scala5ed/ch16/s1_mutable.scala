/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Mutable Objects - What makes an object mutable?
 */
package com.artima.scala5ed.ch16

@main
def s1_mutable(): Unit =
  /**
   * Used to instantiate mutable objects: their state is var, two methods are provided to change it
   */
  class BankAccount:
    private var _balance: Int = 0

    def balance: Int = _balance

    /**
     * Let the balance grow
     *
     * @param amount
     *   increase
     */
    def deposit(amount: Int): Unit =
      require(amount > 0)
      _balance += amount

    /**
     * Reduce balance
     *
     * @param amount
     *   decrease
     * @return
     *   true when performed
     */
    def withdraw(amount: Int): Boolean =
      if amount > _balance then false
      else
        _balance -= amount
        true

    override def toString: String = s"Balance is $_balance"

  val account = new BankAccount
  println("Just created: " + account)
  account.deposit(100)
  println("After deposit: " + account)
  if account.withdraw(80) then println("After withdraw: " + account)
  if !account.withdraw(80) then println("Can't withdraw: " + account)

  println("Accessing the account balance: " + account.balance)

  // Can't modify the balance outside the class
  // account.balance = 1000
  // account.balance_ = 1000
