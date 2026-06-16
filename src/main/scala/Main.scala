import java.time.LocalDate
import scala.util.Random
import java.lang.Double as JDouble

@main def hello(): Unit =

  Person("Mike", LocalDate.of(2020, 1, 1)) match
    case p @ Child(name)    => println(s"$name is a ${p.age} years old child")
    case p @ Teenager(name) => println(s"$name is a ${p.age} years old teenager")
    case p @ Adult(name)    => println(s"$name is a ${p.age} years old adult")
    case p @ Retired(name)  => println(s"$name is ${p.age} years old and probably retired")
    case p @ Dead(name)     => println(s"$name would be ${p.age} years old and probably dead")
    case Person(name, _)    => println(s"$name is not born yet")

  val r = Random()
  val n =
    if (r.nextBoolean()) JDouble(r.nextDouble().toString())
    else -JDouble(r.nextDouble().toString())

  n match
    case PositiveNumber() => println(s"$n is positive")
    case NegativeNumber() => println(s"$n is negative")
    case _                => println(s"$n is a zero")
