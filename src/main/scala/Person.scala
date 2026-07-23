import java.time.LocalDate
import java.time.Period

case class Person(name: String, birthday: LocalDate)

extension (person: Person) def age: Int = Period.between(person.birthday, LocalDate.now()).getYears

object Baby:
  def unapply(person: Person): Option[String] =
    Option.when(person.age == 0)(person.name)

object Child:
  def unapply(person: Person): Option[(String, Int)] =
    Option.when(person.age >= 1 && person.age <= 12)((person.name, person.age))

object Teenager:
  def unapply(person: Person): Option[(String, Int)] =
    Option.when(person.age >= 13 && person.age <= 17)((person.name, person.age))

object Adult:
  def unapply(person: Person): Option[(String, Int)] =
    Option.when(person.age >= 18 && person.age <= 65)((person.name, person.age))

object Retired:
  def unapply(person: Person): Option[(String, Int)] =
    Option.when(person.age > 65 && person.age <= 130)((person.name, person.age))

object Dead:
  def unapply(person: Person): Option[(String, Int)] =
    Option.when(person.age > 130)((person.name, person.age))
