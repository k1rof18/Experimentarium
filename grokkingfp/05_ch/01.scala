case class Book(title: String, authors: List[String])

val books = List(
  Book("FP", List("A", "B")),
  Book("TH", List("C"))
)


def main() = {
  // List[String] = List(A, B, C)
  books.map(_.authors).flatten
}