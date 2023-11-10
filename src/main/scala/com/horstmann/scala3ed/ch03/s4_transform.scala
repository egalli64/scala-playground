/*
Scala for the Impatient Third Edition - Cay S. Horstmann
Source code shown in the book
Download the zip file from: https://horstmann.com/scala/

https://github.com/egalli64/scala-playground

3. Working with Arrays
 4. Transforming Arrays (in a functional way, the original array does not change)
 */
package com.horstmann.scala3ed.ch03

@main
def s4_transform(): Unit =
  val xs = Array(2, 3, 5, 7, 11)

  // use for comprehension to double each element in the array
  val doubled = for x <- xs yield 2 * x
  println(s"xs is [${xs.mkString(", ")}], result is [${doubled.mkString(", ")}]")
  println(s"Same, by map: [${xs.map(_ * 2).mkString(", ")}]")

  // add a guard to filter the data before applying the change
  val evenHalved = for x <- xs if x % 2 == 0 yield x / 2
  println("After guarded yielding: " + evenHalved.mkString(", "))
  println("Same, by filter and map: " + xs.filter(_ % 2 == 0).map(_ / 2).mkString(", "))

  val bs = xs.toBuffer
  bs.insert(2, -1)
  println("An array buffer: " + bs)

  // remove negative elements, the imperative way
  var n = bs.length
  var i = 0
  while i < n do
    if bs(i) >= 0 then i += 1
    else
      bs.remove(i)
      n -= 1

  println("After removing: " + bs)

  // remove negative elements, the Scala way
  bs.insert(2, -1)
  val yielded = for x <- bs if x >= 0 yield x
  println(s"Again, $bs, by guard and yield: $yielded")

  // remove negative elements, the functional way
  bs.insert(2, -1)
  val filtered = bs.filter(_ >= 0)
  println(s"Again, $bs, by filter: $filtered")

  // remove in-place
  bs.insert(2, -1)
  val elementsToRemove = for i <- bs.indices if bs(i) < 0 yield i
  for i <- elementsToRemove.reverse do bs.remove(i)
  println(s"Again, removing in-place: $bs")
