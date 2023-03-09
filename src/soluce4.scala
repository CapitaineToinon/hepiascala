package ch.hepia.tp.soluce3

import java.time.LocalDate


case class Person(
  firstName: String,
  lastName: String,
  birth: LocalDate,
  address: Address,
)

case class Address(
  number: String,
  street: String,
  zipcode: String,
  place: String,
  country: String
)

case class Point(x:Int,y:Int)
case class Segment(p1:Point,p2:Point)

def orientation( s: Segment ): (Boolean,Boolean) = s match {
  case Segment( p, q ) if p == q => (false,false)
  case Segment( Point(_,y1), Point(_,y2) ) if y1 == y2 => (true,false)
  case Segment( Point(x1,_), Point(x2,_) ) if x1 == x2 => (false, true)
  case Segment( Point(x1,y1), Point(x2,y2) )
      if (x1 == y1 && x2 == y2 ) | (x1 == -y1 && x2 == -y2 ) => (true, true)
  case Segment( Point(x1,y1), Point(x2,y2) )
      if math.abs(y2-y1) == math.abs(x2-x1) => (true, true)
  case _ => (false,false)
}

case class Vec2( x: Double, y: Double ) {

  def plus( v: Vec2 ): Vec2 = Vec2( x + v.x, y + v.y )
  def +( v: Vec2 ): Vec2 = Vec2( x + v.x, y + v.y )
  def -( v: Vec2 ): Vec2 = Vec2( x - v.x, y - v.y )
  def *( k: Double ): Vec2 = Vec2( k*x, k*y )
  def *( v: Vec2 ): Double = v.x*x + v.y*y
  def ***-***-***( i: Int ) = Vec2(x+i,x-i)
  def norm: Double = math.sqrt( this*this )
}

extension (x: Double) {
  def *( v: Vec2 ) = v*x
}

def demo = {

  val v = Vec2( 0, -1 )
  val w = Vec2( 1, 3 )

  val a_ = v plus w
  val b_ = v.plus(w)

  val a = v + w
  val b = v.+(w)
  val c = v*2 + w

  val d = v ***-***-*** 3

  val e = 2.0 * v



}
