package ch.hepia.tp

/*
 * Représente une pile d'entiers
 *
 */
enum IntStack {
  case Elem( top: Int, rest: IntStack )
  case Empty

  /*
   * Retourne vrai ssi la pile est vide
   */
  def isEmpty = this match {
    case Elem(_,_) => false
    case Empty => true
  }


  /*
   * Retourne la taille de la pile.
   * A IMPLEMNTER
   */
    def size: Int = this match {
      case Empty => 0
      case Elem( _, rest ) => 1 + rest.size
    }

    def size_ = {
      def loop( s: IntStack, n: Int ): Int = s match {
        case Empty => n
        case Elem(_, rest ) => loop( rest, n+1 )
      }
      loop(this,0)
    }

  /*
   * Ajoute un élément au sommet de la pile
   * A IMPLEMENTER
   */
    def push( i: Int ): IntStack = Elem( i, this )

  /*
   * Retire et retourne l'élément au sommet de la pile.
   * Si la pile est vide, cause une exception (moche).
   * A IMPLEMENTER
   */
    def pop: (Int,IntStack) = this match {
      case Empty =>
        throw new NoSuchElementException("Empty stack")
      case Elem( i, rest ) => (i, rest)
    }


    def addToTop( is: IntStack ): IntStack = {
      val (i, is2 ) = is.pop
      val (j, is3 ) = is2.pop
      is3.push( i + j )
    }

    def peek( is: IntStack ): Int =
      is.pop._1

    def discard( is: IntStack ): IntStack =
      is.pop._2


    /*
     * Retourne l'élément tout en bas de la pile (sans le supprimer).
     * Si la pile est vide, lève une exception.
     * A IMPLEMENTER
     */
    def bottom: Int = {
      //println( s"BOTTOM: $this" )
      this match {
        case Empty => throw new NoSuchElementException("Empty stack has no bottom")
        case Elem( i, Empty ) => i
        case Elem( _, rest ) => rest.bottom
      }
    }



    private def addReverse(from: IntStack, to: IntStack ): IntStack = from match {
      case Empty => to
      case Elem( top, rest ) => addReverse( rest, to.push( top ) )
    }

    /*
     * Renverse des éléments de la pile. Si la pile est vide,
     * ne fait rien.
     * A IMPLEMENTER
     */
    def reverse: IntStack = addReverse( this, Empty )
    /*
     * Place tous les éléments de la pile 'that' au sommet de la pile
     * actuelle.
     * A IMPLEMENTER
     */
    def pushAll( that: IntStack ): IntStack =
      addReverse( that.reverse, this )

  /*
     * Prend l'élément du sommet de la pile et
     * le place en bas de la pile. Si la pile est
     * vide, ne fait rien.
     * A IMPLEMENTER
     */
    def rotate: IntStack = {
      if( this.isEmpty ) Empty
      else {
        val (i, rest) = this.pop
        rest.reverse.push(i).reverse
      }
    }

    def rotate0: IntStack = this match {
      case Empty => Empty
      case Elem(i,rest) => Empty.push(i).pushAll(rest)
    }
}
