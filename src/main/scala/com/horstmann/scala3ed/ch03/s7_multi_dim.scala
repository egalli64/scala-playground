/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  3. Working with Arrays
   7. Multidimensional Arrays (array of array)
    Use the overloaded Array.ofDim factory to create them
 */
package com.horstmann.scala3ed.ch03

@main
def s7_multi_dim(): Unit =
  // A squared two-dimensional matrix, three rows, four columns
  val matrix = Array.ofDim[Double](3, 4)
  // No built-in ways to simply convert it to a string, fallback to Java
  println(java.util.Arrays.deepToString(matrix.asInstanceOf[Array[Object]]))

  // A matrix with variable length rows
  val triangle = Array.ofDim[Array[Int]](6)
  for i <- triangle.indices do triangle(i) = Array.ofDim[Int](i + 1)
  println(java.util.Arrays.deepToString(triangle.asInstanceOf[Array[Object]]))
