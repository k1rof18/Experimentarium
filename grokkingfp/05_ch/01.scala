case class Book(title: String, authors: List[String])

val books = List(
  Book("FP", List("A", "B")),
  Book("TH", List("C"))
)

case class Movie(title: String)

def bookAdaptations(author: String) = {
  if (author == "C") 
    List(Movie("C1"), Movie("CC"))
  else List.empty
}

def main() = {
  // List[String] = List(A, B, C)
  books.map(_.authors).flatten

  // List[String] = List(A, B, C)
  books.flatMap(_.authors)

  // List[Movie] = List(Movie(C1), Movie(CC))
  books
    .flatMap(_.authors)
    .flatMap(bookAdaptations)
}
