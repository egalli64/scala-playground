/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  6. Objects and Enumeration
   3. Objects Extending a Class or Trait
 */
package com.horstmann.scala3ed.ch06

@main
def s3_derived_object(): Unit =
  /**
   * A pure abstract class
   *
   * @param description
   *   the point of the undoable action
   */
  abstract class UndoableAction(val description: String):
    def undo(): Unit
    def redo(): Unit

  /**
   * A singleton do-nothing that is-an undoable action
   */
  object DoNothingAction extends UndoableAction("Do nothing"):
    override def undo(): Unit = ()
    override def redo(): Unit = ()
