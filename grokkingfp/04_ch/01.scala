import scala.collection.immutable.ListMap

// rankedWords(words, wordScore)
def rankedWords(words: List[String], wordScore: String => Int): List[String] = {
  words.sortBy(wordScore).reverse
}

def highScoreWords(words: List[String], wordScore: String => Int): Int => List[String] = {
  higherThan => words.filter(w => wordScore(w) > higherThan)
}

val wordsWithScoreThan1: Int => List[String] = highScoreWords(words, wordScore)

// wordsWithScoreThan1(1))