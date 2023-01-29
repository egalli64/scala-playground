/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 6 - Collections - Lecture 6.1 - Other Collections
 */
package org.coursera.efpl.course1.week6

@main
def lecture1(): Unit =
  // Vector, same super trait as List: Seq, that extends Iterable
  val numberVector = Vector(3, 6, 23)
  println("A number vector: " + numberVector)

  // No :: (cons) on vector, use +: / :+ instead
  val x = 42
  println("Prepending x: " + (x +: numberVector))
  println("Appending x: " + (numberVector :+ x))

  // Array and String: Java types, but support Seq operations (and could be implicitly converted to Seq)
  val numberArray = Array(3, 6, 23)
  println("An array (by mkString): " + numberArray.mkString(", "))
  // an array could be mapped
  val doubledArray = numberArray.map(_ * 2)
  println("First element in a mapped (to double) array: " + doubledArray(0))

  val aString = "Hello"
  println("A string: " + aString)
  println("Filtering uppercase from string: " + aString.filter(_.isUpper))

  // Range, for integer: lower/upper bound, step value (default 1)
  // Range (open to the right)
  val ri = 1 until 3
  println(ri)
  ri.foreach(println(_))

  // Range (close)
  val re = 1 to 3
  println(re)
  re.foreach(println(_))

  // Inexact step range
  val sr = 10 to 1 by -2
  println(sr)

  // Exact step range
  val sr2 = 1 until 9 by 2
  println(sr2)

  // methods on sequences
  println("Does exists() 3 in sr2? " + sr2.exists(_ == 3))
  println("Does forall() sr even? " + sr.forall(_ % 2 == 0))

  val zipped = sr.zip(sr2)
  println("Zipped sr and sr2 (with truncation of the longer one): " + zipped)
  println("Unzipping: " + zipped.unzip)

  // Flat map example: all combination of (1..M) and (1..N) - here M = 3, N = 2
  println("Flat mapping: " + (1 to 3).flatMap(x => (1 to 2).map((x, _))))

  /**
   * Scalar product of two vectors
   *
   * @param xs
   *   left vector
   * @param ys
   *   right vector
   * @return
   *   scalar product
   */
  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
    xs.zip(ys).map(_ * _).sum

  println("Scalar product: " + scalarProduct(Vector(1, 2, 3), Vector(3, 2, 1)))

  /**
   * Style exercise, a concise primality check
   *
   * n is prime if the only divisors are 1 and n
   * i.e. all the numbers in 2 .. n-1 are not divisor of n
   *
   * @param n
   *   a number
   * @return
   *   true if prime
   */
  def isPrime(n: Int): Boolean =
    (2 until n).forall(n % _ != 0)

  println(s"${isPrime(42)}, ${isPrime(43)}")
