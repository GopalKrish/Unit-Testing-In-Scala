package fixtureexample

import com.h2.entities.{Customer, Deposits, Dollars}
import com.h2.services.{CustomerService, ProductService}
import matchersexample.UnitSpec

import java.util.UUID

class ScalaFixtureContextObjectSpec extends UnitSpec{

  trait ACustomer {
    private val service: CustomerService = new CustomerService {}
    private val customerId: UUID = service.createNewCustomer("gopal","krish","gopal@google.com", "1987/2/14")
    val customer: Customer =service.getCustomer(customerId).get
  }

  trait AProduct {
    private val service: ProductService = new ProductService {}
    private val productId: UUID = service.addNewDepositProduct("CoreChecking", 2000, 0.02, 10)
    val product: Deposits =service.getDepositProduct(productId).get
  }

  trait ADollar {
    val fiveThousandDollars = Dollars(5000)
  }

  behavior of "ACustomer"
  it should "return a customer with non-empty email address" in new ACustomer {
    customer.email.toString should not be empty
  }

  behavior of "AProduct"
  it should "return a valid product with more 1000 dollars minimum balance requirement" in new AProduct {
    product.minimumBalancePerMonth should be >= Dollars(1000)
  }

  behavior of "A Product with some money"
  it should "return true for 5000 dollars be greater than the product minimum balance requirement" in new ADollar with AProduct {
    fiveThousandDollars should be > product.minimumBalancePerMonth
  }


}
