package org.bank

import scala.util.{Failure, Success, Try}

/**
  * Created by prashant on 18/7/17.
  */
class BankAccount {

  private var balance = 0

  def deposit(amount : Int) : Try[Int]  = {
    amount match {
      case negative if amount < 0 => Failure(new Exception("Amount can't be negative"))
      case valid if amount > 0 => {
        balance = balance + amount
        Success(balance)
      }
    }
  }

  def withdraw(amount : Int) : Try[Int] ={
    amount match {
      case negative if amount < 0 => Failure(new Exception("Amount can't be negative"))
      case insufficient if amount > balance => Failure(new Exception("Insufficient Funds"))
      case valid if amount <= balance => {
        balance = balance - amount
        Success(balance)
      }
    }
  }
}
