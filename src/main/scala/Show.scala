trait Show[A]:
  def show(a: A): String

given Show[Int] with
  def show(i: Int): String = i.toString

given Show[Person] with
  def show(p: Person): String = s"${p.name} (${p.age})"

extension [A](a: A)(using show: Show[A]) def show: String = show.show(a)
