/*
    58. Length of Last Word - https://leetcode.com/problems/length-of-last-word/description/
    LeetCode Easy Problems - https://leetcode.com/problemset/?difficulty=EASY

    My repository with solutions - https://github.com/egalli64/scala-playground
 */
package com.leetcode.easy

/**
 * @param s
 *   a string s consisting of words and spaces
 * @return
 *   the length of the last word in the string
 */
def lengthOfLastWord(s: String): Int =
  s.split(' ').last.length
