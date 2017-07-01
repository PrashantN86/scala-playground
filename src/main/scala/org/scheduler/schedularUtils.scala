package org.scheduler

import java.util.{Timer, TimerTask}

/**
  * Created by prashant on 2/7/17.
  */

class schedulerUtils {

  val timer = new Timer()

  // A definition of a while-like construct that returns the result of the last iteration
  def poll[T](cond : =>Boolean)(body : =>T) : T = {
    @scala.annotation.tailrec
    def loop(previous : T) : T = if(cond) loop(body) else previous
    if(cond) loop(body) else throw new Exception("Loop must be entered at least once.")
  }

  // repeat a function till a stopCrieteria is fullfilled
  def startPolling[T](f: () => T,stopCriteria : T => Boolean) = {
    val pollingTask = new TimerTask {
      def run() = {
        if(stopCriteria(f())){
          timer.cancel()
        }
      }
    }
    timer.schedule(pollingTask,0,1000)
  }

}
