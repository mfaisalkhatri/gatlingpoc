package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import  scala.concurrent.duration.DurationInt


class TestWithPauseTime extends Simulation{

  val httpConf = http.baseUrl("https://reqres.in/")
    .header("Accept", "application/json")

  before {
    println ("Tests with Pause Time Started.............")
  }

  val scn = scenario ("Pause time Tests")
    .exec(http("Get List of Users from Page 1")
    .get("/api/users?page=1"))
    .pause(1)

    .exec(http("Get Single User")
    .get("/api/user/2"))
    .pause(2000.milliseconds)

    .exec(http("Get List of Resource")
    .get("/api/unknown"))
    .pause(1,20)


    setUp(
      scn.inject(nothingFor(5.seconds),
        atOnceUsers(1))
        .protocols(httpConf.inferHtmlResources())
    )

  after {
    println ("Tests Ends here.....!")
  }
}
