package ch.hepia.tp

//Ensemble d'éléments de type T
case class ISet[T](contains: T => Boolean) {

  /* Ajoute un seul élément à l'ensemble.
   * A IMPLEMENTER
   */
  def add(elt: T): ISet[T] = this
  /* Union d'ensembles.
   * A IMPLEMENTER
   */
  def union(that: ISet[T]): ISet[T] = this
  /* Intersection d'ensembles.
   * A IMPLEMENTER
   */
  def intersection(that: ISet[T]): ISet[T] = this
  /* Différence d'ensembles
   * A IMPLEMENTER
   */
  def difference(that: ISet[T]): ISet[T] = this

}

object ISet {

  /*
   * Crée un ensemble vide.
   */
  def empty[T] = ISet[T](_ => false)
  /*
   * Crée un ensemble avec un seul élément
   * A IMPLEMENTER
   */
  def single[T](t: T) = empty[T]

}
