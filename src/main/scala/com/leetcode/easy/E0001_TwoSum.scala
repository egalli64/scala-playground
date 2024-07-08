/*
    1. Two Sum - https://leetcode.com/problems/two-sum/description/
    LeetCode Easy Problems - https://leetcode.com/problemset/?difficulty=EASY

    My repository with solutions - https://github.com/egalli64/scala-playground

    Given an Int array and target, return indices of the two different elements that they add up to target.
    There would exactly one solution (order is not relevant).
 */
package com.leetcode.easy

/**
 * @param nums
 *   an Int array
 * @param target
 *   the target to be found
 * @return
 *   the indexes of the two elements adding up to target
 */
def twoSum(nums: Array[Int], target: Int): Array[Int] =
  var result: Option[Array[Int]] = None

  for
    i <- 0 until nums.length - 1
    j <- i + 1 until nums.length
    if result.isEmpty
  do if nums(i) + nums(j) == target then result = Some(Array(i, j))

  result.getOrElse(throw new IllegalArgumentException("Bad input array"))
