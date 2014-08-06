package org.virtuslab.unicorn

import play.api.data.format.Formatter
import play.api.db.slick.Config
import play.api.data.format.Formats._

protected[unicorn] class UnicornPlay[Underlying](implicit val underlyingFormat: Formatter[Underlying])
    extends Unicorn[Underlying]
    with PlayIdentifiers[Underlying]
    with HasJdbcDriver {

  override lazy val driver = Config.driver

  override type IdCompanion[Id <: MappedId] = PlayCompanion[Id]
}

class LongUnicornPlay extends UnicornPlay[Long] {
  type BaseId = MappedId // For backward capability
}

object LongUnicornPlay extends LongUnicornPlay
