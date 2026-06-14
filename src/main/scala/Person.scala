import java.time.LocalDate
import java.time.Period

case class Person(name: String, birthday: LocalDate)

extension (person: Person)
  def age: Int = Period.between(person.birthday, LocalDate.now()).getYears()

object Child:
  def unapply(person: Person): Option[String] =
    Option.when(person.age >= 0 && person.age <= 12)(person.name)

object Teenager:
  def unapply(person: Person): Option[String] =
    Option.when(person.age >= 13 && person.age <= 17)(person.name)

object Adult:
  def unapply(person: Person): Option[String] =
    Option.when(person.age >= 18 && person.age <= 65)(person.name)

object Retired:
  def unapply(person: Person): Option[String] =
    Option.when(person.age > 65 && person.age <= 130)(person.name)

object Dead:
  def unapply(person: Person): Option[String] =
    Option.when(person.age > 130)(person.name)
