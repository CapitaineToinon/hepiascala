package ch.hepia.tp.soluce2b

def fac( n: Long ): Long = {
  def rec(m: Long, res: Long ): Long =
    if( m <= 1 ) res else rec(m-1, m*res)
  rec( n, 1 )
}

def gcd( a: Int, b: Int ): Int =
  if( b == 0 ) a
  else gcd( b, a%b )




def syracuse1( n: Int ): Int =
  if( n == 1 ) 0
  else {
    val m = if( n % 2 == 0 ) n/2 else 3*n+1
    1 + syracuse1(m)
  }


/*

 int syracuse( int n ) {
    int c = 0;
    while( n != 1 ) {
      if( n % 2 == 0 )
          n = n / 2;
      else
          n = n*3 + 1;
      c++;
    }
    return c;
}
 */

def syracuse2( m: Int ): Int = {
  def rec( n: Int, c: Int ): Int =
    if( n == 1 ) c
    else if( n % 2 == 0)
      rec(n/2,c+1)
    else
      rec(n*3+1,c+1)

  rec(m,0)

}

