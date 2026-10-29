trait Show[A]:
  def show(a: A): String

extension [A](a: A)(using show: Show[A]) def show: String = show.show(a)

given Show[Int] with
  def show(i: Int): String = i.toString

given Show[Name] with
  def show(name: Name): String = name.fullName

given Show[Address] with
  def show(address: Address): String =
    s"${address.street} ${address.number}, ${address.zip} ${address.city}, ${address.country}"

given Show[Person] with
  def show(p: Person): String = s"${p.name.show} (${p.age}), ${p.address.show}"
