package matchersexample

import com.h2.services.{Currency, CustomerService}

class O6EmptinessSpec extends UnitSpec {

  val customerService : CustomerService = new CustomerService {};

  behavior of "Customer for emptiness"

  it should "return empty for customer last name" in {
    val (first, last, email, dateOfBirth) = ("Jhon", "", "jhon@smith.com", "1982/12/31")

    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.last should be (empty)
    customer.last shouldBe empty

    customerId.toString should not be (empty)
  }

  behavior of "Currencies inside wallet"

  it should "be empty when no currencies are added to wallet" in {
    val wallet: List[Currency] = List.empty

    wallet should be (empty)
  }

  it should "not be empty when no currencies are added to wallet" in {
    val wallet: List[Currency] = List("1 USD")

    wallet should not be (empty)
  }

}
