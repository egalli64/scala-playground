/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Collections in Depth - Arrays

  Same as Java arrays, still it is generic and compatible with sequences
 */
package com.artima.scala5ed.ch24

@main
def s09a_array(): Unit =
  val a1 = Array(1, 2, 3)
  println("An array: " + a1.mkString(", "))

  val a2 = a1.map(_ * 3)
  println("Mapping: " + a2.mkString(", "))

  val a3 = a2.filter(_ % 2 != 0)
  println("Filtering: " + a3.mkString(", "))

  println("Reversing: " + a3.reverse.mkString(", "))

  /*
    Actually, an ArraySeq could be implicitly used when required
   */
  val seq: collection.Seq[Int] = a1
  println("The array as a sequence: " + seq)

  val a4: Array[Int] = seq.toArray
  println("The sequence converted back to array: " + seq)
  println(s"They are two different objects, comparing by eq gives ${a1 eq seq}")

  /*
    Alternatively, a lighter approach could be used, converting the array to an ArrayOps
   */
  val aSeq: collection.Seq[Int] = a1
  println("Sequence from array " + aSeq)
  println("Reverted " + aSeq.reverse)

  // ArrayOps are rarely seen in real code
  val ops: collection.ArrayOps[Int] = a1
  println(s"ArrayOps from array ${ops.head} ...")
  println(s"Reverted  ${ops.reverse.head} ...")
