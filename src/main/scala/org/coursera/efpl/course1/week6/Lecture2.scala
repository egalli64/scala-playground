/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 6 - Collections - Lecture 6.2 - Combinatorial Search and For-Expressions
 */
package org.coursera.efpl.course1.week6

/*
  Given n, positive integer, find all pairs i,j with 1 <=j < i < n so that i + j is prime

  Ex: n = 7

  i:    2 3 4 4 5 6 6
  j:    1 2 1 3 2 1 5
  sum:  3 5 5 7 7 7 11

  - Generate i: 2 until n
  - Generate a vector of (i, j) with j in 1 until n
  - Flatten the sequence or, use flatMap() instead
  - Filter to keep the prime only
 */
def isPrime(n: Int): Boolean = (2 until n).forall(n % _ != 0)

def primePairs(n: Int): Seq[(Int, Int)] =
  (2 until n).flatMap(i => (1 until i).map(j => (i, j))).filter((x, y) => isPrime(x + y))

@main
def lecture2(): Unit =
  val n = 7
  println(primePairs(n))

  // For expression
  case class Person(name: String, age: Int)

  val ps = List(Person("Tom", 21), Person("Bob", 15), Person("Kim", 22))
  // person "taken from" when condition holds
  val ps20plusNames = for p <- ps if p.age > 20 yield p.name
  println(ps20plusNames)
  // same as filter + map
  println(ps.filter(_.age > 20).map(_.name))

  // using for expression for prime pairs
  val pairs = for
    i <- 2 until n
    j <- 1 until i
    if isPrime(i + j)
  yield (i, j)

  println(pairs)

  // refactoring of scalar product using for expression
  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
    // xs.zip(ys).map(_ * _).sum
    (for (x, y) <- xs.zip(ys) yield x * y).sum

  println("Scalar product: " + scalarProduct(Vector(1, 2, 3), Vector(3, 2, 1)))
