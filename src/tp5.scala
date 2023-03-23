package ch.hepia.tp5

enum Light:
  case On, Off, Blinking;

enum TrafficLight(
    val red: Light,
    val orange: Light,
    val green: Light
):
  case Green extends TrafficLight(Light.Off, Light.Off, Light.On)
  case GreenWithWarning
      extends TrafficLight(Light.Off, Light.Blinking, Light.On)
  case AboutToTurnRed extends TrafficLight(Light.Off, Light.On, Light.Off)
  case AboutToTurnGreen extends TrafficLight(Light.On, Light.On, Light.Off)
  case Red extends TrafficLight(Light.On, Light.Off, Light.Off)
  case Disabled extends TrafficLight(Light.Off, Light.Blinking, Light.Off)

@main
def main = {
  val tl = TrafficLight.Red

  tl match
    case TrafficLight.Green            => println("Go!")
    case TrafficLight.AboutToTurnRed   => println("Slow down!")
    case TrafficLight.Red              => println("Don't go!")
    case TrafficLight.AboutToTurnGreen => println("Get ready!")
    case TrafficLight.Disabled         => println("Traffic light is disabled")
    case _                             => println("Unknown traffic light state")
}
