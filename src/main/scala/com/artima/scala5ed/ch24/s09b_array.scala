/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Collections in Depth - Arrays
  - Generic creation at runtime
 */
package com.artima.scala5ed.ch24

import scala.reflect.ClassTag

@main
def s09b_array(): Unit =
  /**
   * Due to type erasure, a support from reflection is required to get the array type, ClassTag
   * stores the required information to be used at runtime. The compiler could often detect the
   * right ClassTag on its own (as in this case)
   *
   * @param xs
   *   a generic vector
   * @tparam T
   *   the actual generic type
   * @return
   *   an array based on the input generic type
   */
  def evenElems[T: ClassTag](xs: Vector[T]): Array[T] =
    val arr = new Array[T]((xs.length + 1) / 2)
    for i <- xs.indices by 2 do arr(i / 2) = xs(i)
    arr

  val intVec = Vector(1, 2, 3, 4, 5)
  val intArr = evenElems(intVec)
  println(s"From $intVec to ${intArr.mkString(", ")}")

  val strVec = Vector("this", "is", "a", "test", "run")
  val strArr = evenElems(strVec)
  println(s"From $strVec to ${strArr.mkString(", ")}")
