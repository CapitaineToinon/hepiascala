package ch.hepia.tp6

enum Stack[+T] {
  case Elem(top: T, rest: Stack[T])
  case Empty

  /*
   * Retourne vrai ssi la pile est vide
   */
  def isEmpty = this match {
    case Empty      => true
    case Elem(_, _) => false
  }

  /*
   * Retourne la taille de la pile.
   */
  def size: Int = this match {
    case Elem(_, r) => 1 + r.size
    case Empty      => 0
  }

  def sizeTR: Int = {
    def loop(s: Int, rest: Stack[T]): Int = rest match {
      case Empty      => s
      case Elem(_, r) => loop(s + 1, r)
    }
    loop(0, this)
  }

  /*
   * Ajoute un élément au sommet de la pile
   */
  def push[U >: T](i: U): Stack[U] = Elem(i, this)

  /*
   * Retire et retourne l'élément au sommet de la pile.
   * Si la pile est vide, cause une exception (moche).
   */
  def pop: (T, Stack[T]) = this match {
    case Empty =>
      throw new NoSuchElementException("Empty stack")
    case Elem(v, r) => (v, r)
  }

  /*
   * Prend l'élément du sommet de la pile et
   * le place en bas de la pile. Si la pile est
   * vide, ne fait rien.
   */
  def rotate: Stack[T] = this match {
    case Empty      => this
    case Elem(i, r) => Empty.push(i).pushAll(r)
  }

  /*
   * Retourne l'élément tout en bas de la pile (sans le supprimer).
   * Si la pile est vide, lève une exception.
   */
  def bottom: T = this match {
    case Empty =>
      throw new NoSuchElementException("Empty stack")
    case Elem(i, Empty) => i
    case Elem(_, r)     => r.bottom
  }

  def bottomTR: T = {
    def loop(rest: Stack[T]): T = rest match {
      case Empty =>
        throw new NoSuchElementException("Empty stack")
      case Elem(i, Empty) => i
      case Elem(_, r)     => loop(r)
    }
    loop(this)
  }
  /*
   * Renverse des éléments de la pile. Si la pile est vide,
   * ne fait rien.
   */
  // VERSION TR:
  def reverse: Stack[T] =
    pushAllRev(this, Empty)

  private def pushAllRev[V, W >: V](cur: Stack[V], res: Stack[W]): Stack[W] =
    cur match {
      case Empty      => res
      case Elem(i, r) => pushAllRev(r, res.push(i))
    }

  /*
   * Place tous les éléments de la pile 'that' au sommet de la pile
   * actuelle.
   */
  def pushAll[U >: T](that: Stack[U]): Stack[U] =
    pushAllRev(that.reverse: Stack[U], this)

  /*
   * Retourne une pile modifiée par l'appel d'une fonction
   * sur chaque élément
   */
  def map[U](f: T => U): Stack[U] = this match {
    case Empty           => Empty
    case Elem(top, rest) => Elem(f(top), rest.map(f))
  }
  /*
   * Filtre une pile en enlevant les éléments qui ne réponde pas
   * à un prédicat
   */
  def filter(f: T => Boolean): Stack[T] = this match {
    case Empty => Empty
    case Elem(top, rest) =>
      f(top) match {
        case true  => Elem(top, rest.filter(f))
        case false => rest.filter(f)
      }
  }

  /*
   * Réduit une pile à l'aide d'une fonction binaire. Si la liste est
   * vide, la valeur 'e' est retournée.
   */
  def reduce[U >: T](e: U)(f: (U, U) => U): U = fold(e)(f)

  def fold[U](e: U)(f: (T, U) => U): U = {
    def loop(current: Stack[T], acc: U): U = current match {
      case Elem(top, next) => loop(next, f(top, acc))
      case Empty           => acc
    }

    loop(this, e)
  }

  /*
   * Join deux piles en groupant les éléments par position.
   * si elles sont de longueur différente. Prendre la plus courte.
   */
  def zip[U](that: Stack[U]): Stack[(T, U)] = (this, that) match {
    case (_, Empty) | (Empty, _) => Empty
    case (Elem(t, restT), Elem(u, restU)) =>
      Elem((t, u), restT.zip(restU))
  }
}
