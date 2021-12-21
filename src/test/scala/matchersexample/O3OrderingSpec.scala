package matchersexample

import com.h2.services.Currency
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class O3OrderingSpec extends AnyFlatSpec with Matchers{

  behavior of "Currency Conversion Cost in Comparison"

  it should "report equal cost for 10 USD, 10 USD" in {
    val tenUsd : Currency = "10 USD"
    val anotherTenUsd : Currency = "10 USD"

    tenUsd.costInDollars.amount should be >= anotherTenUsd.costInDollars.amount
  }

  it should "report higher cost for 10 USD, 10 USD" in {
    val tenUsd : Currency = "10 USD"
    val hundred : Currency = "100 USD"

    hundred.costInDollars.amount should be > tenUsd.costInDollars.amount
  }

  it should "report 1 USD < 10 USD" in {
    val oneUsd : Currency = "1 USD"
    val tenUsd : Currency = "10 USD"

    oneUsd.costInDollars.amount should be < tenUsd.costInDollars.amount
  }

  it should "report NZD < USD" in {
    "NZD" should be < "USD"
  }

}
