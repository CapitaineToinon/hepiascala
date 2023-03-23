package ch.hepia.tp4

import java.util.Date

case class Address(
    street: String,
    zip: String,
    city: String,
    country: String
)

case class Person(
    firstname: String,
    lastname: String,
    birthdate: Date,
    address: Address
)

case class Point(x: Int, y: Int)

case class Segment(p1: Point, p2: Point) {
  def orientation(): (Boolean, Boolean) =
    this match
      case Segment(p1, p2) if p1 == p2 => (false, false)
      case Segment(Point(_, y1), Point(_, y2)) if y1 == y2 =>
        (true, false)
      case Segment(Point(x1, _), Point(x2, _)) if x1 == x2 =>
        (false, true)
      case Segment(Point(x1, y1), Point(x2, y2))
          if Math.abs(x1 - x2) == Math.abs(y1 - y2) =>
        (true, true)
      case _ => (false, false)
}

case class HepiaVector(x: Int, y: Int) {
  def +(other: HepiaVector): HepiaVector =
    HepiaVector(this.x + other.x, this.y + other.y)

  def -(other: HepiaVector): HepiaVector =
    HepiaVector(this.x - other.x, this.y - other.y)

  def *(scalar: Int): HepiaVector =
    HepiaVector(this.x * scalar, this.y * scalar)

  def *(other: HepiaVector): Int =
    this.x * other.x + this.y * other.y

  def norm: Double = Math.sqrt(this * this)
}

@main
def main = {
  {
    val p = Person(
      "John",
      "Doe",
      new Date(1990, 1, 1),
      Address("Rue de la Paix", "1000", "Lausanne", "Switzerland")
    )

    println(p)
  }

  {
    val expected = Array[(Segment, (Boolean, Boolean))](
      (Segment(Point(0, 0), Point(4, 0)), (true, false)),
      (Segment(Point(0, 0), Point(0, 4)), (false, true)),
      (Segment(Point(0, 0), Point(1, 1)), (true, true)),
      (Segment(Point(0, 1), Point(1, 2)), (true, true)),
      (Segment(Point(1, 2), Point(2, 3)), (true, true)),
      (Segment(Point(0, 0), Point(-1, -1)), (true, true)),
      (Segment(Point(0, 0), Point(1, -1)), (true, true)),
      (Segment(Point(0, 0), Point(-1, 1)), (true, true)),
      (Segment(Point(0, 0), Point(0, 0)), (false, false)),
      (Segment(Point(89, 3), Point(3, 45)), (false, false))
    )

    for (e <- expected) {
      val (s, (x, y)) = e
      println(
        s"orientation(${s}) should be (${x}, ${y})} and is ${s.orientation()}"
      )
      assert(s.orientation() == (x, y))
    }
  }

  {
    val v1 = HepiaVector(1, 2)
    val v2 = HepiaVector(4, 5)
    val v3 = HepiaVector(5, 7)

    println(v1 + v2)
    assert(v1 + v2 == v3)

    println(v1 * 2)
    assert(v1 * 2 == HepiaVector(2, 4))

    println(v1 * v2)
    assert(v1 * v2 == 14)

    println(v1.norm)
    assert(v1.norm == Math.sqrt(5))
  }
}
