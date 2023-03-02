package ch.hepia.tp2b

def fac(n: Long): Long =
  @annotation.tailrec
  def fac_rec(n: Long, acc: Long): Long =
    if (n < 2) acc else fac_rec(n - 1, acc * n)

  fac_rec(n, 1)

@annotation.tailrec
def gcd(a: Int, b: Int): Int =
  if (b == 0) a else gcd(b, a % b)

@main
def main = {
  println(fac(5));
  println(gcd(10, 5))
}
