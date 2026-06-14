object PositiveNumber:
  def unapply(n: Number): Boolean = n.doubleValue() > 0.0

object NegativeNumber:
  def unapply(n: Number): Boolean = n.doubleValue() < 0.0
