package ch.hepia.tp.soluce5a

/*
 * G     Green
 * Y     Yellow(false)
 * YR    Red(true)
 * R     Red(false)
 * YX    Yellow(true)
 */

enum TrafficLight {
  case Green
  case Red(plusYellow: Boolean)
  case Yellow(blink: Boolean)
}
