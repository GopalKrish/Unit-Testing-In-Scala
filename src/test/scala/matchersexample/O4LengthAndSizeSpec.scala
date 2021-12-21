package matchersexample

import com.h2.services.CustomerService

import java.util.UUID

class O4LengthAndSizeSpec extends UnitSpec {

  val customerService : CustomerService = new CustomerService {};

  behavior of "Customer service for length"

  it should "return correct length for customer's first and last name" in {
    val (first, last, email, dateOfBirth) = ("Jhon", "Smith", "jhon@smith.com", "1982/12/31")

    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.first should have length first.size
    customer.last should have length last.size
  }

  behavior of "Customer service for size"

  it should "return correct size for number of customer created" in {

    val newCustomer: Seq[(String, String, String, String)] = List(
      ("Jhon", "Smith", "jhon@smith.com", "1982/12/31"),
      ("Amy", "Grove", "amy@grove.com", "1983/11/30")
    )

    val customerId: Seq[UUID] = newCustomer.map(
      newCustomer => customerService.createNewCustomer(newCustomer._1, newCustomer._2, newCustomer._3, newCustomer._4))

    customerId should have size 2
  }


}
