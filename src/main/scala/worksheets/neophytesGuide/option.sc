val names: List[Option[String]] = List(Some("Johanna"), None, Some("Daniel"))
names.map(_.map(_.toUpperCase)) // List(Some("JOHANNA"), None, Some("DANIEL"))
names.flatMap(xs => xs.filter(_.length <7)) // List("JOHANNA", "DANIEL")