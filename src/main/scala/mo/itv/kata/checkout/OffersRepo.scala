package mo.itv.kata.checkout

/**
  * Created by mo on 12/02/2017.
  */
class OffersRepo {
  val activeOffers = Seq(Buy3For20Discount, Buy2For15Discount)

  lazy val OffersToItemsMapping: Map[Offer, Set[Item]] = Map(Buy3For20Discount -> Set(A),
    Buy2For15Discount -> Set(B))
}
