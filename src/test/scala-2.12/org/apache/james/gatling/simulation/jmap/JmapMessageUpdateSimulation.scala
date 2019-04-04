package org.apache.james.gatling.simulation.jmap

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import org.apache.james.gatling.control.UserCreator
import org.apache.james.gatling.jmap.scenari.JmapMessageUpdateScenario
import org.apache.james.gatling.simulation.{Configuration, HttpSettings}

class JmapMessageUpdateSimulation extends Simulation {

  private val users = new UserCreator(Configuration.BaseJamesWebAdministrationUrl).createUsersWithInboxAndOutbox(Configuration.UserCount)

  private val scenario = new JmapMessageUpdateScenario()

  setUp(scenario.generate(Configuration.ScenarioDuration, users, Configuration.RandomlySentMails)
    .inject(atOnceUsers(Configuration.UserCount)))
    .protocols(HttpSettings.httpProtocol)
}