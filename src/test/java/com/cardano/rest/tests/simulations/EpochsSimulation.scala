package com.cardano.rest.tests.simulations

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder


class EpochsSimulation extends Simulation {
  val httpConf: HttpProtocolBuilder = http.baseUrl("https://explorer.cardano.org/api/")
    .header("Accept", "application/json")
    .proxy(Proxy("localhost", 8888))

  val scn: ScenarioBuilder = scenario("Genesis Summary Scenario").repeat(10) {
    exec(
      http("Genesis Summary")
        .get("genesis/summary")
        .check(status.is(200))
    )
  }

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)
}
