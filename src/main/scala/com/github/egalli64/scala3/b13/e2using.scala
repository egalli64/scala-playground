/*
  https://docs.scala-lang.org/scala3/book/ca-given-using-clauses.html
  https://github.com/egalli64/scala-playground

  Contextual Abstractions - Given Instances and Using Clauses
 */
package com.github.egalli64.scala3.b13

@main
def e2using(): Unit =
  /*
    Given a configuration
   */
  case class Config(port: Int, baseUrl: String)

  /*
    Classic way to work with that configuration
   */

  /**
   * A method that requires the configuration
   *
   * @param path
   *   some required information
   * @param c
   *   the configuration
   * @return
   *   whatever
   */
  def renderWebsite(path: String, c: Config): String =
    println(s"Rendering website on path $path")
    "<html>" + renderWidget(List("cart"), c) + "</html>"

  /**
   * Another method requiring configuration
   *
   * @param items
   *   some required information
   * @param c
   *   the configuration
   * @return
   *   whatever
   */
  def renderWidget(items: List[String], c: Config) =
    println(s"Rendering widget for $items using configuration $c")
    items.toString()

  // generate the configuration
  val config = Config(8080, "docs.scala-lang.org")
  // pass it around
  println(renderWebsite("/home", config))

  /*
    If the configuration does not change throughout most of our code base, we want to ignore it (usually)

    "using" marks parameters as contextual
   */

  /**
   * A configurable website renderer
   *
   * @param path
   *   some required information
   * @param Config
   *   the parameter is unspecified, and used for all the relevant calls
   * @return
   *   whatever
   */
  def renderWebsite2(path: String)(using Config): String =
    println(s"Rendering website on path $path")
    "<html>" + renderWidget2(List("cart")) + "</html>"

  /**
   * Another method requiring configuration
   *
   * @param items
   *   some required information
   * @param c
   *   the configuration used by the caller
   * @return
   *   whatever
   */
  def renderWidget2(items: List[String])(using c: Config) =
    println(s"Rendering widget for $items using configuration $c")
    items.toString()

  // using explicitly a Config object
  renderWebsite2("/extra")(using config)

  /*
     Marking as "given" the canonical value for a particular type
   */
  val config2 = Config(80, "scala-lang.org")
  given Config = config2
  renderWebsite2("/home")

