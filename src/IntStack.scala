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
    case Elem(_, _) => false
    case Empty      => true
  }

  /*
   * Retourne la taille de la pile.
   * A IMPLEMNTER
   */
  def size: Int = 0

  /*
   * Ajoute un élément au sommet de la pile
   * A IMPLEMENTER
   */
  def push(i: Int): IntStack = Empty

  /*
   * Retire et retourne l'élément au sommet de la pile.
   * Si la pile est vide, cause une exception (moche).
   * A IMPLEMENTER
   */
  def pop: (Int, IntStack) =
    throw new NoSuchElementException("Empty stack")

  /*
   * Prend l'élément du sommet de la pile et
   * le place en bas de la pile. Si la pile est
   * vide, ne fait rien.
   * A IMPLEMENTER
   */
  def rotate: IntStack = Empty

  /*
   * Retourne l'élément tout en bas de la pile (sans le supprimer).
   * Si la pile est vide, lève une exception.
   * A IMPLEMENTER
   */
  def bottom: Int = 0

  /*
   * Renverse des éléments de la pile. Si la pile est vide,
   * ne fait rien.
   * A IMPLEMENTER
   */
  def reverse: IntStack = Empty

  /*
   * Place tous les éléments de la pile 'that' au sommet de la pile
   * actuelle.
   * A IMPLEMENTER
   */
  def pushAll(that: IntStack): IntStack = Empty

}
