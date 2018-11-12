import cats.effect.IO

//With side effects

//they are eagerly executed!
val sideEffect1 = println("Hello")
val sideEffect2 = println("World")

//how to encapsulate side effects?


//Here comes IO
//Lazily executed
//Stack safe
val io1 = IO { println("Hello") }
val io2 = IO { println("World") }

val test : IO[Unit] =
  for {
    _ <- io1
    _ <- io2
  } yield ()

test.unsafeRunSync()

