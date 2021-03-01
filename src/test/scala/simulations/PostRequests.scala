package simulations

import com.github.javafaker.Faker
import io.gatling.http.Predef._
import io.gatling.core.Predef._

import scala.util.Random

object PostRequests {

  private var faker = new Faker()

  val customFeeder = Iterator.continually(Map (

    "name" -> faker.name().firstName(),
    "job" -> faker.company().profession()
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
