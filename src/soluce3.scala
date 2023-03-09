package ch.hepia.tp.soluce3

def swap(ij: (Int, Int)): (Int, Int) = {
  val (i, j) = ij
  (j, i)
}

def swap_(ij: (Int, Int)): (Int, Int) =
  (ij._2, ij._1)

type Point = (Double, Double)

def dist(p: Point, q: Point): Double = {
  val (px, py) = p
  val (qx, qy) = q
  def diff2(a: Double, b: Double) = (a - b) * (a - b)
  math.sqrt(diff2(px, qx) + diff2(py, qy))
}

type DMS = (Int, Int, Double, String)
type DMSCoord = (DMS, DMS)
type DD = Double
type DDCoord = (DD, DD)

def convert(pos: DMSCoord): DDCoord = {
  def toDD(d: Int, m: Int, s: Double) =
    d + m.toDouble / 60 + s / 3600
  val (lat, long) = pos
  val ddLat = lat match {
    case (d, m, s, "N") => toDD(d, m, s)
    case (d, m, s, "S") => -toDD(d, m, s)
  }
  val ddLong = long match {
    case (d, m, s, "W") => -toDD(d, m, s)
    case (d, m, s, "E") => toDD(d, m, s)
  }
  (ddLat, ddLong)
}

def convert_(pos: DMSCoord): DDCoord = {
  def toDD(dms: DMS) = {
    var (d, m, s, dir) = dms
    val sign = dir match {
      case "N" | "E" => 1.0
      case "S" | "W" => -1.0
    }
    sign * (d + m / 60.0 + s / 3600)
  }
  val (lat, long) = pos
  (toDD(lat), toDD(long))
}
