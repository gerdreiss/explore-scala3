import java.lang.Number as JNumber

object PositiveNumber:
  def unapply(n: JNumber): Boolean = n.doubleValue() > 0.0

object NegativeNumber:
  def unapply(n: JNumber): Boolean = n.doubleValue() < 0.0
