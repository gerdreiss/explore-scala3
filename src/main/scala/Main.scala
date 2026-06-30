import zio.*

import java.io.IOException
import java.lang.Double as JDouble
import java.time.LocalDate
import scala.util.Random

object Main extends ZIOAppDefault:
  private val r = Random()

  def run: ZIO[ZIOAppArgs & Scope, Any, Any] =
    matchRandomPerson *> matchRandomNumber

  private def matchRandomPerson: IO[IOException, Unit] =
    Person("Mike", LocalDate.of(r.between(1900, 2030), 1, 1)) match
      case p @ Child(name)    => Console.printLine(s"$name is a ${p.age} years old child")
      case p @ Teenager(name) => Console.printLine(s"$name is a ${p.age} years old teenager")
      case p @ Adult(name)    => Console.printLine(s"$name is a ${p.age} years old adult")
      case p @ Retired(name)  => Console.printLine(s"$name is ${p.age} years old and probably retired")
      case p @ Dead(name)     => Console.printLine(s"$name would be ${p.age} years old and probably dead")
      case Person(name, _)    => Console.printLine(s"$name is not born yet")

  private def matchRandomNumber: IO[IOException, Unit] =
    val n: JDouble =
      if (r.nextBoolean()) JDouble.parseDouble(r.nextDouble().toString)
      else -JDouble.parseDouble(r.nextDouble().toString)

    n match
      case PositiveNumber() => Console.printLine(s"$n is positive")
      case NegativeNumber() => Console.printLine(s"$n is negative")
      case _                => Console.printLine(s"$n is a zero")
