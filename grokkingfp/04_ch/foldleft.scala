// val words = List("ada", "haskell", "cccccccccc")
// cumulativeScore(wordScores, words)

def cumulativeScore(wordScore: String => Int, words: List[String]): Int = {
  words.foldLeft(0)((sum, word) => sum + wordScore(word))
}

