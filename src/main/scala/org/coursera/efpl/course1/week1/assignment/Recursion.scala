package org.coursera.efpl.course1.week1.assignment

import scala.annotation.tailrec

object Recursion:
  /**
   * Exercise 1: Pascal's Triangle
   *
   * <pre>
   *     1
   *    1 1
   *   1 2 1
   *  1 3 3 1
   * 1 4 6 4 1
   * </pre>
   *
   * @param c column zero-based index
   * @param r row zero-based index
   * @return the value in position (c, r)
   * */
  def pascal(c: Int, r: Int): Int =
      if c == 0 || c == r then 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2: Parentheses Balancing
   *
   * Check if a string is balanced wrt parentheses
   *
   * @param chars a string presented as a list of characters
   * @return true if balanced
   */
  def balance(chars: List[Char]): Boolean =
    /**
     * Convert open/close parentheses to -1/1, other chars are 0
     * @param cur the current character
     * @return -1, 0, 1
     */
    def parCheck(cur: Char): Int =
      cur match
        case '(' => 1
        case ')' => -1
        case _ => 0

    /**
     * Tail recursive part of the algorithm
     *
     * @param chars current part of the character sequence
     * @param count keep track of the parentheses history
     * @return true if balanced
     */
    @tailrec
    def balance(chars: List[Char], count: Int): Boolean =
      if chars.isEmpty then return count == 0
      if count < 0 then false else balance(chars.tail, count + parCheck(chars.head))

    // an empty string is balanced, otherwise start recursion
    if chars.isEmpty then true else balance(chars.tail, parCheck(chars.head))

  /**
   * Exercise 3: Counting Change
   *
   * @param money the amount to be changed
   * @param coins the available denominations
   * @return number of possible combination
   */
  def countChange(money: Int, coins: List[Int]): Int =
    /**
     * Recursive part of the algorithm
     *
     * - if money is zero, a combination is found
     * - if money is negative, or there are no coins to check, no combination found
     * - else sum the two possible recursive alternatives, considering two cases
     *  - take the amount for the current coin out, check again all the coins
     *  - do not take the amount out, remove the coin from the check pool
     * @param money current amount to process
     * @param coins denomination to check
     * @return
     * */
    def count(money: Int, coins: List[Int]): Int =
      if money == 0 then 1
      else if money < 0 || coins.isEmpty then 0
      else count(money - coins.head, coins) + count(money, coins.tail)

    // start the recursion only when there is something to work on
    if money == 0 || coins.isEmpty then 0 else count(money, coins)
