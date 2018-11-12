import java.util.concurrent.TimeUnit

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

//Computation of Futures **in sequence**
def doSomethingLongRunning: Future[Int] = {Future {1+2}}
def doSomethingElseLongRunning: Future[Int] = {Future {3+4}}

def doSomethingVeryLongRunning: Future[Int] =
  for {
    result1 <- doSomethingLongRunning
    result2 <- doSomethingElseLongRunning
  } yield result1 + result2

Await.result(doSomethingVeryLongRunning, Duration.create(1, TimeUnit.SECONDS))
