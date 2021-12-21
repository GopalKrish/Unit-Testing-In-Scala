package assertionex

import com.h2.entities.Email
import org.scalatest.WrapWith
import org.scalatest.flatspec.AnyFlatSpec

class EmailSpec extends AnyFlatSpec{

  behavior of "An Email"

  it should "return an Email object for a valid string" in {
    val email = Email("gopal@goole.com")
    assert(email.localPart === "gopal")
    assert(email.domain === "goole.com")
  }

  it should "return another Email object for another valid String" in {
    assertResult("jim"){
      Email("jim@google.com").localPart
    }
  }

  it should "throw an exception when an email does not contain '@' symbol" in {
    assertThrows[IllegalArgumentException] {Email("jim.com")}
  }
  it should "throw an exception when an email does contain more than one '@' symbol" in {
    assertThrows[IllegalArgumentException] {Email("jim2@fk@cko.com")}
  }

  it should "intercept the correct error message when no '@' symbol is provided" in {
    val exception = intercept[IllegalArgumentException] {Email("cko.com")}
    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("does not contain '@'"))
  }

  it should "intercept the correct error message when more '@' symbol is provided" in {
    val exception = intercept[IllegalArgumentException] {Email("sw@rr@cko.com")}
    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("should not contain '@' symbol more than once"))
  }


  it should "return an Email object for a valid string with clue" in {
    val email = Email("gopal@google.com")
    assert(email.localPart === "gopal", "expected localPart is 'gopal'")
    assert(email.domain === "google.com")
  }

  it should "return another Email object for another valid String with clue" in {
    assertResult("jim",  "expected localPart is 'jim'"){
      Email("jim@google.com").localPart
    }
  }

  it should "return an Email object for a valid string WithClue" in {
    val email = Email("gopal@google.com")
    withClue("Email should valid"){
      assertThrows[IllegalArgumentException]{
        Email("gopal.com")
      }
    }

  }


}
