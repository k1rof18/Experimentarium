import scala.collection.immutable.ListMap

def score(word: String) = word.replace("a", "").length()

def bonus(word: String) = if (word.contains("c")) 5 else 0

def penalty(word: String) = if (word.contains("s")) 7 else 0

def wordScore(word: String): Int = {
  return score(word) + bonus(word) - penalty(word)
}

val data = List("ada", "haskell", "scala", "java", "rust")
// rankedWords(data, wordScore)
def rankedWords(words: List[String], wordScore: String => Int): List[String] = {
  words.sortBy(wordScore).reverse
}

// wordScores(data, wordScore)
def wordScores(words: List[String], wordScore: String => Int): List[Int] = {
  words.map(wordScore)
}

def isPlusNum(wordScore: Int) = wordScore > 0

// highestWord(data, wordScore)
def highestWord(words: List[String], wordScore: String => Int): List[String] = {
  words.filter(w => isPlusNum(wordScore(w)))
}
