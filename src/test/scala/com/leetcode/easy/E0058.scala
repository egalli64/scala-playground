/*
    58. Length of Last Word - https://leetcode.com/problems/length-of-last-word/description/
    LeetCode Easy Problems - https://leetcode.com/problemset/?difficulty=EASY

    My repository with solutions - https://github.com/egalli64/scala-playground
 */
package com.leetcode.easy

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class E0058 extends AnyFunSuite with Matchers:
  test("Example 1") {
    lengthOfLastWord("Hello World") shouldBe 5
  }

  test("Example 2") {
    lengthOfLastWord("   fly me   to   the moon  ") shouldBe 4
  }

  test("Example 3") {
    lengthOfLastWord("luffy is still joyboy") shouldBe 6
  }
