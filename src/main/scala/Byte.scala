type Bit = 0 | 1

opaque type Byte = (Bit, Bit, Bit, Bit, Bit, Bit, Bit, Bit)

object Byte:
  def apply(b7: Bit, b6: Bit, b5: Bit, b4: Bit, b3: Bit, b2: Bit, b1: Bit, b0: Bit): Byte =
    (b7, b6, b5, b4, b3, b2, b1, b0)

  def fromInt(value: Int): Option[Byte] =
    if value >= 0 && value <= 255 then
      Some(
        (
          ((value >> 7) & 1).toBit,
          ((value >> 6) & 1).toBit,
          ((value >> 5) & 1).toBit,
          ((value >> 4) & 1).toBit,
          ((value >> 3) & 1).toBit,
          ((value >> 2) & 1).toBit,
          ((value >> 1) & 1).toBit,
          (value & 1).toBit
        )
      )
    else None

  // Extension methods for Byte operations
  extension (b: Byte)
    def toInt: Int =
      val (b7, b6, b5, b4, b3, b2, b1, b0) = b
      (b7 << 7) | (b6 << 6) | (b5 << 5) | (b4 << 4) | (b3 << 3) | (b2 << 2) | (b1 << 1) | b0

    def toBinaryString: String =
      val (b7, b6, b5, b4, b3, b2, b1, b0) = b
      s"$b7$b6$b5$b4 $b3$b2$b1$b0"

    def &(other: Byte): Byte =
      val (a7, a6, a5, a4, a3, a2, a1, a0) = b
      val (c7, c6, c5, c4, c3, c2, c1, c0) = other
      Byte(
        (a7 & c7).toBit,
        (a6 & c6).toBit,
        (a5 & c5).toBit,
        (a4 & c4).toBit,
        (a3 & c3).toBit,
        (a2 & c2).toBit,
        (a1 & c1).toBit,
        (a0 & c0).toBit
      )

    def |(other: Byte): Byte =
      val (a7, a6, a5, a4, a3, a2, a1, a0) = b
      val (c7, c6, c5, c4, c3, c2, c1, c0) = other
      Byte(
        (a7 | c7).toBit,
        (a6 | c6).toBit,
        (a5 | c5).toBit,
        (a4 | c4).toBit,
        (a3 | c3).toBit,
        (a2 | c2).toBit,
        (a1 | c1).toBit,
        (a0 | c0).toBit
      )

    def ^(other: Byte): Byte =
      val (a7, a6, a5, a4, a3, a2, a1, a0) = b
      val (c7, c6, c5, c4, c3, c2, c1, c0) = other
      Byte(
        (a7 ^ c7).toBit,
        (a6 ^ c6).toBit,
        (a5 ^ c5).toBit,
        (a4 ^ c4).toBit,
        (a3 ^ c3).toBit,
        (a2 ^ c2).toBit,
        (a1 ^ c1).toBit,
        (a0 ^ c0).toBit
      )

    def unary_~ : Byte =
      val (b7, b6, b5, b4, b3, b2, b1, b0) = b
      Byte(
        (1 - b7).toBit,
        (1 - b6).toBit,
        (1 - b5).toBit,
        (1 - b4).toBit,
        (1 - b3).toBit,
        (1 - b2).toBit,
        (1 - b1).toBit,
        (1 - b0).toBit
      )

  // Helper to convert Int to Bit
  extension (i: Int)
    private def toBit: Bit =
      i match
        case 0 => 0
        case 1 => 1
        case _ => throw new IllegalArgumentException(s"$i is not a valid bit")
