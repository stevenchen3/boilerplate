import org.scalatest._

class TestSuite extends FunSuite with BeforeAndAfter {

  before {
    // populate data here, if any
  }

  after {
    // clean up test data, if any
  }

  test("Check list") {
    assert(List(1, 2, 3) == List(1, 2, 3), "check if list is equal")
  }
}
