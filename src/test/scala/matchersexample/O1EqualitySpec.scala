package matchersexample

import com.h2.services.Currency
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class O1EqualitySpec extends AnyFlatSpec with Matchers{

  behavior of "Currency"

  it should "match two 10 USD currencies as equal when using should equal matcher" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 should equal ( currency2)
  }

  it should "match two 10 USD currencies as equal when using should === matcher" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 should === ( currency2)
  }

  it should "match two 10 USD currencies as equal when using shouldEqual matcher" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 shouldEqual  ( currency2)
  }

  it should "match two 10 USD currencies as equal when using shouldBe matcher" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 shouldBe  ( currency2)
  }

  it should "match two 10 USD currencies as equal when using should be matcher" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 should be  ( currency2)
  }

  it should "not match 10 USD and  100 USD currencies as equal when using 'should be' matcher" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "100 USD"

    currency1 should not be  ( currency2)
  }

  it should "not match 10 USD and  100 USD currencies as equal when using 'should equal' matcher" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "100 USD"

    currency1 should not equal  ( currency2)
  }
}
