package ch.hepia.tp.solution1

//Calcule la valeur absolue d'un double
def abs(x: Double): Double =
  if (x < 0) -x else x

//A IMPLEMENTER
//doit retourner 1 si x est positif, -1 si x est négatif
//et 0 sinon
def sign(x: Double): Double =
  if (x < 0) -1
  else if (x > 0) 1
  else 0

//A IMPLEMENTER
//C'est juste la fonction factorielle
def fac(n: Long): Long =
  if (n < 2) 1 else n * fac(n - 1)

//A IMPLEMENTER
//L'algorithme suivant est en pseudocode. Traduisez le
//en Scala, en utilisant uniquement les mots-clé autorisés
//
//function gcd(a, b)
//    while b ≠ 0
//        t := b
//        b := a mod b
//        a := t
//    return a
def gcd(a: Int, b: Int): Int =
  if (b != 0) gcd(b, a % b) else a

//Calcule l'aire d'un cercle au quel on aurait enlever le carré inscrit
def weirdShapeArea(radius: Double) = {
  val r2 = radius * radius
  val disc = math.Pi * r2
  val square = 2 * r2
  disc - square
}

//A IMPLEMENTER:
//La distance euclidienne entre deux points (x1,y1) et (x2,y2)
def distance(x1: Double, y1: Double, x2: Double, y2: Double) = {
  def diff2(a: Double, b: Double) = (a - b) * (a - b)
  math.sqrt(diff2(x1, x2) + diff2(y1, y2))
}

//A FAIRE
//Décommenter les lignes suivantes une à une
//Essayer de comprendre l'erreur et de la résoudre
//Le résultat final n'a pas d'importance
def foobar(): Int = {
  val x = 2
  val y = x + 1
  if (y.toString == "3")
    println("Trois: " + y)
  y
}

@main
def main = {
  println("TP1 (tout doit être à 'true'):")
  println(s"  Fonction abs: ${abs(-3.1) * sign(-3.1) == -3.1}")
  println(s"  Fonction fac: ${fac(8) == 40320}")
  println(s"  Fonction gcd: ${gcd(1071, 462) == 21}")
  println(s"  Fonction distance (1): ${distance(1, 2, 1, 2) == 0}")
  println(
    s"  Fonction distance (2): ${distance(1, 2, 3, 4) == distance(3, 4, 1, 2)}"
  )
  println(s"  Fonction distance (3): ${distance(1, 0, 0, 1) == math.sqrt(2)}")
}
