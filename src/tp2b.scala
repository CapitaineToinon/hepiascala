package ch.hepia.tp2b

def fac(n: Long): Long =
  @annotation.tailrec
  def fac_rec(n: Long, acc: Long): Long =
    if (n < 2) acc else fac_rec(n - 1, acc * n)

  fac_rec(n, 1)

@annotation.tailrec
def gcd(a: Int, b: Int): Int =
  if (b == 0) a else gcd(b, a % b)

def syracuse_1(a: Int): Int =
  if (a == 1) 0
  else {
    val next = if (a % 2 == 0) a / 2 else 3 * a + 1
    1 + syracuse_1(next)
  }

def syracuse_2(a: Int): Int =
  @annotation.tailrec
  def syracuse_rec(a: Int, count: Int): Int =
    if (a == 1) count
    else if (a % 2 == 0) syracuse_rec(a / 2, count + 1)
    else syracuse_rec(3 * a + 1, count + 1)

  syracuse_rec(a, 0)

@main
def main = {
  val expected = Array(
    (1, 0),
    (3, 7),
    (6, 8),
    (7, 16),
    (9, 19),
    (12, 9),
    (15, 17)
  );

  for ((a, b) <- expected) {
    println(s"Testing that ((3 * $a) + 1) leads to 1 in $b steps")
    assert(syracuse_1(a) == b)
    assert(syracuse_2(a) == b)
  }
}
