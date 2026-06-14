import java.time.LocalDate
import scala.util.Random
import java.lang.Double as JDouble

@main def hello(): Unit =

  Person("Mike", LocalDate.of(2020, 1, 1)) match
    case Child(name)     => println(s"$name is a child")
    case Teenager(name)  => println(s"$name is a teenager")
    case Adult(name)     => println(s"$name is an adult")
    case Retired(name)   => println(s"$name is probably retired")
    case Dead(name)      => println(s"$name is probably dead")
    case Person(name, _) => println(s"$name is not born yet")

  val r = Random()
  val n =
    if (r.nextBoolean()) JDouble(r.nextDouble().toString())
    else -JDouble(r.nextDouble().toString())

  n match
    case PositiveNumber() => println(s"$n is positive")
    case NegativeNumber() => println(s"$n is negative")
    case _                => println(s"$n is a zero")
