package org

/**
  * Created by prashant on 1/7/17.
  */
package object jsonSerDe {

  abstract class JSON {
    def write : String
  }

  case class JSeq(elems : List[JSON]) extends JSON {
    override def write: String = "["+elems.map(e => e.write).mkString(",")+"]"
  }

  case class JObj(bindings : Map[String,JSON]) extends JSON {
    override def write: String = {
      val sList = bindings.map( b => b match {
        case (key: String, value: JSON) => {
          "\"" + key + "\":" + value.write
        }
      })
      "{"+sList.mkString(",")+"}"
    }
  }

  case class JStr(str: String) extends JSON {
    override def write: String = "\"" + str + "\""
  }

  case class JNum(num: Double) extends JSON {
    override def write: String = num.toString
  }

  case class JBool(bool: Boolean) extends JSON {
    override def write: String = bool.toString
  }

  case object JNull extends JSON {
    override def write: String = "null"
  }

}

