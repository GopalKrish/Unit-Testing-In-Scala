package fixtureexample

import com.h2.entities.Customer
import com.h2.services.{Currency, CustomerService}
import matchersexample.UnitSpec
import org.scalatest.BeforeAndAfterAll

import java.util.UUID
import scala.util.Random

class BeforeAndAfterAllSpec extends UnitSpec with  BeforeAndAfterAll {
  var customers: List[Customer] = List.empty

  override protected def beforeAll(): Unit = {
    val service = new CustomerService {}
    val gopalId: UUID = service.createNewCustomer("gopal","krish","gopal@google.com", "1987/2/14")
    val mohanId: UUID = service.createNewCustomer("mohan","mathav","mohan@google.com", "1987/2/14")

    customers = List(gopalId, mohanId).map(id => service.getCustomer(id).get)
    info("BeforeAndAfterAll: Customer created, Starting testing")
  }
  override protected def afterAll(): Unit = {
    info("BeforeAndAfterAll: All tests completed. Cleaning up memory")
    customers = List.empty
  }


  it should "report 2 existing customer available" in {
    customers should have size 2
  }

  it should "correctly match that all customer have email from 'google'" in {
    customers.map{ customer =>
      customer.email.toString should include("google")
    }
  }

}
