/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 4 - Types and Pattern Matching - Lecture 4.4 - Enums
 */
package org.coursera.efpl.course1.week4

import org.coursera.efpl.course1.week4
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Lecture4Suite extends AnyFunSuite with Matchers:
  test("Expr2") {
    val expected = "x"
    val actual = show2(Expr2.Var(expected))
    actual shouldBe expected
  }

  test("Day of week") {
    val days = DayOfWeek.values

    days(0) shouldBe DayOfWeek.Monday
    days(1) shouldBe DayOfWeek.Tuesday
    days(2) shouldBe DayOfWeek.Wednesday
    days(3) shouldBe DayOfWeek.Thursday
    days(4) shouldBe DayOfWeek.Friday
    days(5) shouldBe DayOfWeek.Saturday
    days(6) shouldBe DayOfWeek.Sunday
  }

  test("Direction turn left") {
    val down = Direction.Down
    val actual = down.turnLeft
    actual shouldBe Direction.Right
  }

  test("Credit card equality") {
    val tom = PaymentMethod.CreditCard(Card.Visa, "Tom", 42)
    val tom2 = PaymentMethod.CreditCard(Card.Visa, "Tom", 42)
    val tom3 = tom
    tom shouldBe tom2
    tom shouldBe tom3
  }

  test("Credit card inequality") {
    val tom = PaymentMethod.CreditCard(Card.AmEx, "Tom", 42)
    val tom2 = PaymentMethod.CreditCard(Card.Mastercard, "Tom", 42)
    val tom3 = PaymentMethod.PayPal("tom@tom.com")
    tom should not be tom2
    tom3 should not be PaymentMethod.Cash
  }
