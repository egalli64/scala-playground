package com.github.egalli64.scala3.b02

@main
def onStrings(): Unit =
  val first = "Tom"
  val last = "Jones"
  val salary = 3_000
  val currency = '€'

  // 1. String interpolation
  println(s"Simple string interpolation for $first $last, $salary$currency")

  // 1b. Interpolation with expressions
  println(s"Using an operator: ${salary * 2}, invoking a method: ${Math.sqrt(salary)}")

  // 1c. Interpolation printf style
  println(f"Rounding a double to the second decimal: ${Math.sqrt(salary)}%.2f")

  // 2. Text block with strip margin
  val quote =
    """
      |Per me si va ne la città dolente,
      |per me si va ne l'etterno dolore,
      |per me si va tra la perduta gente
      |""".stripMargin
  println(quote)
