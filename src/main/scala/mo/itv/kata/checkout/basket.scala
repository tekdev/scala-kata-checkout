package mo.itv.kata.checkout

/**
  * Created by mo on 11/02/2017.
  */
trait Basket {

  def calculate(products: Seq[Item]): BigDecimal

}

class BasketImpl(offersRepo: OffersRepo) extends Basket {
  val activeOffers = offersRepo.activeOffers

  override def calculate(products: Seq[Item]): BigDecimal =
    products.map(_.unitPrice).sum - activeOffers.map(_.discount(products)).sum
}

