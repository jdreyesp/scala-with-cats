//Functions that receive only one parameter turn out to be Functors
val func1: Int => Double =
  (x: Int) => x.toDouble

val func2: Double => Double =
  (x: Double) => x * 2


for {
  x <- Some(func1) //provide Option as a monad to flatMap this into for expression
  y <- Some(func2)
} yield y(1)
