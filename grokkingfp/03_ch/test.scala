import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class InsertBeforeLastSpec extends AnyFlatSpec {
  "insertBeforeLast" should "追加可能なこと" in {
    Main.insertBeforeLast(List("a", "b"), "c") shouldEqual List("a", "b", "c")
  }

  it should "空のリストに追加可能なこと" in {
    Main.insertBeforeLast(List.empty[String], "x") shouldEqual List("x")
  }
}