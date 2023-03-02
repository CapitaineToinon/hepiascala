package ch.hepia.tp3

def swap(nums: (Int, Int)): (Int, Int) = {
  val (a, b) = nums
  (b, a)
}

type Point = (Int, Int)

def distance(p1: Point, p2: Point): Double = {
  val (x1, y1) = p1
  val (x2, y2) = p2
  val dx = x1 - x2
  val dy = y1 - y2
  Math.sqrt(dx * dx + dy * dy)
}

type Dms = (Double, Double, Double)
type Degree = Double

def dms_to_degree(dms: Dms): Degree = {
  val (d, m, s) = dms
  d + (m / 60.0) + (s / 3600.0)
}

def degree_to_dms(degree: Degree): Dms = {
  val d = degree.toInt
  val m = ((degree - d) * 60).toInt
  val s = ((degree - d - (m / 60.0)) * 3600)
  (d, m, s)
}

@main
def main = {
  assert(swap((1, 2)) == (2, 1))
  assert(swap((2, 1)) == (1, 2))

  assert(distance((0, 0), (1, 1)) == Math.sqrt(2))
  assert(distance((0, 0), (2, 2)) == Math.sqrt(8))

  var expected: Array[(Degree, Degree)] = Array(
    (
      dms_to_degree((46, 12, 15)),
      46.204
    ),
    (
      dms_to_degree((6, 8, 35)),
      6.1432
    ),
    (
      dms_to_degree((59, 56, 2)),
      59.934
    ),
    (
      dms_to_degree((30, 18, 22)),
      30.306
    )
  )

  for ((a, b) <- expected) {
    assert(f"$a%1.3f" == f"$b%1.3f")
  }
}
