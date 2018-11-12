import scala.util.Try

//Divide example using Option as the Monad
def parseInt(str: String) : Option[Int] = {
  Try(str.toInt).toOption
}

def divide(a: Int, b: Int): Option[Int] =
  if(b == 0) None else Some(a / b)

def stringDivideBy(aStr: String, bStr: String): Option[Int] =
  for {
    aNum <- parseInt(aStr)
    bNum <- parseInt(bStr)
    ans  <- divide(aNum, bNum)
  } yield ans

stringDivideBy("3", "3")
stringDivideBy("3", "0")

//List example
def listCombination() : List[(Int, Int)] = {
  for {
    x <- (1 to 3).toList
    y <- (4 to 5).toList
  } yield (x, y)
}

listCombination()

