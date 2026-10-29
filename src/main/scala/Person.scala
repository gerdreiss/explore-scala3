import com.github.javafaker.Faker

import java.time.{LocalDate, Period, ZoneId}

case class Name(fullName: String)
case class Birthdate(date: LocalDate)
case class Address(street: String, number: String, zip: String, city: String, country: String)
case class Person(name: Name, birthday: Birthdate, address: Address)

private val faker = new Faker()

object Name:
  def apply(): Name = Name(faker.name().nameWithMiddle())

object Birthdate:
  def apply(): Birthdate =
    Birthdate(LocalDate.ofInstant(faker.date().birthday().toInstant, ZoneId.systemDefault()))

object Address:
  def apply(): Address =
    Address(
      faker.address().streetName(),
      faker.address().buildingNumber(),
      faker.address().zipCode(),
      faker.address().cityName(),
      faker.address().countryCode()
    )

object Person:
  def apply(): Person =
    Person(Name(), Birthdate(), Address())

extension (person: Person) def age: Int =
  Period.between(person.birthday.date, LocalDate.now()).getYears

object Baby:
  def unapply(person: Person): Option[String] =
    Option.when(person.age == 0)(person.name.fullName)

object Child:
  def unapply(person: Person): Option[(String, Int)] =
    Option.when(person.age >= 1 && person.age <= 12)((person.name.fullName, person.age))

object Teenager:
  def unapply(person: Person): Option[(String, Int)] =
    Option.when(person.age >= 13 && person.age <= 17)((person.name.fullName, person.age))

object Adult:
  def unapply(person: Person): Option[(String, Int)] =
    Option.when(person.age >= 18 && person.age <= 65)((person.name.fullName, person.age))

object Retired:
  def unapply(person: Person): Option[(String, Int)] =
    Option.when(person.age > 65 && person.age <= 130)((person.name.fullName, person.age))

object Dead:
  def unapply(person: Person): Option[(String, Int)] =
    Option.when(person.age > 130)((person.name.fullName, person.age))
