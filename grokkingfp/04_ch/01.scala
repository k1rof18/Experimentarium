import scala.collection.immutable.ListMap

def score(word: String) = word.replace("a", "").length()

def bonus(word: String) = if (word.contains("c")) 5 else 0

def penalty(word: String) = if (word.contains("s")) 7 else 0

def wordScore(word: String): Int = {
  return score(word) + bonus(word) - penalty(word)
}

// List(rust, haskell, java, scala, ada)
def rankedWords(words: List[String], wordScore: String => Int): List[String] = {
  words.sortBy(wordScore).reverse
}
