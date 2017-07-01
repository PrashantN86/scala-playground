package org.stats

/**
  * Created by prashant on 2/7/17.
  */

//TODO  optimization for scale
class StatUtils {

  def calcMean(n : Int, data : Array[Int]) : Double = {
    val sum = data.foldLeft(0)(_+_)
    (sum * 1.0) / n
  }

  def calcMedian(n : Int, data : Array[Int]) : Double = {
    val sorted = data.sortWith(_ < _)
    if(n%2 ==0){
      (sorted(n/2) + sorted((n-1)/2)) / 2.0
    }else  sorted((n/2))
  }

  def calcMod(n : Int, data : Array[Int])  = {

    data.foldLeft(Map.empty[Int, Int]){
      (map,word) => map + (word -> (map.getOrElse(word, 0) + 1))
    }
      .toSeq
      .sortWith { case ((n1, l1), (n2, l2))  =>
        if ( l1 > l2 ) true
        else  if ( l1 == l2 && n1 < n2 ) true else false
      }
      .head._1
  }

  def calcWeightedMean(n : Int, data : Array[Int], weights : Array[Int]) : Double = {
    val sumOfWeights = weights.foldLeft(0)(_+_)
    val zipped = data zip weights
    val prod = zipped.foldLeft(0)((init,t) => init + t._1*t._2)
    prod / sumOfWeights
  }

}
