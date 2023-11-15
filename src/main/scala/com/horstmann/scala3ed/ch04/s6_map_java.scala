/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  4. Map, Option, Tuple
   6. Interoperating with Java
 */
package com.horstmann.scala3ed.ch04

import scala.jdk.CollectionConverters.MapHasAsScala
import scala.jdk.CollectionConverters.MapHasAsJava

@main
def s6_map_java(): Unit =
  val jMap = java.time.ZoneId.SHORT_IDS
  println("A Java map: " + jMap)

  val sMap = jMap.asScala
  println("Converted to Scala map: " + sMap)

  println("And back to Java: " + sMap.asJava)
  println("---")

  val jProp = System.getProperties
  println("Java properties: " + jProp)

  val sProp = jProp.asScala
  println("Converted to Scala Map[String, String]: " + sProp)
  println("And back to Java: " + sProp.asJava)
