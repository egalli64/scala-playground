package org.coursera.efpl.course1.week3.assignment

class TweetSetSuite extends munit.FunSuite:
  trait TestSets:
    val tA: Tweet = Tweet("a", "a body", 20)
    val tB: Tweet = Tweet("b", "b body", 20)
    val tC: Tweet = Tweet("c", "c body", 7)
    val tD: Tweet = Tweet("d", "d body", 9)

    val s0: Empty = Empty()
    val s1: TweetSet = s0.incl(tA)
    val s2: TweetSet = s1.incl(tB)
    val s2a: TweetSet = Empty().incl(tC).incl(tD)
    val s3: TweetSet = s2.incl(tC)
    val s4: TweetSet = s3.incl(tD)

  def asSet(tweets: TweetSet): Set[Tweet] =
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res

  def size(set: TweetSet): Int = asSet(set).size

  test("Filter acc on empty") {
    new TestSets:
      private val s = s0.filterAcc(_ => true, s1)
      assertEquals(size(s), 1)
      assert(s.contains(tA))
  }

  test("Filter acc on non-empty") {
    new TestSets:
      private val s = s1.filterAcc(_ => true, s2)
      assertEquals(size(s), 2)
      assert(s.contains(tA))
      assert(s.contains(tB))
  }

  test("Filter all on empty") {
    new TestSets:
      assertEquals(size(s0.filter(_ => true)), 0)
  }

  test("Filter on empty") {
    new TestSets:
      assertEquals(size(s0.filter(tw => tw.user == "a")), 0)
  }

  test("Filter all on non-empty") {
    new TestSets:
      private val s = s1.filter(_ => true)
      assertEquals(size(s), size(s1))
  }

  test("Filter by user") {
    new TestSets:
      assertEquals(size(s4.filter(tw => tw.user == "a")), 1)
  }

  test("Filter by retweets") {
    new TestSets:
      assertEquals(size(s4.filter(tw => tw.retweets == 20)), 2)
  }

  test("union") {
    new TestSets:
      assertEquals(size(s2.union(s2a)), 4)
  }

  test("union non-empty empty") {
    new TestSets:
      assertEquals(size(s4.union(s0)), 4)
  }

  test("union empty non-empty") {
    new TestSets:
      assertEquals(size(s0.union(s4)), 4)
  }

  test("descending") {
    new TestSets:
      private val trends = s4.descendingByRetweet
      assert(!trends.isEmpty)
      assert(trends.head.user == "a" || trends.head.user == "b")
  }

  test("most retweeted") {
    new TestSets:
      assertEquals(s4.mostRetweeted.retweets, 20)
  }

  import scala.concurrent.duration.*
  override val munitTimeout: FiniteDuration = 10.seconds
end TweetSetSuite
