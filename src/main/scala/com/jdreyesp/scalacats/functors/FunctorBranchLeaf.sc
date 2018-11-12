import cats.Functor

/*
Write a Functor for the following binary tree data type. Verify that the code works as expected on instances of Branch and Leaf:
*/

sealed trait Tree[+A]

final case class Branch[A](left: Tree[A], right: Tree[A])
  extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]


//Tree Functor
implicit def treeFunctor : Functor[Tree] = new Functor[Tree] {
  override def map[A, B](tree: Tree[A])(func: A => B): Tree[B] = {
    tree match {
      case Leaf(value) => Leaf(func(value))
      case Branch(left, right) => Branch(map(left)(func), map(right)(func))
    }
  }
}

//Usage

val a = Branch(Leaf(1), Branch(Leaf(2), Leaf(3)))
val b = Leaf(3)

a.map(_ * 2)
b.map(_ * 3)