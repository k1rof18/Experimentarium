// def highScoringWords2(wordScore: String => Int): Int => List[String] => List[String] = {
//   higherThan => words => words.filter(w => wordScore(w) > higherThan)
// }

def highScoringWords2(wordScore: String => Int): (higherThan: Int) => (words: List[String]) => List[String] = {
  higherThan =>
    words =>
      words.filter(w => wordScore(w) > higherThan)
}
