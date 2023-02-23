package ch.hepia.tp

def dumbCount1( n: Int ): Int =
  if( n == 0 ) 0 else 1 + dumbCount1(n-1)

def dumbCount2( n: Int ): Int = {
  def dumby( m: Int, c: Int ): Int =
    if( m == 0) c else dumby(m-1,c+1)
  dumby( n, 0 )
}

@main
def tp2( n: Int ) = {
  println( dumbCount1( n ) )
  //println( dumbCount2( n ) )
}
