package ch.hepia.tp

//Ensemble d'éléments de type T
case class ISet[T](contains: T => Boolean) {
  /* Ajoute un seul élément à l'ensemble.
   * A IMPLEMENTER
   */
  def add(elt: T): ISet[T] = this.union(ISet.single(elt))

  /* Union d'ensembles.
   * A IMPLEMENTER
   */
  def union(that: ISet[T]): ISet[T] =
    ISet[T](i => this.contains(i) || that.contains(i))

  /* Intersection d'ensembles.
   * A IMPLEMENTER
   */
  def intersection(that: ISet[T]): ISet[T] =
    ISet[T](i => this.contains(i) && that.contains(i))

  /* Différence d'ensembles
   * A IMPLEMENTER
   */
  def difference(that: ISet[T]): ISet[T] =
    ISet[T](i => this.contains(i) && !that.contains(i))

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
  def single[T](t: T) = ISet[T](i => i == t)
}
