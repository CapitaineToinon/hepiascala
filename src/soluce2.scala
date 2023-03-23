package ch.hepia.tp.solution2

def f(n: Int): Int =
  if (n == 0) 0 else 1 + f(n - 1)

def dumbCount2(n: Int): Int = {
  def g(m: Int, c: Int): Int =
    if (m == 0) c else g(m - 1, c + 1)

  g(n, 0)
}

// f(2)
// if( 2 == 0 ) 0 else 1 + f(2-1)
// 1 + f(2-1)
// 1 + f(1)
// 1 + ( if( 1 == 0 ) 0 else 1 + f(1-1) )
// 1 + ( 1 + f(1-1) )
// 1 + ( 1 + f(0) )
// 1 + ( 1 + ( if( 0 == 0 ) 0 else 1 + f(0-1) ) )
// 1 + ( 1 + 0 )
// 1 + 1
// 2

// g( 2, 0 )
// if( 2 == 0 ) 0 else g( 2-1, 0+1 )
// g( 2-1, 0+1 )
// g( 1, 1 )
// if( 1 == 0 ) 1 else g( 1-1, 1+1 )
// g( 1-1, 1+1 )
// g( 0, 2 )
// if( 0 == 0 ) 2 else g(0-1,2+1)
// 2
