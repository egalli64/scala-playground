/*
    Exercism Scala track

    Source: https://exercism.org/tracks/scala
    My solutions: https://github.com/egalli64/scala-playground
 */
package org.exercism.track

import scala.collection.immutable.SortedMap

/**
 * Grade School: exercism.org/tracks/scala/exercises/grade-school
 */
class School:
  type DB = Map[Int, Seq[String]]

  /** The student roster, by grade */
  private var roster: DB = Map()

  /**
   * Add a student to the proper grade
   *
   * @param name
   *   student name
   * @param g
   *   student grade
   */
  def add(name: String, g: Int): Unit = roster = roster + (g -> (roster.getOrElse(g, Nil) :+ name))

  /**
   * Getter
   *
   * @return
   *   the current roster
   */
  def db: DB = roster

  /**
   * The students for the current grade
   *
   * @param g
   *   the grade
   * @return
   *   a the students as a sequence of strings
   */
  def grade(g: Int): Seq[String] = roster.getOrElse(g, Nil)

  /**
   * A copy of the roster, sorted by grade and by name
   *
   * @return
   *   sorted roster
   */
  def sorted: Map[Int, Seq[String]] = SortedMap.from(roster.map((k, v) => (k, v.sorted)))

/** Smoke test */
@main
def gradeSchool(): Unit =
  val school: School = School()

  println(school.db)
  school.add("Tom", 5)
  println(school.db)
  school.add("Bob", 5)
  println(school.db)

  println(school.grade(5))

  school.add("Kim", 1)
  school.add("Kim", 3)
  println(school.sorted)
