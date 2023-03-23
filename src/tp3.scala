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

type DmsLatitude = (Int, Int, Double, "N" | "S")
type DmsLongitude = (Int, Int, Double, "W" | "E")
type DmsCoordinate = (DmsLatitude, DmsLongitude)

type DD = Double
type DDCordinate = (DD, DD)

def dms_to_degree(dms: DmsCoordinate): DDCordinate = {
  def compute_degrees(deg: Int, min: Int, sec: Double): DD = {
    deg + min / 60.0 + sec / 3600
  }

  def toDD(dms: DmsLatitude | DmsLongitude): DD = {
    val (deg, min, sec, t) = dms

    val sign = t match {
      case "N" | "E" => 1
      case "S" | "W" => -1
    }

    sign * compute_degrees(deg, min, sec)
  }

  val (lat, lon) = dms
  (toDD(lat), toDD(lon))
}

@main
def main = {
  assert(swap((1, 2)) == (2, 1))
  assert(swap((2, 1)) == (1, 2))

  assert(distance((0, 0), (1, 1)) == Math.sqrt(2))
  assert(distance((0, 0), (2, 2)) == Math.sqrt(8))

  var geneva_dms: DmsCoordinate = ((46, 12, 15.8394, "N"), (6, 8, 35.52, "E"))
  var geneva_dd: DDCordinate = (46.2044, 6.143246)

  println(dms_to_degree(geneva_dms))
}
