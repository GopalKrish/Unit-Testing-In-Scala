package fixtureexample

import com.h2.entities.Dollars
import com.h2.services.Currency
import matchersexample.UnitSpec

class ScalaFixtureSpec extends UnitSpec{

  behavior of "Currency Equals"

  def fixture = new {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"
  }

  it should "match two 10 USD currencies as equal when using 'should equal' syntax" in {

    val f = fixture
    f.currency1 should equal (f.currency2)
  }

  it should "match two 10 USD currencies as equal when using 'should ===' syntax" in {
    val f = fixture
    f.currency1 should === (f.currency2)
  }

  it should "add two dollar together" in {
    val f = fixture

    (f.currency1.costInDollars + f.currency2.costInDollars) should be >= Dollars(20)
  }
}
