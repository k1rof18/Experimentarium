// ft(List("a", "b", "c")) == List("a", "b")
def ft[T](x: List[T]): List[T] = x.slice(0,2)

// lt(List("a", "b", "c")) == List("b", "c")
def lt[T](x: List[T]): List[T] = x.slice(x.length-2, x.length)

// moveFstSndToEnd(List("a", "b", "c")) == List("c", "a", "b")
def moveFstSndToEnd[T](x: List[T]): List[T] = x.slice(2, x.size) ++ ft(x)

// insertBeforeLast(List("a", "b"), "c") == List("a", "b", "c")
def insertBeforeLast[T](x: List[T], y: T): List[T] = x :+ y
