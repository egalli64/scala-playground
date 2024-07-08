/*
    1. Two Sum - https://leetcode.com/problems/two-sum/description/
    LeetCode Easy Problems - https://leetcode.com/problemset/?difficulty=EASY

    My repository with solutions - https://github.com/egalli64/scala-playground
 */
package com.leetcode.easy

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class E0001 extends AnyFunSuite with Matchers:
  test("Example 1") {
    twoSum(Array(2,7,11,15), 9) shouldBe Array(0,1)
  }

  test("Example 2") {
    twoSum(Array(3,2,4), 6) shouldBe Array(1,2)
  }

  test("Example 3") {
    twoSum(Array(3,3), 6) shouldBe Array(0,1)
  }
