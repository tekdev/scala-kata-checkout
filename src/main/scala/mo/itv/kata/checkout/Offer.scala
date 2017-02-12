package mo.itv.kata.checkout

/**
  * Created by mo on 11/02/2017.
  */

sealed trait Offer {

  val offers = new OffersRepo

  val offerName: String = getClass.getSimpleName.replace("$", "")
  val discountAmount: BigDecimal

  def discount(items: Seq[Item]): BigDecimal

  /**
    * function to calculate total discount for offers of
    * type "buy N number of items to get X amount of discount"
    *
    * @param items
    * @return BigDecimal total discount
    */
  protected def applyOffer(items: Seq[Item], n: Int): BigDecimal =
    items.groupBy(_.toString) // grouping items by name
      .filter(i => offers.OffersToItemsMapping.get(Offer.this).exists(_.contains(i._2.head))) // only returning items that mapped to the current offer
      .values
      .foldLeft(BigDecimal(0.0))((a, c) => a + c.size / n * discountAmount) // calculating discount per product list
}

/**
  * "Buy 3 and get £20 discount"
  */
case object Buy3For20Discount extends Offer {
  override val discountAmount = 20

  override def discount(items: Seq[Item]): BigDecimal = applyOffer(items, 3)

}

/**
  * Buy 2 and get £15 discount
  */
case object Buy2For15Discount extends Offer {
  override val discountAmount = 15

  override def discount(items: Seq[Item]): BigDecimal = applyOffer(items, 2)
}
