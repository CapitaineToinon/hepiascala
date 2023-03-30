package ch.hepia.tp.soluce

//Ensemble d'éléments de type T
case class ISet[T]( contains: T=>Boolean ) {

  def combine( that: ISet[T], op: (Boolean,Boolean)=>Boolean ): ISet[T] =
      ISet[T]{ t =>
        op(this.contains(t),that.contains(t))
      }

  /* Ajoute un seul élément à l'ensemble.
   * A IMPLEMENTER
   */
  def add( elt: T ): ISet[T] = this.union( ISet.single(elt) )
  /* Union d'ensembles.
   * A IMPLEMENTER
   */
  def ||( that: ISet[T] ): ISet[T] = union(that)
  def union_( that: ISet[T] ): ISet[T] = combine( that, (x,y) => x || y )
  def union( that: ISet[T] ): ISet[T] = ISet[T]{ t =>
    this.contains(t) || that.contains(t)
  }
  /* Intersection d'ensembles.
   * A IMPLEMENTER
   */
  def &&( that: ISet[T] ): ISet[T] = intersection(that)
  def intersection_( that: ISet[T] ): ISet[T] =  combine( that, _ && _ )
  def intersection( that: ISet[T] ): ISet[T] = ISet[T]{ t =>
    this.contains(t) && that.contains(t)
  }

  /* Différence d'ensembles
   * A IMPLEMENTER
   */
  def --( that: ISet[T] ) = difference(that)
  def difference_( that: ISet[T] ): ISet[T] = combine( that, _ && ! _ )
  def difference( that: ISet[T] ): ISet[T] = ISet[T]{ t =>
    this.contains(t) && ! that.contains(t)
  }

  def unary_! = complement
  def complement: ISet[T] = ISet[T]{ t => ! this.contains(t) }

}

object ISet {

  /*
   * Crée un ensemble vide.
   */
  def empty[T] = ISet[T]( _ => false )
  /*
   * Crée un ensemble avec un seul élément
   * A IMPLEMENTER
   */
  def single[T]( t0: T ) = ISet[T]( t => t == t0 )

}
