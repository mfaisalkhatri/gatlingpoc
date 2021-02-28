package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object ReqRestGetRequests {

  def getListOfUsers () = {
    exec (
      http("Get List of Users")
        .get("api/users?page=2")
        .check(status.is(200))
    )
  }

  def getSingleUser () = {
    exec (
      http("Get Single User")
        .get("api/users/2")
        .check(status.is(200))
    )
  }

  def singleUserNotFound () = {
    exec (
      http("Check Response when single user is not found!!")
        .get("api/users/25")
        .check(status.is(404))
    )
  }
}
