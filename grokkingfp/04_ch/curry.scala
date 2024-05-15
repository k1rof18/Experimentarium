def largerThan(x: Int)(i: Int): Boolean = i > x
def divideBy(x: Int)(i: Int): Boolean = i % x == 0
def numOfS(x: Int)(s: String): Boolean = s.length() < x
def containS(x: Int)(s: String): Boolean = s.length() - s.replace("s", "").length() >= 3

val nums = List(5,1,2,4)
// nums.filter(largerThan(4))
// nums.filter(divideBy(2))

val strs = List("russst","ada")
// strs.filter(minCalLen(4))
// strs.filter(containS(2))

