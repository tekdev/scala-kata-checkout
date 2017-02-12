package mo.itv.kata.checkout

import org.scalatest.FunSpec
import org.scalatest.Matchers._
import org.scalatest.prop.TableDrivenPropertyChecks._

/**
  * Created by mo on 11/02/2017.
  */
class BasketImplTest extends FunSpec with BasketImplTestFixture {
  val offersRepo = new OffersRepo
  val basket = new BasketImpl(offersRepo)

  describe("Basket calculation") {
    forAll(basketCalculationTestInputs) { (testcase, inputItems, expectedResult) =>
      it(testcase) {
        basket.calculate(inputItems) shouldBe expectedResult
      }
    }
  }
}

trait BasketImplTestFixture {

  val basketCalculationTestInputs = Table(
    ("testCase", "inputItems", "expectedResult"),
    (s"should apply both ${Buy3For20Discount.offerName} and ${Buy2For15Discount.offerName} offers", Seq(A, A, A, A, B, B, B, D, C), BigDecimal(290)),
    (s"should not apply ${Buy3For20Discount.offerName} offer", Seq(A, A, B, B, D, C), BigDecimal(180.00)),
    (s"should not apply any offers", Seq(A, A, B, D, C), BigDecimal(165))
  )
}
