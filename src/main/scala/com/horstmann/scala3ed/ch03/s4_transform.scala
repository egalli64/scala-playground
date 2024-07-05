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
  println("A val array: " + xs.mkString(", "))

  println("Mapping to double")
  val doubled = for x <- xs yield 2 * x
  println("By for comprehension: " + doubled.mkString(", "))
  println("By map method: " + xs.map(_ * 2).mkString(", "))
  println()

  // add a guard to filter the data before applying the change
  println("Filtering and mapping: from even values only, halved")
  val evenHalved = for x <- xs if x % 2 == 0 yield x / 2
  println("By guarded for comprehension: " + evenHalved.mkString(", "))
  println("By filter and map methods: " + xs.filter(_ % 2 == 0).map(_ / 2).mkString(", "))
  println()

  val bs = xs.toBuffer
  bs.insert(2, -1)
  println("An array buffer: " + bs)

  println("Remove negative elements")
  // remove negative elements, the imperative way - looping and changing the collection
  var n = bs.length
  var i = 0
  while i < n do
    if bs(i) >= 0 then i += 1
    else
      bs.remove(i)
      n -= 1
  println("In-place imperative: " + bs)

  bs.insert(2, -1)
  val yielded = for x <- bs if x >= 0 yield x
  println("By guarded for comprehension: " + yielded.mkString(", "))

  bs.insert(2, -1)
  val filtered = bs.filter(_ >= 0)
  println("By filter: " + filtered)

  // remove in-place
  bs.insert(2, -1)
  val elementsToRemove = for i <- bs.indices if bs(i) < 0 yield i
  for i <- elementsToRemove.reverse do bs.remove(i)
  println("In-place more readable: " + bs)
