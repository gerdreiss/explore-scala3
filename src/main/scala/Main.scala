import java.time.LocalDate
import scala.util.Random

@main def hello(): Unit =
  println("Hello world!")
  println(msg)

  val person = Person("Mike", LocalDate.of(2010, 1, 1))

  person match
    case Child(name)     => println(s"$name is a child")
    case Teenager(name)  => println(s"$name is a teenager")
    case Adult(name)     => println(s"$name is an adult")
    case Retired(name)   => println(s"$name is probably retired")
    case Dead(name)      => println(s"$name is probably dead")
    case Person(name, _) => println(s"$name is not born yet")

  val r = Random()
  val n =
    if (r.nextBoolean()) java.lang.Double(r.nextDouble().toString())
    else -java.lang.Double(r.nextDouble().toString())

  n match
    case PositiveNumber() => println(s"$n is positive")
    case NegativeNumber() => println(s"$n is negative")
    case _                => println(s"$n is a zero")

def msg = "I was compiled by Scala 3. :)"
