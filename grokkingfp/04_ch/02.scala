// val data = List("scala", "rust", "ada")

// data.map(len)
def len(x: String): Int = x.length

// data.map(countS)
def countS(x: String): Int = x.length - x.replace("s", "").length

val nums = List(1, -10, 2, 0)

// nums.map(convertPN)
def convertPN(x: Int): Int = x * -1

// nums.map(db)
def db(x: Int): Int = x * 2
