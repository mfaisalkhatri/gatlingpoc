package simulations

import io.gatling.http.Predef._
import io.gatling.core.Predef._

object ReqResConfig {

  val httpConf = http.baseUrl("https://reqres.in/")
    .header("Accept", "application/json")

  def getProperty(propertyName: String, defaultValue: String) = {
    Option(System.getenv(propertyName))
      .orElse(Option(System.getProperty(propertyName)))
      .getOrElse(defaultValue)
  }

}
