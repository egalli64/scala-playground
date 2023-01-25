/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 4 - Types and Pattern Matching - Lecture 4.4 - Enums
 */
package org.coursera.efpl.course1.week4

import org.coursera.efpl.course1.week4.PaymentMethod.CreditCard

class Lecture4Suite extends munit.FunSuite:
  test("Expr2") {
    val expected = "x"
    val actual = show2(Expr2.Var(expected))
    assertEquals(actual, expected)
  }

  test("Day of week") {
    val days = DayOfWeek.values

    assertEquals(days(0), DayOfWeek.Monday)
    assertEquals(days(1), DayOfWeek.Tuesday)
    assertEquals(days(2), DayOfWeek.Wednesday)
    assertEquals(days(3), DayOfWeek.Thursday)
    assertEquals(days(4), DayOfWeek.Friday)
    assertEquals(days(5), DayOfWeek.Saturday)
    assertEquals(days(6), DayOfWeek.Sunday)
  }

  test("Direction turn left") {
    val down = Direction.Down
    val actual = down.turnLeft
    assertEquals(actual, Direction.Right)
  }

  test("Credit card equality") {
    val tom = PaymentMethod.CreditCard(Card.Visa, "Tom", 42)
    val tom2 = PaymentMethod.CreditCard(Card.Visa, "Tom", 42)
    val tom3 = tom
    assertEquals(tom, tom2)
    assertEquals(tom, tom3)
  }

  test("Credit card inequality") {
    val tom = PaymentMethod.CreditCard(Card.AmEx, "Tom", 42)
    val tom2 = PaymentMethod.CreditCard(Card.Mastercard, "Tom", 42)
    val tom3 = PaymentMethod.PayPal("tom@tom.com")
    assertNotEquals(tom, tom2)
    assertNotEquals(tom3, PaymentMethod.Cash)
  }