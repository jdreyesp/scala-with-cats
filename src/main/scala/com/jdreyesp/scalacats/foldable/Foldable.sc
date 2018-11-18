import cats.{Eval, Foldable}
import cats.instances.option._
import cats.instances.stream._
import cats.instances.list._
import cats.instances.int._
import cats.instances.string._
import cats.instances.vector._

//Traditional foldLeft & foldRight implementations
List(1,2,3).foldLeft(0)(_ + _)
List(1,2,3).foldLeft(List.empty[Int])((a, i) => i :: a)
List(1,2,3).foldRight(List.empty[Int])((a, i) => a :: i)

//fold using Cats Eval (stack safe instead
// of recursion) and Foldable

def bigData = (1 to 100000).toStream

//StackOverflowError
//bigData.foldRight(0L)(_ + _)
//This is because Stream doesn't have a stack safe impl for fold

//this prevents the StackOverflowError
val eval : Eval[Long] =
  Foldable[Stream].foldRight(bigData, Eval.now(0L)) {
    (num, eval) => eval.map(_ + num)
  }

eval.value


//With monoids
Foldable[Option].nonEmpty(Option(45))
Foldable[List].find(List(1, 2, 3))(_ % 2 == 0)

Foldable[List].combineAll(List(1, 2, 3))
Foldable[List].foldMap(List(1, 2, 3))(_.toString)

val ints = List(Vector(1, 2, 3), Vector(4, 5, 6))

(Foldable[List] compose Foldable[Vector]).combineAll(ints)