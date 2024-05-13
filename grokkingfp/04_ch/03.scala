// filter

val data = List("scala", "rust", "ada", "sss", "ssss", "ss")

// fl(data, lessFiveLen)
def lessFiveLen(x: String) = x.length() < 5

// fl(data, s)
def s(x: String) = (x.length() - x.replace("s", "").length()) >= 3

def fl(l: List[String], len: String => Boolean) = l.filter(len)

val nums = List(5,1,2,4,0)

// fln(nums, odd)
def odd(x: Int) = x % 2 != 0

// fln(nums, ov4)
def ov4(x: Int) = x > 4

def largerThan(n: Int): Int => Boolean = i => i > n

// nums.filter(largerThan(1))
// nums.filter(largerThan(4))

def fln(l: List[Int], len: Int => Boolean) = l.filter(len)