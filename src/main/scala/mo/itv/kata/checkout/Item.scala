package mo.itv.kata.checkout

/**
  * Created by mo on 11/02/2017.
  */
sealed abstract class Item {
  val unitPrice: BigDecimal
}

case object A extends Item {
  override val unitPrice: BigDecimal = BigDecimal(50)
}

case object B extends Item {
  override val unitPrice: BigDecimal = BigDecimal(30)
}

case object C extends Item {
  override val unitPrice: BigDecimal = BigDecimal(20)
}

case object D extends Item {
  override val unitPrice: BigDecimal = BigDecimal(15)
}