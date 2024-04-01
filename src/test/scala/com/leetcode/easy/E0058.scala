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
