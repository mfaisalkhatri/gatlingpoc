package simulations

import io.gatling.core.Predef._
import scala.concurrent.duration.DurationInt

class ReqResEndToEndTests extends Simulation {

  def userCount: Int = ReqResConfig.getProperty("USERS", "3").toInt
  def rampDuration: Int = ReqResConfig.getProperty("RAMP_DURATION", "10").toInt
  def testDuration: Int = ReqResConfig.getProperty("DURATION", "60").toInt

  before {
    println ("Starting ReqRes End to End Tests.............")
  }

  val scn = scenario("Reqres Tests")
  .forever() {
    exec(ReqRestGetRequests.getListOfUsers())
      .pause(2)
      .exec(ReqRestGetRequests.getSingleUser())
      .pause(1)
      .exec(ReqRestGetRequests.singleUserNotFound())
      .pause(1,5)
      .exec(PostRequests.createNewUser())
      .pause(1)
      .exec(PostRequests.createNewUser())
      .pause(2)
    }



  setUp(
    scn.inject(
      nothingFor(5.seconds),
      atOnceUsers(userCount),
      constantUsersPerSec(userCount) during (10.seconds),
      rampUsers(userCount) during(rampDuration.seconds)
    ))
    .protocols(ReqResConfig.httpConf.inferHtmlResources())
    .maxDuration(testDuration.seconds)
    .assertions(global.responseTime.max.lt(10),
      global.successfulRequests.percent.gt(95)
    )

  after {
    println ("End to End Tests Finished...!!")
  }

}
