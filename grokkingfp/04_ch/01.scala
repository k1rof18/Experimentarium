import scala.collection.immutable.ListMap

def score(word: String) = word.replace("a", "").length()

def bonus(word: String) = if (word.contains("c")) 5 else 0

def penalty(word: String) = if (word.contains("s")) 7 else 0

def wordScore(word: String): Int = {
  return score(word) + bonus(word) - penalty(word)
}

val words = List("ada", "haskell", "scala", "java", "rust")
// rankedWords(words, wordScore)
def rankedWords(words: List[String], wordScore: String => Int): List[String] = {
  words.sortBy(wordScore).reverse
}

// wordScores(words, wordScore)
def wordScores(words: List[String], wordScore: String => Int): List[Int] = {
  words.map(wordScore)
}

def highScoreWords(words: List[String], wordScore: String => Int): Int => List[String] = {
  higherThan => words.filter(w => wordScore(w) > higherThan)
}

val wordsWithScoreThan: Int => List[String] = highScoreWords(words, wordScore)

// wordsWithScoreThan(1))