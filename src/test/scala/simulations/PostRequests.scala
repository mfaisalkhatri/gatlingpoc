package simulations

import io.gatling.http.Predef._
import io.gatling.core.Predef._

import scala.util.Random

object PostRequests {

  val rnd = new Random()
  def randomString(length: Int) = {
    rnd.alphanumeric.filter(_.isLetter).take(length).mkString
  }

  val customFeeder = Iterator.continually(Map (
    "name" -> ("Name "+ randomString(6)),
    "job" -> ("Job " + randomString(4))
  ))

  def createNewUser () = {
    feed(customFeeder).
      exec (
        http("Create a new User")
          .post("api/users")
          .body(ElFileBody("data/NewUserTemplate.json")).asJson
          .check(status.is(201))
          .check(jsonPath("$.name").is("${name}"))
          .check(jsonPath("$.job").is("${job}"))
          .check(bodyString.saveAs("responseBody")))
            .exec { session => println(session("responseBody").as[String]); session}
  }
}
