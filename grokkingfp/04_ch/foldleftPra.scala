
// val words = List("ada", "haskell", "cccccccccc")
// cumulativeScore(wordScores, words)

def foldleftPra() = {
  println(List(1, 10, 2, 0).foldLeft(0)((t, i) => t+i))
  
  println(List("a", "aaa").foldLeft(0)((t, s) => t+len(s)))
  
  println(List("s", "saas", "a").foldLeft(0)((t, s) => t + s.length - s.replace("s", "").length))
  
  // max
  println(List(1, 10, 2, 0).foldLeft(Int.MinValue)((max, i) => if (i > max) i else max))
}