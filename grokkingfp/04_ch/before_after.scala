val words = List("ada", "haskell", "scala", "java", "rust")

def score(word: String) = word.replace("a", "").length()

def bonus(word: String) = if (word.contains("c")) 5 else 0

def penalty(word: String) = if (word.contains("s")) 7 else 0

def wordScores(word: String): Int = score(word) + bonus(word) - penalty(word)

// [before]
// 関数が何をしているのか分かりにくい
// highScoringWordsの呼び出しを何回も書くの面倒
// 
// def highScoringWords(wordScore: String => Int, words: List[String], than: Int):List[String] = {
//   words.filter(w => wordScore(w) > than)
// }
// highScoringWords(w => score(w) + bonus(w) - penalty(w), words, 1)
// highScoringWords(w => score(w) + bonus(w) - penalty(w), words, 2)

// [after]
// 
// 
def highScoringWords(wordScore: String => Int, words: List[String]): Int => List[String] = {
  higherThan => words.filter(w => wordScore(w) > higherThan)
}

val wordsWithScoreThan: Int => List[String] = highScoringWords(w => score(w) + bonus(w) - penalty(w), words)
// wordsWithScoreThan(1)
// wordsWithScoreThan(2)

// 考え
// 以下のように「wordScores」を用意してスコア計算を関数にしたらよくない...?
// def wordScores(word: String): Int = score(word) + bonus(word) - penalty(word)

// // [before]
// highScoringWords(wordScores, words, 0)

// // [after]
// val wordsWithScoreThan: Int => List[String] = highScoringWords(wordScores, words)
// wordsWithScoreThan(0)