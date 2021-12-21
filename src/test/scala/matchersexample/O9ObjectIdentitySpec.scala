package matchersexample

import com.h2.services.CustomerService

class O9ObjectIdentitySpec extends UnitSpec {

  val customerService : CustomerService = new CustomerService {};

  behavior of "CustomerService when creating new customer"

  it should "create one customer for given email address" in {
    val (first, last, email, dateOfBirth) = ("Jhon", "Smith", "jhon@smith.com", "1982/12/31")

    val customerId1 = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customerId2 = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer1 = customerService.getCustomer(customerId1).get
    val customer2 = customerService.getCustomer(customerId2).get

    customer1 should be theSameInstanceAs customer2
  }
}
