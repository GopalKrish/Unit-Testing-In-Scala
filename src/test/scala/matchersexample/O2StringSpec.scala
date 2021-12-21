package matchersexample

import com.h2.services.CustomerService
//import org.scalatest.flatspec.AnyFlatSpec
//import org.scalatest.matchers.should.Matchers

//class StringSpec extends AnyFlatSpec with Matchers{

//Extend with common class
class O2StringSpec extends UnitSpec {

  val customerService : CustomerService = new CustomerService {};

  behavior of "Customer service string"

  it should "correctly match the customer email starting with firstname" in {
    val (first, last, email, dateOfBirth) = ("Jhon", "Smith", "jhon@smith.com", "1982/12/31")

    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.email.toString should startWith(first.toLowerCase())
  }

  it should "correctly match the customer email ending with '.com'" in {
    val (first, last, email, dateOfBirth) = ("Jhon", "Smith", "jhon@smith.com", "1982/12/31")

    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.email.toString should endWith(".com")
  }

  it should "correctly match the customer email include '@' symbol" in {
    val (first, last, email, dateOfBirth) = ("Jhon", "Smith", "jhon@smith.com", "1982/12/31")

    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.email.toString should include("@")
  }

  it should "correctly match the customer email as regular expression" in {
    val (first, last, email, dateOfBirth) = ("Jhon", "Smith", "jhon@smith.com", "1982/12/31")

    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.email.toString should include regex "[a-z]+[@.]com"
  }

  it should "correctly match the customer dateOfBirth as fullyMatch regular expression" in {
    val (first, last, email, dateOfBirth) = ("Jhon", "Smith", "jhon@smith.com", "1982/12/31")

    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.dateOfBirth.toString should fullyMatch regex  """[0-9]{4}-[0-9]{2}-[0-9]{2}"""

  }
}
