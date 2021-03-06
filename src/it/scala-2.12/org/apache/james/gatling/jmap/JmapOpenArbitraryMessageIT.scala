package org.apache.james.gatling.jmap

import org.apache.james.gatling.Fixture
import org.apache.james.gatling.jmap.scenari.JmapOpenArbitraryMessageScenario

class JmapOpenArbitraryMessageIT extends JmapIT {

  before {
    users.foreach(server.sendMessage(Fixture.homer.username))
  }

  scenario((userFeederBuilder, _) => {
    new JmapOpenArbitraryMessageScenario().generate(userFeederBuilder)
  })

}
