package org.jsonSerDe

/**
  * Created by prashant on 1/7/17.
  */
object Test extends App{

  val person = JObj(
    Map(
    "firstName" -> JStr("John"),
    "address" -> JObj(
      Map(
      "streetAddress" -> JStr("21 2nd Street"),
      "city" -> JStr("New York"),
      "state" -> JStr("NY"),
      "postalCode" -> JStr("10021-3100")
      )
    ),
    "phoneNumbers" -> JSeq(
      List(
        JObj(
          Map(
            "type" -> JStr("home"),
            "number" -> JStr("212 555-1234")
          )
        ),
        JObj(
          Map(
            "type" -> JStr("office"),
            "number" -> JStr("646 555-4567")
          )
        )
      )
    ),
    "children" -> JNull
  ))

  print(person.write)

}
