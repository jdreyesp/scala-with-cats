import cats.Monad
import cats.instances.option._
import cats.instances.list._
import scala.language.higherKinds
import cats.syntax.functor._ // for map
import cats.syntax.flatMap._ // for flatMap

val opt1 = Monad[Option].pure(3)

val opt2 = Monad[Option].flatMap(opt1)(a => Some(a + 2))

val opt3 = Monad[Option].map(opt2)(a => 100 * a)

val list1 = Monad[List].pure(3)

val list2 = Monad[List].
  flatMap(List(1, 2, 3))(a => List(a, a*10))

val list3 = Monad[List].map(list2)(a => a + 123)

//Using
def sumSquare[F[_] : Monad](a: F[Int], b: F[Int]) : F[Int] =
  a.flatMap(x => b.map(y => x*x + y*y))



sumSquare(Option(1), Option(2)) //Some(5)