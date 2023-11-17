/*
  Scala for the Impatient Third Edition - Cay S. Horstmann
  Source code shown in the book
  Download the zip file from: https://horstmann.com/scala/

  https://github.com/egalli64/scala-playground

  5. Classes
   7. Nested Classes
 */
package com.horstmann.scala3ed.ch05

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

@main
def s7_nested(): Unit =
  /**
   * A class hosting a nested class
   */
  class Network(val name: String):
    /**
     * Each Network object has its own nested Member class
     *
     * @param name
     *   the network member name
     */
    class Member(val name: String):
      // each member could have as contacts only members of the same network
      val contacts: ArrayBuffer[Member] = ArrayBuffer[Member]()

      def description = s"$name inside ${Network.this.name}"

      /**
       * each member could have as friends members of any network
       *
       * Network#Member is a _type projection_, like a Java inner class
       */
      val friends: ArrayBuffer[Network#Member] = ArrayBuffer[Network#Member]()

      /**
       * To achieve a behavior closer to Java, nest Member to the Network companion object
       */
      val connections: ArrayBuffer[Network.NetMember] = ArrayBuffer[Network.NetMember]()

    private val members = ArrayBuffer[Member]()
    private val netMembers = ArrayBuffer[Network.NetMember]()

    def join(name: String): Member =
      val m = Member(name)
      members += m
      m

    def netJoin(name: String): Network.NetMember =
      val m = Network.NetMember(name)
      netMembers += m
      m

  object Network:
    class NetMember(val name: String):
      val contacts: ArrayBuffer[NetMember] = ArrayBuffer[NetMember]()

  val chatter = Network("Chatter")
  val myFace = Network("MyFace")

  // chatter.Member is a different class from myFace.Member
  val tom = chatter.Member("Tom")
  val bob = myFace.Member("Bob")
  val kim = myFace.Member("Kim")

  bob.contacts += kim

  // won't compile, bob is not a chatter.Member
  // tom.contacts += bob

  tom.friends += bob

  val tim = chatter.netJoin("Tim")
  val jim = myFace.netJoin("Jim")
  tim.contacts += jim

  val bo = chatter.join("Bo")
  println(bo.description)
