/*
  Programming in Scala, 5th Edition - source code shown in the book
  Download the zip file from: https://booksites.artima.com/programming_in_scala_5ed

  https://github.com/egalli64/scala-playground

  Composition and Inheritance - Heighten and widen

  - Classes derived from Element are defined as _private_ in its companion object
  - Ensure lines have the same sizes
 */
package com.artima.scala5ed.ch10

@main
def s14(): Unit =
  object Element:
    private class VectorElement(val contents: Vector[String]) extends Element

    // notice _private_
    private class LineElement(s: String) extends Element:
      val contents: Vector[String] = Vector(s)
      override def width: Int = s.length
      override def height = 1

    private class UniformElement(
        ch: Char,
        override val width: Int,
        override val height: Int
    ) extends Element:
      private val line = ch.toString * width
      def contents: Vector[String] = Vector.fill(height)(line)

    def elem(contents: Vector[String]): Element =
      VectorElement(contents)

    def elem(chr: Char, width: Int, height: Int): Element =
      UniformElement(chr, width, height)

    def elem(line: String): Element =
      LineElement(line)
  end Element

  import Element.elem

  abstract class Element:
    def contents: Vector[String]
    def width: Int = if height == 0 then 0 else contents(0).length
    def height: Int = contents.length

    /**
     * The elements are widened when required before merge
     *
     * @param that
     *   another element (placed below)
     * @return
     *   the merged elements
     */
    def above(that: Element): Element =
      val upper = this.widen(that.width)
      val lower = that.widen(this.width)
      elem(upper.contents ++ lower.contents)

    /**
     * The elements are heighten when required before merge
     *
     * @param that
     *   another element (placed to the right)
     * @return
     *   the merged elements
     */
    def beside(that: Element): Element =
      val before = this.heighten(that.height)
      val after = that.heighten(this.height)
      elem(for (left, right) <- before.contents.zip(after.contents) yield left + right)

    /**
     * Create a widened element, if this width is not enough
     *
     * @param w
     *   the required width
     * @return
     *   the current element, or a new widened one
     */
    def widen(w: Int): Element =
      if w <= width then this
      else
        val left = elem('_', (w - width) / 2, height)
        val right = elem('_', w - width - left.width, height)
        left beside this beside right

    /**
     * Create a heightened element, if this height is not enough
     *
     * @param h
     *   the required height
     * @return
     *   the current element, or a new heightened one
     */
    def heighten(h: Int): Element =
      if h <= height then this
      else
        // half the required lines go on top
        val top = elem('_', width, (h - height) / 2)
        // half the required lines go on bottom
        val bottom = elem('_', width, h - height - top.height)
        top above this above bottom

    override def toString: String = contents.mkString("\n")
  end Element

  println(elem(Vector("hello")) above elem(Vector("world!")))
  println(elem(Vector("one", "two", "three")) beside elem(Vector("one")))
