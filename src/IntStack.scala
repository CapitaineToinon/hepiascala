package ch.hepia.tp

/*
 * Représente une pile d'entiers
 */
enum IntStack {
  case Elem(top: Int, rest: IntStack)
  case Empty

  /*
   * Retourne vrai ssi la pile est vide
   */
  def isEmpty = this match {
    case Empty => true
    case _     => false
  }

  /*
   * Retourne la taille de la pile.
   * A IMPLEMNTER
   */
  def size: Int = this match {
    case Empty         => 0
    case Elem(_, rest) => 1 + rest.size
  }

  /*
   * Ajoute un élément au sommet de la pile
   * A IMPLEMENTER
   */
  def push(i: Int): IntStack = Elem(i, this)

  /*
   * Retire et retourne l'élément au sommet de la pile.
   * Si la pile est vide, cause une exception (moche).
   * A IMPLEMENTER
   */
  def pop: (Int, IntStack) = this match {
    case Empty           => throw new NoSuchElementException("Empty stack")
    case Elem(top, rest) => (top, rest)
  }

  /*
   * Prend l'élément du sommet de la pile et
   * le place en bas de la pile. Si la pile est
   * vide, ne fait rien.
   * A IMPLEMENTER
   */
  def rotate: IntStack = this match {
    case Empty           => Empty
    case Elem(top, rest) => Empty.push(top).pushAll(rest)
  }

  /*
   * Retourne l'élément tout en bas de la pile (sans le supprimer).
   * Si la pile est vide, lève une exception.
   * A IMPLEMENTER
   */
  def bottom: Int = this match {
    case Empty            => throw new NoSuchElementException("Empty stack")
    case Elem(top, Empty) => top
    case Elem(top, rest)  => rest.bottom
  }

  /*
   * Renverse des éléments de la pile. Si la pile est vide,
   * ne fait rien.
   * A IMPLEMENTER
   */
  def reverse: IntStack = this match {
    case Empty            => Empty
    case Elem(top, Empty) => Elem(top, Empty)
    case Elem(top, Elem(second, rest)) =>
      Empty.push(top).push(second).pushAll(rest.reverse)
  }

  /*
   * Place tous les éléments de la pile 'that' au sommet de la pile
   * actuelle.
   * A IMPLEMENTER
   */
  def pushAll(that: IntStack): IntStack = that match {
    case Empty           => this
    case Elem(top, rest) => this.pushAll(rest).push(top)
  }

  def equals(that: IntStack): Boolean = (this, that) match {
    case (Empty, Empty) => true
    case (_, Empty)     => false
    case (Empty, _)     => false
    case (a, b) if a.size == b.size => {
      val (topA, restA) = a.pop
      val (topB, restB) = b.pop
      topA == topB && restA.equals(restB)
    }
    case _ => false
  }
}
