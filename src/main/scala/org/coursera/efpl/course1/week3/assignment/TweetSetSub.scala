/*
  Functional Programming Principles in Scala
  https://www.coursera.org/learn/scala-functional-programming
  https://github.com/egalli64/scala-playground

  Week 3 - Data and Abstraction - Practice Programming Assignment: Object-Oriented Sets
 */
package org.coursera.efpl.course1.week3.assignment

/**
 * Empty TweetSet
 * */
class Empty extends TweetSet:
  // nothing to add to the accumulator
  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = acc

  // nothing to filter out
  def filter(p: Tweet => Boolean): TweetSet = this

  // the other will do
  def union(that: TweetSet): TweetSet = that

  // I've cheated here, returning an empty singleton looks cleaner to me
  def mostRetweeted: Tweet = TweetEmpty

  // empty set in, empty list out
  def descendingByRetweet: TweetList = Nil

  // does not contain it
  def contains(tweet: Tweet): Boolean = false

  // non-empty factory
  def incl(tweet: Tweet): TweetSet = NonEmpty(tweet, Empty(), Empty())

  // does not contain it
  def remove(tweet: Tweet): TweetSet = this

  // nothing to do
  def foreach(f: Tweet => Unit): Unit = ()

  override def toString: String = "{empty}"
end Empty

class NonEmpty(elem: Tweet, left: TweetSet, right: TweetSet) extends TweetSet:
  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = //
    left.filterAcc(p, right.filterAcc(p, if p(elem) then acc.incl(elem) else acc))

  def filter(p: Tweet => Boolean): TweetSet = //
    filterAcc(p, Empty())

  def union(that: TweetSet): TweetSet = //
    left.union(right.union(that.incl(elem)))

  def mostRetweeted: Tweet = //

    def max(t1: Tweet, t2: Tweet) = if t1.retweets > t2.retweets then t1 else t2

    max(elem, max(left.mostRetweeted, right.mostRetweeted))

  def descendingByRetweet: TweetList = //
    val mr = mostRetweeted
    Cons(mr, remove(mr).descendingByRetweet)

  /**
   * The following methods are already implemented
   * */
  def contains(x: Tweet): Boolean = //
    if x.text < elem.text then left.contains(x) //
    else if elem.text < x.text then right.contains(x) //
    else true

  def incl(x: Tweet): TweetSet = //
    if x.text < elem.text then NonEmpty(elem, left.incl(x), right) //
    else if elem.text < x.text then NonEmpty(elem, left, right.incl(x)) //
    else this

  def remove(tw: Tweet): TweetSet = //
    if tw.retweets == 0 then left //
    else if tw.text < elem.text then NonEmpty(elem, left.remove(tw), right) //
    else if elem.text < tw.text then NonEmpty(elem, left, right.remove(tw)) //
    else left.union(right)

  def foreach(f: Tweet => Unit): Unit = //
    f(elem)
    left.foreach(f)
    right.foreach(f)

  override def toString: String = s"$left $elem $right"
end NonEmpty

@main
def subSets(): Unit =
  println("An empty set:\n" + Empty())
  println("A non-empty set:\n" + Empty().incl(Tweet("a", "b", 12)))