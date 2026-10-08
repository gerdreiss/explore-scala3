import cats.data.Ior
import zio.*

import java.io.IOException
import java.lang.Double as JDouble
import java.time.LocalDate
import scala.util.Random

object Main extends ZIOAppDefault:
  private val rand = Random()
  private val mike = Person("Mike", LocalDate.of(rand.between(1900, 2030), 1, 1))

  def run: ZIO[ZIOAppArgs & Scope, Any, Any] =
    matchRandomPerson *> matchRandomNumber *> showTypeClass *> exploreIor

  private def matchRandomPerson: IO[IOException, Unit] =
    mike match
      case Baby(name)          => Console.printLine(s"$name is a baby")
      case Child(name, age)    => Console.printLine(s"$name is a $age years old child")
      case Teenager(name, age) => Console.printLine(s"$name is a $age years old teenager")
      case Adult(name, age)    => Console.printLine(s"$name is a $age years old adult")
      case Retired(name, age)  => Console.printLine(s"$name is $age years old and probably retired")
      case Dead(name, age)     => Console.printLine(s"$name would be $age years old and probably dead")
      case Person(name, _)     => Console.printLine(s"$name is not born yet")

  private def matchRandomNumber: IO[IOException, Unit] =
    val n: JDouble =
      if (rand.nextBoolean()) JDouble.parseDouble(rand.nextDouble().toString)
      else -JDouble.parseDouble(rand.nextDouble().toString)

    n match
      case PositiveNumber() => Console.printLine(s"$n is positive")
      case NegativeNumber() => Console.printLine(s"$n is negative")
      case _                => Console.printLine(s"$n is a zero")

  private def showTypeClass: IO[IOException, Unit] =
    Console.printLine(s"Display Person using Show type class: ${mike.show}")

  private def exploreIor: Task[Unit] =
    Ior.fromOptions(
      Option.when(Random.nextBoolean())(()),
      Option.when(Random.nextBoolean())(())
    ) match
      case None    => Console.printLine("None")
      case Some(v) =>
        v match
          case Ior.Left(_)    => Console.printLine("Ior.Left")
          case Ior.Right(_)   => Console.printLine("Ior.Right")
          case Ior.Both(_, _) => Console.printLine("Ior.Both")
